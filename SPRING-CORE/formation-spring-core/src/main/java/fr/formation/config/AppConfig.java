package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // On dit à SPRING que c'est une classe de Configuration
//@ComponentScan({ "fr.formation", "fr.formation.autrepackage" })
@ComponentScan("fr.formation")
public class AppConfig {
//	@Bean // Cette annotation demande à SPRING de garder cette instance dans son contexte
//	public Guitariste guitariste() {
//		return new Guitariste();
//	}
}
