package com.soprasteria.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.soprasteria.config.AppConfig;
import com.soprasteria.model.Admin;
import com.soprasteria.model.Compte;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class DAOCompteTest {
	@Autowired
	private IDAOCompte daoCompte;

	@Test
	void shouldFindByLoginAndPasswordOk() {
		// given
		
		// when
		Compte compte = this.daoCompte.findByLoginAndPassword("admin", "not24get");
		
		// then
		Assertions.assertEquals(1, compte.getId());
		Assertions.assertInstanceOf(Admin.class, compte);
	}

	@Test
	void shouldFindByLoginAndPasswordFailed() {
		// given
		
		// when
		Compte compte = this.daoCompte.findByLoginAndPassword("admin", "nopwd");
		
		// then
		Assertions.assertNull(compte);
	}
}
