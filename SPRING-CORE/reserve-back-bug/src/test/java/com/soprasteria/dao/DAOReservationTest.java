package com.soprasteria.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.soprasteria.config.AppConfig;
import com.soprasteria.model.Activite;
import com.soprasteria.model.Client;
import com.soprasteria.model.Reservation;
import com.soprasteria.model.Scientifique;

@SpringJUnitConfig(AppConfig.class)
@Sql(scripts = "classpath:/data.sql")
@ActiveProfiles("test")
public class DAOReservationTest {
	private static final int RESERVATION_ID = 2;

	@Autowired
	private IDAOReservation daoReservation;

	@Test
	void shouldFindById() {
		// given
		
		// when
		Reservation reservation = this.daoReservation.findById(RESERVATION_ID);
		
		// then
		Assertions.assertEquals(RESERVATION_ID, reservation.getId());
		Assertions.assertEquals(4, reservation.getEffectif());
		Assertions.assertEquals(100, reservation.getPrix());
		Assertions.assertEquals(2, reservation.getJour().getMonthValue());
		Assertions.assertEquals(15, reservation.getHeure().getHour());
		Assertions.assertNotNull(reservation.getClient());
		Assertions.assertEquals(2, reservation.getClient().getId());
	}

	@Test
	void shouldFindAll() {
		// given
		
		// when
		List<Reservation> reservations = this.daoReservation.findAll();
		
		// then
		Assertions.assertNotNull(reservations);
		Assertions.assertEquals(3, reservations.size());
	}

	@Test
	void shouldFindAllByClientId() {
		// given
		
		// when
		List<Reservation> reservations = this.daoReservation.findAllByClient(2);
		
		// then
		Assertions.assertNotNull(reservations);
		Assertions.assertEquals(3, reservations.size());
	}

	@Test
	void shouldFindAllByClientIdEmpty() {
		// given
		
		// when
		List<Reservation> reservations = this.daoReservation.findAllByClient(1);
		
		// then
		Assertions.assertNotNull(reservations);
		Assertions.assertEquals(0, reservations.size());
	}

	@Test
	void shouldFindAllByRangerId() {
		// given
		
		// when
		List<Reservation> reservations = this.daoReservation.findAllByRanger(3);
		
		// then
		Assertions.assertNotNull(reservations);
		Assertions.assertEquals(1, reservations.size());
	}

	@Test
	void shouldAdd() {
		// given
		Reservation reservation = new Reservation();
		Activite activite = new Scientifique();
		Client client = new Client();
		
		activite.setId(3);
		client.setId(2);

		reservation.setEffectif(1);
		reservation.setHeure(LocalTime.now());
		reservation.setJour(LocalDate.now());
		reservation.setPrix(500);
		reservation.setActivite(activite);
		reservation.setClient(client);
		
		Assertions.assertNull(reservation.getId());
		
		// when
		reservation = this.daoReservation.save(reservation);
		
		// then
		Assertions.assertNotNull(reservation.getId());
		Assertions.assertNotEquals(0, reservation.getId());
	}

	@Test
	void shouldUpdate() {
		// given
		Reservation reservation = this.daoReservation.findById(RESERVATION_ID);
		
		// when
		reservation.setPrix(50);
		this.daoReservation.save(reservation);
		
		// then
		Assertions.assertEquals(50, this.daoReservation.findById(RESERVATION_ID).getPrix());
	}

	@Test
	void shouldDeleteByIdOk() {
		// given

		// when
		this.daoReservation.delete(RESERVATION_ID);
		Reservation reservation = this.daoReservation.findById(RESERVATION_ID);
		
		// then
		Assertions.assertNull(reservation);
	}
}
