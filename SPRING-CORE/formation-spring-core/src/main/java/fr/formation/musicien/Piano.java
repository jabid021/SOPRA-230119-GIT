package fr.formation.musicien;

import org.springframework.stereotype.Component;

@Component
//@Primary // Permet de prioriser l'instance dans le contexte de SPRING
public class Piano implements IInstrument {
	@Override
	public void son() {
		System.out.println("PLAK PLAK PLAK");	
	}
}
