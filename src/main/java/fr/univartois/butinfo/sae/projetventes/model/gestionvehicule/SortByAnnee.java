package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Comparator;

/**
 * Classe permettant de trier une liste de véhicule par année de mise en circulation. 
 * @author Jules
 *
 */
public class SortByAnnee implements Comparator<Vehicule> {
	
	/**
	 * Méthode permettant d'éffectuer nôtre tri
	 * @param v1
	 * @param v2
	 * @return int
	 */
	@Override
	public int compare(Vehicule v1, Vehicule v2) {
		return v1.getAnneeMiseEnCirculation()-v2.getAnneeMiseEnCirculation();
	}

}
