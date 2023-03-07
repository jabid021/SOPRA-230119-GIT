package com.soprasteria.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.soprasteria.config.AppConfig;
import com.soprasteria.model.Activite;
import com.soprasteria.model.Biome;
import com.soprasteria.model.Scientifique;
import com.soprasteria.model.Tourisme;

import jakarta.transaction.Transactional;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class DAOActiviteTest {
	private static final int ACTIVITE_ID = 1;

	@Autowired
	private IDAOActivite daoActivite;

	@Test
	@Transactional
	void shouldFindById() {
		// given
		
		// when
		Activite activite = this.daoActivite.findById(ACTIVITE_ID);
		
		// then
		Assertions.assertEquals(ACTIVITE_ID, activite.getId());
		Assertions.assertTrue(activite.isGuide());
		Assertions.assertEquals(100.5, activite.getPrix());
		Assertions.assertEquals(7, activite.getDuree());
		Assertions.assertInstanceOf(Scientifique.class, activite);
		Assertions.assertEquals(2, activite.getReservations().size());
	}

	@Test
	void shouldFindAll() {
		// given
		
		// when
		List<Activite> activites = this.daoActivite.findAll();
		
		// then
		Assertions.assertNotNull(activites);
		Assertions.assertEquals(3, activites.size());
		Assertions.assertInstanceOf(Scientifique.class, activites.get(0));
		Assertions.assertInstanceOf(Tourisme.class, activites.get(1));
		Assertions.assertInstanceOf(Tourisme.class, activites.get(2));
	}

	@Test
	void shouldAdd() {
		// given
		Activite activite = new Tourisme();
		Biome biome = new Biome();
		
		biome.setId(1);

		activite.setDuree(5);
		activite.setGuide(true);
		activite.setPrix(50);
		activite.setBiome(biome);
		
		Assertions.assertNull(activite.getId());
		
		// when
		activite = this.daoActivite.save(activite);
		
		// then
		Assertions.assertNotNull(activite.getId());
		Assertions.assertNotEquals(0, activite.getId());
	}
}
