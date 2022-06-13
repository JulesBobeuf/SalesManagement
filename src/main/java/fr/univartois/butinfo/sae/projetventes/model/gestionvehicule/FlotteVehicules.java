package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlotteVehicules {
    private ObservableList<Vehicule> vehicules;

    private int nbVehicules;
    
    public FlotteVehicules() {
    	vehicules =  FXCollections.observableList(new LinkedList<>());
    	nbVehicules=0;
    }

    public ObservableList<Vehicule> getVehicules() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.vehicules;
    }

    public int getNbVehicules() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nbVehicules;
    }

    public void setNbVehicules(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nbVehicules = value;
    }

    public void ajouteVehicule(String v) {
    }

    public void supprimeVehicule(Vehicule v) {
    }

    public void triType() {
    }

    public void triAnneeMiseEnCirculation () {
    }

}
