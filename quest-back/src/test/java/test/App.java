package test;

import context.Singleton;
import dao.DAOFiliere;
import dao.DAOOrdinateur;
import dao.DAOStagiaire;
import dao.IDAOFiliere;
import dao.IDAOMatiere;
import dao.IDAOOrdinateur;
import dao.IDAOStagiaire;

public class App {

	public static void main(String[] args) {

		IDAOMatiere daoM=Singleton.getInstance().getDaoMatiere();
		IDAOStagiaire daoS=Singleton.getInstance().getDaoStagiaire();
		IDAOOrdinateur daoO=Singleton.getInstance().getDaoOrdinateur();
		IDAOFiliere daoF=Singleton.getInstance().getDaoFiliere();
		
		
		/*System.out.println(daoM.findAll());
		System.out.println(daoS.findAll());
		System.out.println(daoO.findAll());
		System.out.println(daoF.findAll());*/
	}

}
