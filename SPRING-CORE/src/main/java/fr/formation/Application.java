package fr.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.musicien.Guitariste;
import fr.formation.musicien.Pianiste;

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
		
		// On extrait le pianiste du contexte de SPRING
		Pianiste pianiste = context.getBean(Pianiste.class);
		
		pianiste.jouer();
	}
}
