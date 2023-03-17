package fr.formation.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ProduitProjection {
	public int getId();
	public String getLibelle();
	
	@Value("#{target.libelle}")
	public String getNom();
	
	@Value("#{target.fournisseur?.nom}")
	public String getFournisseurNom();
	
	public FournisseurProjection getFournisseur();

	@Value("#{target.fournisseur}")
	public FournisseurProjection getFou();
}
