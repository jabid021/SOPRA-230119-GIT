package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.formLogin(); // Activer l'authentification par formulaire de connexion
//		http.httpBasic(); // Activer l'authentification par Http Basic
		
		// Pour gérer les différents accès
		http.authorizeHttpRequests(authorize -> {
//			authorize.requestMatchers("/api/produit").authenticated();
			
//			authorize.requestMatchers("/api/produit").permitAll();
			
//			authorize.requestMatchers("/api/produit").hasRole("USER");
			authorize.requestMatchers("/api/produit").hasAnyRole("USER", "ADMIN");
			authorize.requestMatchers("/api/**").hasRole("ADMIN");
		});
		
		
		return http.build();
	}
	
	@Bean
    public static MethodSecurityExpressionHandler methodExpressionHandler(RoleHierarchy roleHierarchy) {
        DefaultMethodSecurityExpressionHandler hdlr = new DefaultMethodSecurityExpressionHandler();

        hdlr.setRoleHierarchy(roleHierarchy);

        return hdlr;
    }
	
	@Bean
	public RoleHierarchy roleHierarchy() {
		String hierarchy = """
			ROLE_ADMIN > ROLE_USER
		""";
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		
		roleHierarchy.setHierarchy(hierarchy);
		
		return roleHierarchy;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
	public UserDetailsService inMemory(PasswordEncoder passwordEncoder) {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		System.out.println(passwordEncoder.encode("Not24Get"));
		
		manager.createUser(
			User
				.withUsername("user")
				// On peut lui préciser, en préfix de mot de passe, le type d'encodage
				// NoOperator (noop) => Pas d'encodage
				.password(passwordEncoder.encode("Not24Get"))
				.roles("USER")
				.build()
		);
		
		manager.createUser(
			User
				.withUsername("admin")
				.password(passwordEncoder.encode("Not24Get"))
				.roles("ADMIN")
				.build()
		);
		
		return manager;
	}
}
