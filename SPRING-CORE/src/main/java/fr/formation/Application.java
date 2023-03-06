package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musicien.Guitariste;
import fr.formation.musicien.Pianiste;

//@Component
public class Application {
	@Autowired
	private Guitariste guitariste;
	
	@Autowired
	private Pianiste pianiste;
	
	public void run() {
		this.guitariste.jouer();
		this.pianiste.jouer();
	}
	
	public static void main(String[] args) {
//		Guitariste guitariste = new Guitariste();
//		
//		guitariste.jouer();
		
		// On démarre le contexte de SPRING
		// Configuration XML
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		
		// Configuration JAVA (Classe AppConfig)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// On peut créer une instance manangée à SPRING directement à partir du contexte
		Application app = context.getBeanFactory().createBean(Application.class);
		
		// On extrait Application du contexte de SPRING
//		Application app = context.getBean(Application.class);
		app.run();
		
		
		// On extrait le guitariste du contexte de SPRING
//		Guitariste guitariste = context.getBean(Guitariste.class);
//		
//		guitariste.jouer();
//		
//		// On extrait le pianiste du contexte de SPRING
//		Pianiste pianiste = context.getBean(Pianiste.class);
//		
//		pianiste.jouer();
	}
}
