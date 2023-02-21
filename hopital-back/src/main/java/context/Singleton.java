package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOCompteJPA;
import dao.DAOPatientJPA;
import dao.DAOVisiteJPA;
import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;

public class Singleton {

	
	private IDAOCompte daoCompte = new DAOCompteJPA();
	private IDAOPatient daoPatient = new DAOPatientJPA();
	private IDAOVisite daoVisite = new DAOVisiteJPA();
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("hopital");
	
	private static Singleton instance=null;
	
	private Singleton() {}

	

	public static Singleton getInstance() {
		if(instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}


	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}


	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}


	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}


	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	
	
}
