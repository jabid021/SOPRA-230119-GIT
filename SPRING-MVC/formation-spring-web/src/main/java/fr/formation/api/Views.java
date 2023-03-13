package fr.formation.api;

public interface Views {
	public static interface Common {}
	
	public static interface Produit extends Common {}
	
	public static interface Fournisseur extends Common {}
	public static interface FournisseurDetail extends Fournisseur {}
}
