package test;

import java.time.LocalDate;
import java.time.LocalTime;

import model.*;

public class Test {

	public static void main(String[] args) {
		
		//Groupe Compte :
		Adresse adresse1 = new Adresse("1bis", "rue de la Boustifaille", "Grobuffet", "23000", "France");
		Admin admin1 = new Admin("dd43", "azerty", "Du Chataignier", "Olivier");
		Client client1 = new Client("bg66", "Lachaigne2", "Rayonnant", "Charles", adresse1);
		Ranger ranger1 = new Ranger("SuperRanger", "123456", "Pipenbois", "Patrick", 11);
		

		//Groupe Reservation + Biome
		
		Biome biome1 = new Biome("savanne",20,Zone.Foret);
		
	
	
		//Groupe Espece 
		Vegetal vegetal1 = new Vegetal("Megalastrum canacae",53,0,biome1);
		Animal animal1 = new Animal("Ochotona princeps",17,40,99,biome1);
		
		System.out.println(vegetal1);
		System.out.println(animal1);
		
		
		
		
		//Groupe Activite (au moins un vehicule sur une des activites et ranger obligatoire)
		
		Scientifique s1 = new Scientifique(true, 100, 7, biome1, Vehicule.Voiture);
		Tourisme t1 = new Tourisme(true, 25, 4, biome1,null); 
		
		
		
		
		//Groupe Reservation (avec un ranger) + Biome
		LocalDate jour = LocalDate.parse("2023-01-31");
		LocalTime heure = LocalTime.parse("15:00");
		Reservation resa1 = new Reservation(4,5000,jour,heure,client1,t1);
		resa1.setRanger(ranger1);
		
		
		System.out.println(biome1);
		
	}

}
