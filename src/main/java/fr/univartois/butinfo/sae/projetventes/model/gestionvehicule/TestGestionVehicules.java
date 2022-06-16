package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

/**
 * Classe de teste du package GestionVehicules
 * @author Jules
 *
 */
public class TestGestionVehicules {

	public static void main(String[] args) {
		Conducteurs conducteurs = new Conducteurs("Nom");
		FlotteVehicules vehicules = new FlotteVehicules("Nom");
		Conducteur c1 = new Livreur("Jean","Eude","95018360817",TypeDePermis.PERMIS_E,6200);
		Livreur c2 = new Livreur("Jean","Jacques","950100160814",TypeDePermis.PERMIS_E,7200);
		Livreur c3 = new Livreur("Jean","Arbre","11111902",TypeDePermis.PERMIS_E,6969);
		Livreur c4 = new Livreur("Shreiner","Pierre","78126803",TypeDePermis.PERMIS_E,120);
		Livreur c5 = new Livreur("Jakobowowowowoski","Aymeric","14351290",TypeDePermis.PERMIS_E,482);
		Conducteur c6 = new Commercial("Toto","Toto","98137",TypeDePermis.PERMIS_B,11);
		Commercial c7 = new Commercial("Bennington","Chester","7908709732",TypeDePermis.PERMIS_C,1);
		Commercial c8 = new Commercial("Condotta","Jean-François","1111111111111",TypeDePermis.PERMIS_D,2);
		Commercial c9 = new Commercial("Legend","John","313100292",TypeDePermis.PERMIS_B,64);
		Commercial c10 = new Commercial("Chemin","Christopher","09809810",TypeDePermis.PERMIS_A,48);
		Commercial c11 = new Commercial("Exclu","Test","99999999ç",TypeDePermis.PERMIS_A,0);
		conducteurs.ajouteConducteur(c1);
		conducteurs.ajouteConducteur(c2);
		conducteurs.ajouteConducteur(c3);
		conducteurs.ajouteConducteur(c4);
		conducteurs.ajouteConducteur(c5);
		conducteurs.ajouteConducteur(c6);
		conducteurs.ajouteConducteur(c7);
		conducteurs.ajouteConducteur(c8);
		conducteurs.ajouteConducteur(c9);
		conducteurs.ajouteConducteur(c10);
		conducteurs.ajouteConducteur(c11);
		conducteurs.supprimeConducteur(c11);
		Vehicule v1 = new Fourgon("Toyota","FR-821-CV","MODELE1SUPREMEXL+",42.17,2013,100.00,300.00,c2);
		Fourgon v2 = new Fourgon("Toyota","FR-912-XQ","MODELE2",43.92,2017,150.00,310.00);
		Fourgon v3 = new Fourgon("Peugeot","AZ-666-XD","MODELE2",4300.22,2017,150.00,310.00,c3);
		Fourgon v4 = new Fourgon("Toyota","TF-010-YK","MODELE2+",888.92,2017,160.00,315.00,c4);
		Fourgon v5 = new Fourgon("Toyota","DE-777-QD","MODELE3++",3211.92,2018,190.00,330.00);
		Vehicule v6 = new Voiture("Citroen","BW-222-YO","C3",104.02,2010,c7);
		Voiture v7 = new Voiture("Peugeot","XX-733-GG","208",50.00,2019,c8);;
		Voiture v8 = new Voiture("Peugeot","PW-992-ZP","3008",750.00,2021);;
		Voiture v9 = new Voiture("Peugeot","AE-615-PM","307",520.00,2016,c9);;
		Voiture v10 = new Voiture("Jaguar","JH-733-JG","XE",11.00,2020);
		try {
			vehicules.ajouteVehicule(v1);
			vehicules.ajouteVehicule(v2);
			vehicules.ajouteVehicule(v3);
			vehicules.ajouteVehicule(v4);
			vehicules.ajouteVehicule(v5);
			vehicules.ajouteVehicule(v6);
			vehicules.ajouteVehicule(v7);
			vehicules.ajouteVehicule(v8);
			vehicules.ajouteVehicule(v9);
			vehicules.ajouteVehicule(v10);
		} catch (DejaPresentException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n ******** Tri alphabétique conducteurs ******** \n");
		conducteurs.triAlphabetique();
		System.out.println("\n ******** Tri type conducteurs ******** \n");
		conducteurs.triType();
		System.out.println("\n ******** Tri type véhicules ******** \n");
		vehicules.triType();
		System.out.println("\n ******** Tri année véhicules ******** \n");
		vehicules.triAnneeMiseEnCirculation();

	}

}
