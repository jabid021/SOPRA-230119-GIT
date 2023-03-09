package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Managée par SPRING en tant que Controller
public class HomeController {
	
	// On mappe la méthode sur la ressource HTTP "/accueil"
//	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	@GetMapping("/accueil")
	public String afficherAccueil() {
		return "/WEB-INF/views/home.jsp";
	}
	
	@PostMapping("/accueil")
	public String seConnecter(@RequestParam String username, Model model) {
		System.out.println("Le user " + username + " se connecte ...");

		model.addAttribute("utilisateur", username);
		
		return "/WEB-INF/views/home.jsp";
	}
}
