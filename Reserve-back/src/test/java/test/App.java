package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import context.Singleton;
import dao.IDAOActivite;
import dao.IDAOBiome;
import dao.IDAOCompte;
import dao.IDAOEspece;
import dao.IDAOReservation;
import model.Activite;
import model.Admin;
import model.Adresse;
import model.Animal;
import model.Biome;
import model.Client;
import model.Compte;
import model.Espece;
import model.Ranger;
import model.Reservation;
import model.Scientifique;
import model.Tourisme;
import model.Vegetal;
import model.Vehicule;
import model.Zone;

public class App {
	
	static Compte connected;
	static IDAOCompte daoC = Singleton.getInstance().getDaoCompte();
	static IDAOActivite daoA = Singleton.getInstance().getDaoActivite();
	static IDAOBiome daoB = Singleton.getInstance().getDaoBiome();
	static IDAOReservation daoR = Singleton.getInstance().getDaoReservation();
	static IDAOEspece daoE = Singleton.getInstance().getDaoEspece();
	
	public static String saisieString(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextLine();
		//return var;
	}

	public static int saisieInt(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		int var = monScanner.nextInt();
		return var;
	}

	public static double saisieDouble(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		double var = monScanner.nextDouble();
		return var;
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		boolean var = monScanner.nextBoolean();
		return var;
	}


	//------------------------------------Menu----------------------------------------------//



	public static void menuPrincipal() 
	{
		System.out.println("Bienvenue sur l'appli Reserve");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Stop");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : inscription();break;
		case 3 : Singleton.getInstance().getEmf().close(); System.exit(0);
		}

		menuPrincipal();
	}





	public static void inscription() {

		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");
		String numero = saisieString("Saisir votre numero");
		String voie = saisieString("Saisir votre voie");
		String ville = saisieString("Saisir votre ville");
		String cp = saisieString("Saisir votre cp");
		String pays = saisieString("Saisir votre pays");
		Adresse a = new Adresse(numero,voie,ville,cp,pays);
		Client c = new Client(login,password,nom,prenom,a);
		daoC.save(c);

	}

	public static void seConnecter() {

		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		connected = daoC.findByLoginAndPassword(login, password);

		if(connected == null) 
		{
			System.out.println("Identifiants invalides");
		}
		else if(connected instanceof Admin) 
		{
			menuAdmin();
		}
		else if(connected instanceof Client) 
		{
			menuClient();
		}
		else if(connected instanceof Ranger) 
		{
			menuRanger();
		}

	}


	public static void menuAdmin() {
		System.out.println("Menu Admin");
		System.out.println("1- Gestion des comptes");
		System.out.println("2- Gestion des biomes");
		System.out.println("3- Gestion des especes");
		System.out.println("4- Gestion des activites");
		System.out.println("5- Gestion des reservations");	
		System.out.println("6- Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : gestionCompte();break;
		case 2 : gestionBiome();break;
		case 3 : gestionEspece();break;
		case 4 : gestionActivite();break;
		case 5 : gestionReservation();break;
		case 6 : menuPrincipal();break;
		}

		menuAdmin();

	}





	public static void gestionCompte() {
		System.out.println("\nGestion des comptes");
		System.out.println("1- Afficher les comptes");
		System.out.println("2- Ajouter un compte");
		System.out.println("3- Modifier un compte");
		System.out.println("4- Supprimer un compte");
		System.out.println("5- Retour");	


		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherComptes();break;
		case 2 : ajouterCompte();break;
		case 3 : modifierCompte();break;
		case 4 : supprimerCompte();break;
		case 5 : menuAdmin();break;
		}

		gestionCompte();

	}

	public static void supprimerCompte() {
		afficherComptes();
		int id = saisieInt("Saisir l'id du compte à supprimer");
		daoC.delete(id);
	}

	public static void modifierCompte() {
		afficherComptes();
		int id = saisieInt("Saisir l'id du compte à modifier");

		Compte compte = daoC.findById(id);


		if(compte instanceof Admin) 
		{
			String login = saisieString("Saisir votre login");
			String password = saisieString("Saisir votre password");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			Admin a = new Admin(id,login,password,nom,prenom);
			daoC.save(a);

		}
		else if(compte instanceof Client) 
		{
			String login = saisieString("Saisir votre login");
			String password = saisieString("Saisir votre password");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			String numero = saisieString("Saisir votre numero");
			String voie = saisieString("Saisir votre voie");
			String ville = saisieString("Saisir votre ville");
			String cp = saisieString("Saisir votre cp");
			String pays = saisieString("Saisir votre pays");
			Adresse a = new Adresse(numero,voie,ville,cp,pays);
			Client c = new Client(id,login,password,nom,prenom,a);
			daoC.save(c);
		}
		else if(compte instanceof Ranger) 
		{
			String login = saisieString("Saisir votre login");
			String password = saisieString("Saisir votre password");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			int anciennete=saisieInt("Saisir votre anciennete");
			Ranger r = new Ranger(id,login,password,nom,prenom,anciennete);
			daoC.save(r);
		}
	}

	public static void ajouterCompte() {

		String typeCompte = saisieString("Choisir un type de compte (Admin/Client/Ranger)");
		if(typeCompte.equals("Admin")) 
		{
			String login = saisieString("Saisir votre login");
			String password = saisieString("Saisir votre password");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			Admin a = new Admin(login,password,nom,prenom);
			daoC.save(a);

		}
		else if(typeCompte.equals("Client")) 
		{
			String login = saisieString("Saisir votre login");
			String password = saisieString("Saisir votre password");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			String numero = saisieString("Saisir votre numero");
			String voie = saisieString("Saisir votre voie");
			String ville = saisieString("Saisir votre ville");
			String cp = saisieString("Saisir votre cp");
			String pays = saisieString("Saisir votre pays");
			Adresse a = new Adresse(numero,voie,ville,cp,pays);
			Client c = new Client(login,password,nom,prenom,a);
			daoC.save(c);
		}
		if(typeCompte.equals("Ranger")) 
		{
			String login = saisieString("Saisir votre login");
			String password = saisieString("Saisir votre password");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			int anciennete=saisieInt("Saisir votre anciennete");
			Ranger r = new Ranger(login,password,nom,prenom,anciennete);
			daoC.save(r);
		}

	}

	public static void afficherComptes() {

		List<Compte> comptes = daoC.findAll();
		if(comptes.isEmpty()) 
		{
			System.out.println("Aucun compte");
		}

		for(Compte c : comptes) 
		{
			System.out.println(c);
		}
	}


	public static void afficherRangers() {

		List<Ranger> comptes = daoC.findAllRanger();
		if(comptes.isEmpty()) 
		{
			System.out.println("Aucun ranger");
		}

		for(Compte c : comptes) 
		{
			System.out.println(c);
		}
	}


	public static void afficherClient() {

		List<Client> comptes = daoC.findAllClient();
		if(comptes.isEmpty()) 
		{
			System.out.println("Aucun client");
		}

		for(Compte c : comptes) 
		{
			System.out.println(c);
		}
	}





	public static void gestionBiome() {
		System.out.println("\nGestion des biomes");
		System.out.println("1- Afficher les biomes");
		System.out.println("2- Ajouter un biome");
		System.out.println("3- Modifier un biome");
		System.out.println("4- Supprimer un biome");
		System.out.println("5- Retour");	


		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherBiomes();break;
		case 2 : ajouterBiome();break;
		case 3 : modifierBiome();break;
		case 4 : supprimerBiome();break;
		case 5 : menuAdmin();break;
		}

		gestionBiome();

	}


	public static void supprimerBiome() {

		afficherBiomes();
		int id = saisieInt("Saisir l'id du biome à supprimer");
		daoB.delete(id);

	}

	public static void modifierBiome() {

		afficherBiomes();
		Integer id = saisieInt("Saisir l'id du biome à modifier");


		String nom = saisieString("saisir le nouveau nom du biome");
		int superficie = saisieInt("Saisir la nouvelle superficie du biome");
		String choixZone = saisieString("Saisir le nom de la nouvelle zone : Foret,Aquatique,Montagne,Voliere");
		Zone zone = Zone.valueOf(choixZone);
		Biome b =  new Biome (id,nom, superficie, zone);
		daoB.save(b);
	}

	public static void ajouterBiome() {

		String nom = saisieString("saisir le nom du nouveau biome");
		int superficie = saisieInt("Saisir la superficie du biome");
		String choixZone = saisieString("Saisir le nom de la zone : Foret,Aquatique,Montagne,Voliere");
		Zone zone = Zone.valueOf(choixZone);
		Biome b =  new Biome (nom, superficie, zone);
		daoB.save(b);
	}

	public static void afficherBiomes() {
		List<Biome> biomes = daoB.findAll();
		if(biomes.isEmpty()) 
		{
			System.out.println("Aucun biome");
		}

		for(Biome b : biomes) 
		{
			System.out.println(b);
		}
	}




	public static void gestionEspece() {
		System.out.println("\nGestion des especes");
		System.out.println("1- Afficher les especes");
		System.out.println("2- Ajouter un espece");
		System.out.println("3- Modifier un espece");
		System.out.println("4- Supprimer un espece");
		System.out.println("5- Retour");	


		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherEspeces();break;
		case 2 : ajouterEspece();break;
		case 3 : modifierEspece();break;
		case 4 : supprimerEspece();break;
		case 5 : menuAdmin();break;
		}

		gestionEspece();

	}


	public static void supprimerEspece() {

		afficherEspeces();

		int id = saisieInt("Choisir l'id de l'espèce a supprimer");
		daoE.delete(id);


	}
	public static void modifierEspece() {
		afficherEspeces();
		int id = saisieInt("Saisir l'id de l'espèce à modifier");

		Espece espece = daoE.findById(id);


		String nom = saisieString("Choisir le nom de l'espèce");
		int effectif = saisieInt("Saisir l'effectif");
		int indiceProtection = saisieInt("Saisir l'indice de protection");

		afficherBiomes();

		int idBiome = saisieInt("Saisir l'id du biome");

		Biome newBiome = daoB.findById(idBiome);


		if(espece instanceof Animal) 
		{
			int danger = saisieInt("Saisir l'indice de dangerosité");

			espece = new Animal(id,nom,effectif,indiceProtection,danger,newBiome);
			daoE.save(espece);

		}
		else if(espece instanceof Vegetal) 
		{
			espece = new Vegetal(id,nom,effectif,indiceProtection,newBiome);
			daoE.save(espece);
		}

	}

	public static void ajouterEspece() {


		String typeEspece = saisieString("Choisir type d'espece (Animal/Vegetal)");

		String nom = saisieString("Choisir le nom de l'espèce");
		int effectif = saisieInt("Saisir l'effectif");
		int indiceProtection = saisieInt("Saisir l'indice de protection");

		afficherBiomes();

		int idBiome = saisieInt("Saisir l'id du biome");

		Biome newBiome = daoB.findById(idBiome);

		if (typeEspece.equals("Animal")) 
		{
			int danger = saisieInt("Saisir l'indice de dangerosité");

			Animal newAnimal = new Animal(nom,effectif,indiceProtection,danger,newBiome);
			daoE.save(newAnimal);
		}
		else if(typeEspece.equals("Vegetal")) 
		{

			Vegetal newVegetal = new Vegetal(nom,effectif,indiceProtection,newBiome);
			daoE.save(newVegetal);
		}
	}

	public static void afficherEspeces() {
		List<Espece> especes = daoE.findAll();
		if(especes.isEmpty()) 
		{
			System.out.println("Aucune espece");
		}

		for(Espece e : especes) 
		{
			System.out.println(e);
		}

	}

	public static void gestionActivite() {
		System.out.println("\nGestion des activites");
		System.out.println("1- Afficher les activites");
		System.out.println("2- Ajouter un activite");
		System.out.println("3- Modifier un activite");
		System.out.println("4- Supprimer un activite");
		System.out.println("5- Retour");	


		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherActivites();break;
		case 2 : ajouterActivite();break;
		case 3 : modifierActivite();break;
		case 4 : supprimerActivite();break;
		case 5 : menuAdmin();break;
		}

		gestionActivite();

	}



	public static void supprimerActivite() 
	{
		afficherActivites();
		int id = saisieInt("Indiquez l'id de l'activité à supprimer :");
		daoA.delete(id);

	}

	public static void modifierActivite() 
	{

		afficherActivites();
		int id = saisieInt("Indiquez l'id de l'activité à modifier :");

		Activite a = daoA.findById(id);


		boolean guide = saisieBoolean("Voulez vous un guide : true/false");
		double prix = saisieDouble("Quel est le prix");
		int duree=saisieInt("Quel est la durée");
		Vehicule vehicule = null;
		String vehiculeYN = saisieString("Voulez vous un vehicule ? : y/n");

		if(vehiculeYN.equals("y")){
			Vehicule[] vehicules = Vehicule.values();

			System.out.println("Voici les vehicules à disposition : ");
			for (Vehicule v : vehicules) {
				System.out.println(v);
			}
			vehicule = Vehicule.valueOf(saisieString("Choix du véhicule :" ));
		}


		afficherBiomes();
		int idBiome = saisieInt("Choisisez un Id biome");

		Biome b = daoB.findById(idBiome);

		if(a instanceof Tourisme)
		{
			Tourisme t = new Tourisme(id,guide, prix, duree, b, vehicule);
			daoA.save(t);
		}


		else if (a instanceof Scientifique){
			Scientifique s = new Scientifique(id,guide,prix,duree,b,vehicule);
			daoA.save(s);
		}
	}

	public static void ajouterActivite() 
	{
		String typeActivite = saisieString("Quel type d'activité : Tourisme/Scientifique");

		boolean guide = saisieBoolean("Voulez vous un guide : true/false");
		double prix = saisieDouble("Quel est le prix");
		int duree=saisieInt("Quel est la durée");
		Vehicule vehicule = null;
		String vehiculeYN = saisieString("Voulez vous un vehicule ? : y/n");

		if(vehiculeYN.equals("y")){
			Vehicule[] vehicules = Vehicule.values();
			System.out.println("Voici les vehicules à disposition : ");
			for (Vehicule v : vehicules) {
				System.out.println(v);
			}
			vehicule = Vehicule.valueOf(saisieString("Choix du véhicule :" ));
		}


		afficherBiomes();
		int idBiome = saisieInt("Choisisez un Id biome");

		Biome b = daoB.findById(idBiome);
		Activite a=null;
		if(typeActivite.equals("Tourisme"))
		{
			a = new Tourisme(0,guide, prix, duree, b, vehicule);
		}


		else if (typeActivite.equals("Scientifique")){
			a = new Scientifique(0,guide,prix,duree,b,vehicule);

		}
		daoA.save(a);
	}
	public static void afficherActivites() {
		List<Activite> activites = daoA.findAll();
		if(activites.isEmpty()) 
		{
			System.out.println("Aucune activite");
		}

		for(Activite a : activites) 
		{
			System.out.println(a);
		}
	}

	public static void gestionReservation() {
		System.out.println("\nGestion des reservations");
		System.out.println("1- Afficher les reservations");
		System.out.println("2- Ajouter un reservation");
		System.out.println("3- Modifier un reservation");
		System.out.println("4- Supprimer un reservation");
		System.out.println("5- Retour");	


		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherReservations();break;
		case 2 : ajouterReservation();break;
		case 3 : modifierReservation();break;
		case 4 : supprimerReservation();break;
		case 5 : menuAdmin();break;
		}

		gestionReservation();

	}
	public static void supprimerReservation() {
        if(connected instanceof Admin) 
        {
             afficherReservations();
        }
       
        else {
            afficherReservationsClient();
        }
        int id = saisieInt("Saisir l'id de la réservation à supprimer");
        daoR.delete(id);
    }

    public static void modifierReservation() {
        if(connected instanceof Admin) 
        {
             afficherReservations();
        }
       
        else {
            afficherReservationsClient();
        }
        Integer idM = saisieInt("Saisir l'id de la réservation à modifier");
        Reservation reservation =  daoR.findById(idM);
        Client clientM = reservation.getClient();
        
        int nbM = saisieInt("Saisir votre nouveaux nombre de personnes");
        
        String jourM = saisieString("Saisir le jour de cette reservation");
        String heureM = saisieString("Saisir l'heure de cette reservation");
        
        
        afficherActivites();
        int idActiviteM = saisieInt("Saisir le nouvel id de l'activite");
        Activite activiteM =  daoA.findById(idActiviteM);
        double prixM = activiteM.getPrix();
        
        reservation = new Reservation(idM,nbM,prixM,LocalDate.parse(jourM),LocalTime.parse(heureM),clientM,activiteM);
        
        if(activiteM.isGuide()) 
        {
            boolean guide = saisieBoolean("Avez vous besoin d'un guide ? true/false");
            if(guide) 
            {
                afficherRangers();
                int idRanger = saisieInt("Saisir l'id du Ranger");
                Ranger ranger = (Ranger) daoC.findById(idRanger);
                reservation.setRanger(ranger);
            }
        }
        
        daoR.save(reservation);
    }
	public static void ajouterReservation() {


		afficherClient();
		int idClient = saisieInt("Saisir l'id du client");
		Client client = (Client) daoC.findById(idClient);

		afficherActivites();
		int idActivite = saisieInt("Saisir l'id de l'activite");

		Activite activite = daoA.findById(idActivite);


		String jour = saisieString("Saisir le jour de cette reservation");

		String heure = saisieString("Saisir l'heure de cette reservation");

		int nb = saisieInt("Combien de personne ?");

		double prixTotal = nb * activite.getPrix();

		Reservation reservation = new Reservation(nb, prixTotal, LocalDate.parse(jour), LocalTime.parse(heure), client, activite);



		if(activite.isGuide()) 
		{
			boolean guide = saisieBoolean("Avez vous besoin d'un guide ? true/false");
			if(guide) 
			{
				afficherRangers();
				int idRanger = saisieInt("Saisir l'id du Ranger");
				Ranger ranger = (Ranger) daoC.findById(idRanger);
				reservation.setRanger(ranger);
			}
		}


		 daoR.save(reservation);




	}

	public static void afficherReservations() {
		List<Reservation> reservations =  daoR.findAll();
		if(reservations.isEmpty()) 
		{
			System.out.println("Aucune reservation");
		}

		for(Reservation r : reservations) 
		{
			System.out.println(r);
		}

	}

	public static void menuClient() {
        System.out.println("Menu Client (Bientot disponible....)");
        System.out.println("1- Se deconnecter");
        System.out.println("2- Consulter toutes mes reservations");
        System.out.println("3- Supprimer une réservation");
        System.out.println("4- Modifier une réservation");

        int choix = saisieInt("Choisir un menu");
        switch(choix) 
        {
        case 1 : menuPrincipal();break;
        case 2 : afficherReservationsClient();break;
        case 3 : supprimerReservation(); break;
        case 4 : modifierReservation() ; break ;

        }

        menuClient();

    }

	public static void menuRanger() {
		System.out.println("Menu Ranger (Bientot disponible....)");
		System.out.println("1- Se deconnecter");
		System.out.println("2- Consulter toutes mes affectations");
		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : menuPrincipal();break;
		case 2 : afficherReservationsRanger();break;
		}

		menuRanger();
	}

	public static void afficherReservationsRanger() {

        List<Reservation> reservations =  daoR.findAllByRanger(connected.getId());
        if(reservations.isEmpty()) 
        {
            System.out.println("Aucune reservation");
        }

        for(Reservation r : reservations) 
        {
            System.out.println(r);
        }
    }

    public static void afficherReservationsClient() {
        List<Reservation> reservations =  daoR.findAllByClient(connected.getId()); 

        for (Reservation tmp : reservations) {
            System.out.println(tmp);
            
        }
    }
	public static void main(String[] args) {
		
		//Plain Old Java Object
		//Classe POJO / Java Bean / Entity => Classes ayant un constructeur vide + getters et setters
		//Biome b = daoB.findById(1);
		//b.setNom(saisieString("Saisir le nom"));
		
		//daoB.save(b);
		
		
		//System.out.println(b);
		
		menuPrincipal();
	}

}
