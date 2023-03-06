package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("fr.formation")
@EnableAspectJAutoProxy // On active AspectJ
public class AppConfig {
	
}
