package context;

import dao.DAOCompte;
import dao.DAOPatient;
import dao.DAOVisite;

public class Singleton {

	
	private DAOCompte daoCompte = new DAOCompte();
	private DAOPatient daoPatient = new DAOPatient();
	private DAOVisite daoVisite = new DAOVisite();
	
	private static Singleton instance=null;
	
	private Singleton() {}

	

	public static Singleton getInstance() {
		if(instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}


	public DAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(DAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}


	public DAOPatient getDaoPatient() {
		return daoPatient;
	}


	public void setDaoPatient(DAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}


	public DAOVisite getDaoVisite() {
		return daoVisite;
	}


	public void setDaoVisite(DAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}
	
	
	
	
	
}
