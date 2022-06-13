package fr.univartois.butinfo.sae.projetventes.model.gestionvehicule;

import java.util.Comparator;

/**
 * Classe permettant de trier une liste de conducteurs par ordre Alphabetique. 
 * @author Jules
 *
 */
public class SortByOrdreAlphabetique implements Comparator<Conducteur> {
	
	/**
	 * Méthode permettant d'éffectuer nôtre tri.
	 * @param c1
	 * @param c2
	 * @return int
	 */
	@Override
	public int compare(Conducteur c1, Conducteur c2) {
		if (c1.getNom().compareTo(c2.getNom())>0) {
			return 1;
		}
		if (c1.getNom().compareTo(c2.getNom())<0) {
			return -1;
		}
		if (c1.getPrenom().compareTo(c2.getPrenom())>0) {
			return 1;
		}
		if (c1.getPrenom().compareTo(c2.getPrenom())<0) {
			return -1;
		}
		return 0;
	}

}
