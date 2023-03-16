package fr.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.IUtilisateurDao;
import fr.formation.model.Utilisateur;
import fr.formation.request.UserRequest;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurApiController {
	@Autowired
	private IUtilisateurDao daoUtilisateur;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/connexion")
	public boolean connexion(@RequestBody UserRequest userRequest) {
		this.authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword())
		);
		
		// Si on arrive ici, c'est que la connexion a fonctionnée
		// On pourra mettre en place des mécaniques, comme par exemple, la génération d'un jeton de connexion ...
		
		return true;
	}
	
	@PostMapping("/inscription")
	public Utilisateur inscription(@RequestBody UserRequest userRequest) {
		Utilisateur utilisateur = new Utilisateur();
		
//		BeanUtils.copyProperties(userRequest, utilisateur);
		utilisateur.setUsername(userRequest.getUsername());
		
		// Attention, il faut penser à encoder le mot de passe !
		utilisateur.setPassword(this.passwordEncoder.encode(userRequest.getPassword()));
		
		return this.daoUtilisateur.save(utilisateur);
	}
	
}
