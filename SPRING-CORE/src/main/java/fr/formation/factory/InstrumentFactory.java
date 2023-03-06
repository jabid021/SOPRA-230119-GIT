package fr.formation.factory;

import fr.formation.musicien.Guitare;
import fr.formation.musicien.IInstrument;

public class InstrumentFactory {
	public static IInstrument createInstrument() {
		return new Guitare();
	}
}
