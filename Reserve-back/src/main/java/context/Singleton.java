package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOActivite;
import dao.DAOBiome;
import dao.DAOCompte;
import dao.DAOEspece;
import dao.DAOReservation;
import dao.IDAOActivite;
import dao.IDAOBiome;
import dao.IDAOCompte;
import dao.IDAOEspece;
import dao.IDAOReservation;

public class Singleton {

	
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOBiome daoBiome = new DAOBiome();
	private IDAOEspece daoEspece = new DAOEspece();
	private IDAOReservation daoReservation = new DAOReservation();
	private IDAOActivite daoActivite = new DAOActivite();
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("reserve");
	
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




	public IDAOBiome getDaoBiome() {
		return daoBiome;
	}



	public void setDaoBiome(IDAOBiome daoBiome) {
		this.daoBiome = daoBiome;
	}



	public IDAOEspece getDaoEspece() {
		return daoEspece;
	}



	public void setDaoEspece(IDAOEspece daoEspece) {
		this.daoEspece = daoEspece;
	}



	public IDAOReservation getDaoReservation() {
		return daoReservation;
	}



	public void setDaoReservation(IDAOReservation daoReservation) {
		this.daoReservation = daoReservation;
	}



	public IDAOActivite getDaoActivite() {
		return daoActivite;
	}



	public void setDaoActivite(IDAOActivite daoActivite) {
		this.daoActivite = daoActivite;
	}



	public EntityManagerFactory getEmf() {
		return emf;
	}



	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	
	
}
