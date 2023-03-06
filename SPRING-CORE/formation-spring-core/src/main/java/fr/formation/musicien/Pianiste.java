package fr.formation.musicien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Pianiste {
	@Autowired
	@Qualifier("piano")
	private IInstrument instrument;
	
	public void jouer() {
		System.out.println("Le pianiste joue ...");
		this.instrument.son();
	}
}
