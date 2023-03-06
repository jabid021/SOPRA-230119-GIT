package fr.formation.musicien;

public class Guitariste {
	private IInstrument instrument; // = InstrumentFactory.createInstrument();

	// Nécessaire pour que Spring puisse injecter la dépendance depuis la config XML
	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}
	
	public void jouer() {
		System.out.println("Le guitariste joue ...");
		this.instrument.son();
	}
}
