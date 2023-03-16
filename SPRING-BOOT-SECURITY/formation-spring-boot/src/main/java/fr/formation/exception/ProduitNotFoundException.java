package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Si cette Exception est levée, elle sera catchée par SPRING MVC
// Spring MVC verra l'annotation @ResponseStatus
// Et pourra adapter la réponse HTTP en conséquence
// > Si cette Exception est levée, Spring retourner un statut 404 NOT FOUND
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitNotFoundException extends RuntimeException {

}
