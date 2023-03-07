package com.soprasteria.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.soprasteria.config.AppConfig;
import com.soprasteria.model.Biome;
import com.soprasteria.model.Zone;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class DAOBiomeTest {
	private static final int BIOME_ID = 1;

	@Autowired
	private IDAOBiome daoBiome;

	@Test
	void shouldFindById() {
		// given
		
		// when
		Biome biome = this.daoBiome.findById(BIOME_ID);
		
		// then
		Assertions.assertEquals(BIOME_ID, biome.getId());
		Assertions.assertEquals("Savane", biome.getNom());
		Assertions.assertEquals(20, biome.getSuperficie());
		Assertions.assertEquals(Zone.FORET, biome.getZone());
	}

	@Test
	void shouldFindAll() {
		// given
		
		// when
		List<Biome> biomes = this.daoBiome.findAll();
		
		// then
		Assertions.assertNotNull(biomes);
		Assertions.assertEquals(3, biomes.size());
	}

	@Test
	void shouldAdd() {
		// given
		Biome biome = new Biome("Test", 200, Zone.MONTAGNE);
		
		// when
		biome = this.daoBiome.save(biome);
		
		// then
		Assertions.assertEquals(4, biome.getId());
	}

	@Test
	void shouldUpdate() {
		// given
		Biome biome = this.daoBiome.findById(BIOME_ID);
		
		// when
		biome.setNom("Nouveau nom");
		this.daoBiome.save(biome);
		
		// then
		Assertions.assertEquals("Nouveau nom", this.daoBiome.findById(BIOME_ID).getNom());
	}

	@Test
	void shouldDeleteByIdThrowException() {
		// given

		// when & then
		Assertions.assertThrows(
			DataIntegrityViolationException.class,
			() -> this.daoBiome.delete(BIOME_ID)
		);
	}

	@Test
	void shouldDeleteByIdOk() {
		// given
		int id = 3;

		// when
		this.daoBiome.delete(id);
		Biome biome = this.daoBiome.findById(id);
		
		// then
		Assertions.assertNull(biome);
	}
}
