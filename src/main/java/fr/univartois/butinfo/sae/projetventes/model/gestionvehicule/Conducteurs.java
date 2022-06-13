package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.butinfo.sae.projetventes.model.client.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * CLasse qui crée une liste de conducteurs.
 * @author Jules
 */
public class Conducteurs {
	/**
	 * Liste de conducteur (ObservableList)
	 */
    private ObservableList<Conducteur> conducteurs;
    
    /**
     * nombre de conducteurs dans la liste (int)
     */
    private int nbConducteurs;

    /**
     * Constructeur sans paramêtre, initie une instande de Conducteurs.
     */
    public Conducteurs() {
    	conducteurs = FXCollections.observableList(new ArrayList<>());
    	nbConducteurs=0;
    }
    
    /**
     * @return ObservableList
     */
    public ObservableList<Conducteur> getConducteurs() {
        return this.conducteurs;
    }
    
    /**
     * @return int
     */
    public int getNbConducteurs() {
        return this.nbConducteurs;
    }
    
    /**
     * Setter pour la valeur du nombre de conducteurs présent dans la liste.
     * @param value (int)
     */
    public void setNbConducteurs(int value) {
        this.nbConducteurs = value;
    }

    /**
     * Méthode qui ajoute un conducteur à la liste.
     * @param c
     */
    public void ajouteConducteur(Conducteur c) {
    	for (int i=0;i<nbConducteurs;i++) {
    		if (conducteurs.get(i).equals(c)) {
    			return;
    		}
    	}
    	conducteurs.add(c);
    	nbConducteurs++;
    }
    
    /**
     * Méthode qui supprime un conducteur à la liste.
     * @param c
     */
    public void supprimeConducteur(Conducteur c) {
    	if (nbConducteurs==0) {
    		return;
    	}
    	for (int i=0;i<nbConducteurs;i++) {
    		if (conducteurs.get(i).equals(c)) {
    			conducteurs.remove(c);
    	    	nbConducteurs--;
    		}
    	}
    }
    
    /**
     * Méthode qui affiche les conducteurs présent dans la liste, trié par type.
     */
    public void triType() {
    	for (int i =0;i<nbConducteurs;i++) {
    		if (conducteurs.get(i) instanceof Commercial) {
    			System.out.println(conducteurs.get(i).toString());
    		}
    	}
    	for (int i =0;i<nbConducteurs;i++) {
    		if (conducteurs.get(i) instanceof Livreur) {
    			System.out.println(conducteurs.get(i).toString());
    		}
    	}
    }
    
    /**
     * Méthode qui affiche les conducteurs présent dans la liste, trié par ordre Alphabétique.
     */
    public void triAlphabetique() {
    	Conducteur temp;
    	int indice;
    	for (int i=0;i<nbConducteurs;i++) {
    		indice=0;
    		for (int j=0;i<=j;i++) {
    			if (conducteurs.get(i).getNom().compareTo(conducteurs.get(indice).getNom())>0) {
    				indice=j;
    			}
    			if (conducteurs.get(i).getNom().compareTo(conducteurs.get(indice).getNom())==0) {
    				if (conducteurs.get(i).getPrenom().compareTo(conducteurs.get(indice).getPrenom())>0) {
        				indice=j;
        			}
    			}
    		}
    		System.out.println(conducteurs.get(indice).toString());
    	}
    	
    }

    
    /*
     * int indiceMax;
		Client temp;
		for (int i=clients.length-1;i>0;i--) {
			indiceMax=0;
			for (int j=1;j<=i;j++)
				if ((clients[j].nom.compareTo(clients[indiceMax].nom))>0)
					indiceMax=j;
			temp=clients[i];
			clients[i]=clients[indiceMax];
			clients[indiceMax]=temp;
		}
	}
     */
}
