package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/erreur")
public class ErrorController {
	@GetMapping
	public String afficherErreur() {
		return "error";
	}
}
