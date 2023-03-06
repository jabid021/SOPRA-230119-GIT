package fr.formation.musicien;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements IInstrument {
	public Guitare() {
		System.out.println("CREATION D'UNE GUITARE ...");
	}
	
	@Override
	public void son() {
		System.out.println("GLINK GLINK GLINK");
	}
}
