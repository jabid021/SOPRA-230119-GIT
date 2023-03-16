package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.formLogin(); // Activer l'authentification par formulaire de connexion
		http.httpBasic(); // Activer l'authentification par Http Basic
		
		// Pour gérer les différents accès
		http.authorizeHttpRequests(authorize -> {
//			authorize.requestMatchers("/api/produit").authenticated();
			
			authorize.requestMatchers("/api/produit").permitAll();
			authorize.requestMatchers("/api/**").hasRole("ADMIN");
		});
		
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService inMemory() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(
			User
				.withUsername("user")
				// On peut lui préciser, en préfix de mot de passe, le type d'encodage
				// NoOperator (noop) => Pas d'encodage
				.password("{noop}Not24Get")
				.roles("USER")
				.build()
		);
		
		return manager;
	}
}
