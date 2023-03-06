package fr.formation.dao;

import org.springframework.stereotype.Repository;

import fr.formation.annotation.CustomTransactional;

@Repository
@CustomTransactional
public class DAOBiome {
	public String save() {
		System.out.println("SAUVEGARDE ...");
		
		return "ok";
	}
}
