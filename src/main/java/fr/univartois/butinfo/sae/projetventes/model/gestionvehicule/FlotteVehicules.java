package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe qui crée une liste de véhicule.
 * @author Jules
 *
 */

public class FlotteVehicules {
	
	/**
	 * ObservableList de véhicule
	 */
    private ObservableList<Vehicule> vehicules;
    
    /**
     * nombres de véhicules présent dans la liste.
     */
    private int nbVehicules;
    
    /**
     * Constructeur. Crée une nouvelle instance de Flotte véhicule
     */
    public FlotteVehicules() {
    	vehicules =  FXCollections.observableList(new LinkedList<>());
    	nbVehicules=0;
    }
    
    /**
     * Getter pour la liste de véhicule
     * @return ObservableList
     */
    public ObservableList<Vehicule> getVehicules() {
        return this.vehicules;
    }
    /**
     * Getter pour le nombre de véhicule dans la liste.
     * @return int
     */
    public int getNbVehicules() {
        return this.nbVehicules;
    }
    
    /**
     * Setter pour le nombre de véhicule présent dans la liste.
     * @param value (int)
     */
    public void setNbVehicules(int value) {
        this.nbVehicules = value;
    }
     /**
      * Methode qui ajoute un véhicule dans la liste.
      * @param v
      * @throws DejaPresentException
      */
    public void ajouteVehicule(Vehicule v) throws DejaPresentException {
    	Iterator<Vehicule> iterator = vehicules.iterator();
    	int count = 0;
    	while (iterator.hasNext()) {
    		if (vehicules.get(count).equals(v)) {
    			throw new DejaPresentException();
    		}
    		count++;
    	}
    	vehicules.add(v);
    	nbVehicules++;
    }
    
    /**
     * Methode qui supprime un véhicule de la liste.
     * @param v
     * @throws PasPresentException
     */
    public void supprimeVehicule(Vehicule v) throws PasPresentException{
    	if (vehicules.remove(v)) {
    		return;
    	}
    	throw new PasPresentException();
    
    }
    
    /**
     * Méthode qui affiche la liste triée par type.
     */
    public void triType() {
    	Collections.sort(vehicules,new SortByTypeVehicule());
    	for (int i=0;i<nbVehicules;i++) {
    		System.out.println(vehicules.get(i).toString());
    	}
    }
    
    /**
     * Méthode qui affiche la liste trié par année de mise en circulation.
     */
    public void triAnneeMiseEnCirculation () {
    	Collections.sort(vehicules,new SortByAnnee());
    	for (int i=0;i<nbVehicules;i++) {
    		System.out.println(vehicules.get(i).toString());
    	}
    }

}
