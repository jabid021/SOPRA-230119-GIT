package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.request.UserRequest;

@Controller // Managée par SPRING en tant que Controller
@RequestMapping("/accueil") // Préfixer tous les mappings de la classe
public class HomeController {
	
	// On mappe la méthode sur la ressource HTTP "/accueil"
//	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	@GetMapping
	public String afficherAccueil() {
		return "/WEB-INF/views/home.jsp";
	}
	
	@PostMapping
//	public String seConnecter(@RequestParam String username, @RequestParam String password, Model model) {
	public String seConnecter(UserRequest user, Model model) {
		System.out.println("Le user " + user.getUsername() + " se connecte ...");

		if (user.getUsername().equals("toto") && user.getPassword().equals("tata")) {
			model.addAttribute("utilisateur", user);
			
			return "/WEB-INF/views/home.jsp";
		}
		
		else {
//			return "/WEB-INF/views/error.jsp";
			return "redirect:/erreur";
		}
	}
}
