package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.ArrayList;
import java.util.Collections;
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
	 * Nom de la liste de conducteurs
	 */
	private String nom;
	
	/**
	 * Constructeur sans paramêtre, initie une instande de Conducteurs.
	 */
	public Conducteurs(String nom) {
		conducteurs = FXCollections.observableList(new ArrayList<>());
		nbConducteurs=0;
		this.nom=nom;
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
		Collections.sort(conducteurs,new SortByTypeConducteur());
		for (int i =0;i<nbConducteurs;i++) {
			System.out.println(conducteurs.get(i).toString());
		}
	}


	/**
	 * Méthode qui affiche les conducteurs présent dans la liste, trié par ordre Alphabétique.
	 */
	public void triAlphabetique() {
		Collections.sort(conducteurs,new SortByOrdreAlphabetique());
		for (int i=0;i<nbConducteurs;i++) {
			System.out.println(conducteurs.get(i).toString());
		}

	}
}
