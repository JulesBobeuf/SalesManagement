package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Comparator;

/**
 * Classe permettant de trier une liste de véhicule par type de véhicule. 
 * @author Jules
 *
 */
public class SortByTypeVehicule implements Comparator<Vehicule>{
	
	/**
	 * Méthode permettant d'éffectuer nôtre tri.
	 * @param v1
	 * @param v2
	 * @return int
	 */
	@Override
	public int compare(Vehicule v1, Vehicule v2) {
			if (v1 instanceof Fourgon && v2 instanceof Fourgon) {
				return 0;
			}
			if (v1 instanceof Voiture && v2 instanceof Voiture) {
				return 0;
			}
			if (v1 instanceof Fourgon && v2 instanceof Voiture) {
				return 1;
			}
			return -1;
	}
}
