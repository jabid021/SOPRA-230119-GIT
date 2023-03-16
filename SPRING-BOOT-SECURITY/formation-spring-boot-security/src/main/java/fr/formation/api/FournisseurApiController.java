package fr.formation.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IFournisseurDao;
import fr.formation.exception.FournisseurBadRequestException;
import fr.formation.exception.FournisseurNotFoundException;
import fr.formation.model.Fournisseur;
import fr.formation.request.FournisseurRequest;
import fr.formation.response.FournisseurResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fournisseur")
@PostAuthorize("hasRole('ADMIN')") // Tout est uniquement pour l'admin ici
public class FournisseurApiController {
	@Autowired
	private IFournisseurDao daoFournisseur;
	
	// Lister les fournisseurs
	@GetMapping
	@JsonView(Views.Fournisseur.class)
	public List<Fournisseur> findAll() {
		return this.daoFournisseur.findAll();
	}
	
	@GetMapping("/{id}")
	// requete HTTP
	// ouvre la transaction
	@Transactional
	public FournisseurResponse findById(@PathVariable int id) {
		Fournisseur fournisseur = this.daoFournisseur.findById(id).orElseThrow(FournisseurNotFoundException::new);
		FournisseurResponse resp = new FournisseurResponse();
		
		BeanUtils.copyProperties(fournisseur, resp);
		
		resp.setNbProduits(fournisseur.getProduits().size());
		
//		// Forcer le chargement de la liste des produits
//		Hibernate.initialize(fournisseur.getProduits());
		
		return resp;
	}
	
	// fermeture transaction
	// sérialisation json
	// réponse http
	
	@GetMapping("/{id}-solution2")
	@JsonView(Views.FournisseurDetail.class)
	public Fournisseur findById2(@PathVariable int id) {
		return this.daoFournisseur.findByIdWithProduits(id).orElseThrow(FournisseurNotFoundException::new);
	}
	
	@PostMapping
	@JsonView(Views.Fournisseur.class)
	@ResponseStatus(HttpStatus.CREATED) // Optionel, permet d'informer le client qu'une nouvelle ressource a été créée
	public Fournisseur add(@Valid @RequestBody FournisseurRequest fournisseurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new FournisseurBadRequestException();
		}
		
		Fournisseur fournisseur = new Fournisseur();
		
		BeanUtils.copyProperties(fournisseurRequest, fournisseur);
		
		return this.daoFournisseur.save(fournisseur);
	}
	
	
	@PutMapping("/{id}")
	@JsonView(Views.Fournisseur.class)
	public Fournisseur edit(@PathVariable int id, @Valid @RequestBody FournisseurRequest fournisseurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new FournisseurBadRequestException();
		}
		
		Fournisseur fournisseur = this.daoFournisseur.findById(id).orElseThrow(FournisseurNotFoundException::new);
		
		BeanUtils.copyProperties(fournisseurRequest, fournisseur);
		
		return this.daoFournisseur.save(fournisseur);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoFournisseur.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
}
