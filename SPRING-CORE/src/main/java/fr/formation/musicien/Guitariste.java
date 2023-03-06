package fr.formation.musicien;

import fr.formation.factory.InstrumentFactory;

public class Guitariste {
	private IInstrument instrument = InstrumentFactory.createInstrument();
}
