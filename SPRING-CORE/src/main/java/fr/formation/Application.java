package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musicien.Guitariste;
import fr.formation.musicien.Pianiste;

public class Application {
	public static void main(String[] args) {
//		Guitariste guitariste = new Guitariste();
//		
//		guitariste.jouer();
		
		// On démarre le contexte de SPRING
		// Configuration XML
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		
		// Configuration JAVA (Classe AppConfig)
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(AppConfig.class);
		
		// On extrait le guitariste du contexte de SPRING
		Guitariste guitariste = context.getBean(Guitariste.class);
		
		guitariste.jouer();
		
		// On extrait le pianiste du contexte de SPRING
		Pianiste pianiste = context.getBean(Pianiste.class);
		
		pianiste.jouer();
	}
}
