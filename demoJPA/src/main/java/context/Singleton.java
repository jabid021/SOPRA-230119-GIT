package context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAODemande;
import dao.DAODictateur;
import dao.DAOEnfant;
import dao.DAOEsclave;
import dao.DAOJouet;
import dao.DAOTraineau;
import dao.IDAODemande;
import dao.IDAODictateur;
import dao.IDAOEnfant;
import dao.IDAOEsclave;
import dao.IDAOJouet;
import dao.IDAOTraineau;

public class Singleton {

	private IDAODemande daoDemande = new DAODemande();
	private IDAODictateur daoDictateur = new DAODictateur();
	private IDAOEnfant daoEnfant = new DAOEnfant();
	private IDAOJouet daoJouet = new DAOJouet();
	private IDAOEsclave daoEsclave = new DAOEsclave();
	private IDAOTraineau daoTraineau = new DAOTraineau();
	private static Singleton instance;
	
	
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("demoJPA");
	
	
	private Singleton() {}


	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance=new Singleton();
		}
		return instance;
	}


	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	public IDAODemande getDaoDemande() {
		return daoDemande;
	}


	public void setDaoDemande(IDAODemande daoDemande) {
		this.daoDemande = daoDemande;
	}


	public IDAODictateur getDaoDictateur() {
		return daoDictateur;
	}


	public void setDaoDictateur(IDAODictateur daoDictateur) {
		this.daoDictateur = daoDictateur;
	}


	public IDAOEnfant getDaoEnfant() {
		return daoEnfant;
	}


	public void setDaoEnfant(IDAOEnfant daoEnfant) {
		this.daoEnfant = daoEnfant;
	}


	public IDAOJouet getDaoJouet() {
		return daoJouet;
	}


	public void setDaoJouet(IDAOJouet daoJouet) {
		this.daoJouet = daoJouet;
	}


	public IDAOEsclave getDaoEsclave() {
		return daoEsclave;
	}


	public void setDaoEsclave(IDAOEsclave daoEsclave) {
		this.daoEsclave = daoEsclave;
	}


	public IDAOTraineau getDaoTraineau() {
		return daoTraineau;
	}


	public void setDaoTraineau(IDAOTraineau daoTraineau) {
		this.daoTraineau = daoTraineau;
	}
	
	
	
	
	
}
