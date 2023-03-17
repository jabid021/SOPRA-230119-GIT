package fr.formation.config.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import fr.formation.dao.IUtilisateurDao;
import fr.formation.model.Utilisateur;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtHeaderAuthorizationFilter extends OncePerRequestFilter {
	@Autowired
	private IUtilisateurDao daoUtilisateur;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		// Récupération de l'en-tête HTTP "Authorization"
		String header = request.getHeader("Authorization");
		
		// Extraction du jeton ("Bearer <jeton>")
		String token = null;
		
		if (header != null) {
			token = header.substring(7);
		}
		
		// On valide le jeton et on récupère le username
		Optional<String> optUsername = JwtUtil.getUsername(token);
		
		// Si on a le username, c'est que le jeton est valide
		if (optUsername.isPresent()) {
			String username = optUsername.get();
			Optional<Utilisateur> optUtilisateur = this.daoUtilisateur.findByUsername(username);
			
			//Si on a trouvé l'utilisateur, on crée le nouvel Authentication
			if (optUtilisateur.isPresent()) {
				// Création d'une liste d'autorités qu'on va donner à l'Authentication
				List<GrantedAuthority> authorities = new ArrayList<>();
				
				//Si l'utilisateur est admin
				if (optUtilisateur.get().isAdmin()) {
					// Ajout du role "ADMIN"
					// Le fait d'utilisateur "ROLE_", indique à Spring Security que cette autorisation est en réalité en rôle
					authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				}
				
				else {
					authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				}
				
				// Création d'une nouvelle Authentication Spring
				Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
				
				// Pour la redonner à Spring Security Context
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		
		// Penser à appeler cette méthode, sinon la chaine s'arrête ici !
		filterChain.doFilter(request, response);
	}
}
