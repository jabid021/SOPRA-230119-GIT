package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Animal;
import model.Biome;
import model.Espece;
import model.Vegetal;
import model.Zone;

public class TestSerialize {

	static List<Espece> especes = new ArrayList(); 
	

	public static int saisieInt(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		int var = monScanner.nextInt();
		return var;
	}
	
	public static void ecrireEspeces(String chemin) 
	{
		File f = new File(chemin);
		try {
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(especes);
		
		oos.close();
		fos.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	
	
	public static void lireEspeces(String chemin)
	{
		
		
		File f = new File(chemin);
		try {
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		especes = (List<Espece>) ois.readObject();
		
		ois.close();
		fis.close();
		}
		catch(Exception e) {e.printStackTrace();}
		
		for(Espece e : especes) 
		{
			System.out.println(e);
		}
	}
	
	
	
	public static void main(String[] args) {
	
		
		//indiceProtection ne doit pas apparaitre dans les fichiers
		Biome biome1 = new Biome("savanne",20,Zone.Foret);
		Vegetal vegetal1 = new Vegetal("Megalastrum canacae",53,0,biome1);
		Animal animal1 = new Animal("Ochotona princeps",17,40,99,biome1);
		
		especes.add(vegetal1);
		especes.add(animal1);
		
		
		System.out.println("Menu Especes");
		System.out.println("1 - Sauvegarder");
		System.out.println("2 - Lire le fichier");
		int choix = saisieInt("Choisir un menu");
		
		switch(choix) 
		{
		case 1 : ecrireEspeces("especes.txt"); break;
		case 2 : especes.clear();lireEspeces("especes.txt");break;
		}
		
	
	}

}
