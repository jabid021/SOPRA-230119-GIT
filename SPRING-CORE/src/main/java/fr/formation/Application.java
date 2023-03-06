package fr.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.musicien.Guitariste;

public class Application {
	public static void main(String[] args) {
//		Guitariste guitariste = new Guitariste();
//		
//		guitariste.jouer();
		
		// On démarre le contexte de SPRING
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		// On extrait le guitariste du contexte de SPRING
		Guitariste guitariste = context.getBean(Guitariste.class);
		
		guitariste.jouer();
	}
}
