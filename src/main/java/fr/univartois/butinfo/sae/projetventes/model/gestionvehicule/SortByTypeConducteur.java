package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Comparator;

/**
 * Classe permettant de trier une liste de conducteurs par type de conducteur. 
 * @author Jules
 *
 */
public class SortByTypeConducteur implements Comparator<Conducteur>{
	
	/**
	 * Méthode permettant d'éffectuer nôtre tri.
	 * @param c1
	 * @param c2
	 * @return int
	 */
	@Override
	public int compare(Conducteur c1, Conducteur c2) {

		if (c1 instanceof Commercial && c2 instanceof Commercial) {
			return 0;
		}
		if (c1 instanceof Livreur && c2 instanceof Livreur) {
			return 0;
		}
		if (c1 instanceof Commercial && c2 instanceof Livreur) {
			return 1;
		}
		return -1;
	}

}
