package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import context.Singleton;
import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;

public class App {

	static LinkedList<Patient> fileAttente = new LinkedList();
	static Compte connected=null;

	static IDAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	static IDAOPatient daoPatient= Singleton.getInstance().getDaoPatient();
	static IDAOVisite daoVisite = Singleton.getInstance().getDaoVisite();
	static boolean enPause=false;

	public static String saisieString(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextInt();

	}

	public static double saisieDouble(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextDouble();
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextBoolean();
	}



	public static void menuPrincipal() {
		System.out.println("\nAppli Hopital :");
		System.out.println("1- Se connecter");
		System.out.println("2- Stop");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : Singleton.getInstance().getEmf().close(); System.exit(0);break;
		}

		menuPrincipal();
	}



	public static void seConnecter() {
		String login = saisieString("Saisir login");
		String password = saisieString("Saisir password");
		connected = daoCompte.findByLoginAndPassword(login, password);

		if(connected==null) 
		{
			System.out.println("Identifiants invalides");
		}
		else if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Dans quelle salle ?");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}
		else if(connected instanceof Secretaire) 
		{
			if(enPause) 
			{
				menuSecretairePause();
			}
			else 
			{
				menuSecretaire();
			}
		}

	}

	public static void menuSecretaire() {
		System.out.println("\nMenu Secretaire");
		System.out.println("1- Ajouter un patient dans la file d'attente");
		System.out.println("2- Afficher la file d'attente");
		System.out.println("3- Afficher les anciennes visites d'un patient");
		System.out.println("4- Partir en pause");
		System.out.println("5- Se deconnecter");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : ajouterPatient();break;
		case 2 : afficherFile();break;
		case 3 : afficherVisites();break;
		case 4 : partirPause();break;
		case 5 : seDeconnecter();break;
		}

		menuSecretaire();
	}


	public static void ajouterPatient() {
		int idPatient = saisieInt("Saisir l'id du patient");
		Patient p = daoPatient.findById(idPatient);
		if(p==null) 
		{
			System.out.println("Creation d'un nouveau patient :");
			String nom = saisieString("Saisir nom");
			String prenom = saisieString("Saisir prenom");
			p = new Patient(idPatient, nom, prenom);
			daoPatient.save(p);
			System.out.println("Le patient "+p+" a ete ajoute en bdd");
		}
		fileAttente.add(p);
		System.out.println("Le patient "+p+" est dans la file d'attente");
	}

	public static void afficherFile() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		for(Patient p : fileAttente) 
		{
			System.out.println(p);
		}
	}

	public static void afficherVisites() {
		int idPatient = saisieInt("Saisir l'id du Patient");
		List<Visite> visites = daoVisite.findAllByPatient(idPatient);
		if(visites.isEmpty()) 
		{
			System.out.println("Pas de visite a ce jour");
		}
		for(Visite v : visites) 
		{
			System.out.println(v);
		}
	}

	public static void partirPause() {
		File f = new File("pause.txt");
		//Declarer fos et oos dans les parentheses du try => autoclose
		try(FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(fileAttente);
			fileAttente.clear();
			enPause=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		menuSecretairePause();
	}

	public static void seDeconnecter() {
		connected=null;
		menuPrincipal();
	}

	public static void menuSecretairePause() {
		System.out.println("\nMenu Secretaire pause");
		System.out.println("1- Revenir de pause");
		System.out.println("2- Se deconnecter");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : revenirPause();break;
		case 2 : seDeconnecter();break;
		}

		menuSecretairePause();

	}



	public static void revenirPause() {
		File f = new File("pause.txt");

		try(FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			fileAttente = (LinkedList<Patient>) ois.readObject();

			enPause=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		menuSecretaire();
	}

	public static void menuMedecin() {
		System.out.println("\nMenu Medecin");
		System.out.println("1- Recevoir un patient de la file d'attente");
		System.out.println("2- Afficher la file d'attente");
		System.out.println("3- Save mes Visites");
		System.out.println("4- Se deconnecter");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : recevoirPatient();break;
		case 2 : afficherFile();break;
		case 3 : saveVisites();break;
		case 4 : seDeconnecter();break;
		}

		menuMedecin();
	}


	
	public static void recevoirPatient() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			Medecin m = (Medecin)connected;
			Patient p = fileAttente.poll();
			System.out.println("Passage du patient : "+p);
			Visite v = new Visite(p,m);
			m.getConsultations().add(v);
			if(m.getConsultations().size()>=3) 
			{
				System.out.println("Save auto des visites");
				saveVisites();
			}
		}	
	}
	
	public static void saveVisites() {
		List<Visite> visites = ((Medecin) connected).getConsultations();
		
		if(visites.isEmpty()) 
		{
			System.out.println("Aucune visite a save");
		}
		for(Visite v : visites) 
		{
			v= daoVisite.save(v);
			System.out.println(v);
		}
		visites.clear();
	}


	public static void main(String[] args) {
		menuPrincipal();
	}



}
