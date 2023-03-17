package fr.formation.config.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtHeaderAuthorizationFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// Récupération de l'en-tête HTTP "Authorization"
		String header = request.getHeader("Authorization");
		
		if (header != null && header.equals("ADMIN")) {		
			// Création d'une liste d'autorités qu'on va donner à l'Authentication
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			// Ajout du role "ADMIN"
			// Le fait d'utilisateur "ROLE_", indique à Spring Security que cette autorisation est en réalité en rôle
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
			// Création d'une nouvelle Authentication Spring
			Authentication authentication = new UsernamePasswordAuthenticationToken("bidon", null, authorities);
			
			// Pour la redonner à Spring Security Context
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		// Penser à appeler cette méthode, sinon la chaine s'arrête ici !
		filterChain.doFilter(request, response);
	}
}
