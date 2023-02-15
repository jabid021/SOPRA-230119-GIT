package model;

public class Scientifique extends Activite {

	
	public Scientifique(Integer id,boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		super(id,guide, prix, duree, biome, vehicule);
	}
	
	
	public Scientifique(boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		super(guide, prix, duree, biome, vehicule);
	}


	@Override
	public String toString() {
		return "Scientifique [id=" + id + ", guide=" + guide + ", prix=" + prix + ", duree=" + duree + ", vehicule="
				+ vehicule + ", biome=" + biome + "]";
	}

	
}