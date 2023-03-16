package fr.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoApiController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping
	public String hello() {
		// Démonstration d'utilisation des mécaniques de connexion
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("username", "password"));
		
		return "Hello";
	}
}
