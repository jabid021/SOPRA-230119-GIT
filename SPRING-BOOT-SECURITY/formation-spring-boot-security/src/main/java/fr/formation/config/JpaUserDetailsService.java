package fr.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.dao.IUtilisateurDao;
import fr.formation.model.Utilisateur;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	private IUtilisateurDao daoUtilisateur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = this.daoUtilisateur
			.findByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("Utilisateur pas trouvé."));
		
		UserBuilder userBuilder = User
				.withUsername(username)
				.password(utilisateur.getPassword());
		
		if (utilisateur.isAdmin()) {
			userBuilder.roles("ADMIN");
		}
		
		else {
			userBuilder.roles("USER");
		}
		
		return userBuilder.build();
	}
}
