package fr.formation.musicien;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // Chargement paresseux, SPRING ne chargera QUE si besoin
//@Scope("prototype")
public class Guitare implements IInstrument {
	public Guitare() {
		System.out.println("CREATION D'UNE GUITARE ...");
	}
	
	@Override
	public void son() {
		System.out.println("GLINK GLINK GLINK");
	}
}
