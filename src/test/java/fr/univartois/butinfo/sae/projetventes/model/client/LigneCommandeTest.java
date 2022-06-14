package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import fr.univartois.butinfo.sae.projetventes.model.article.Article;
import fr.univartois.butinfo.sae.projetventes.model.commande.LigneCommande;

@ExtendWith(MockitoExtension.class)
class LigneCommandeTest {

	private LigneCommande ligne;
	@Mock private Article a1;
	
	// On ne peut pas mettre de BeforeEach avec les when, sinon Junit lève une erreur pour when inutilisés.
	
	@Test
	void testConstructeur() {
		when(a1.getQuantiteStock()).thenReturn(100);
		ligne = new LigneCommande(a1, 10);
		assertThat(ligne).isInstanceOf(LigneCommande.class);
		assertThat(ligne.getArticle()).isEqualTo(a1);
		assertThat(ligne.getQuantite()).isEqualTo(10);
	}
	
	@Test
	void testGetMontant() {
		when(a1.getQuantiteStock()).thenReturn(100);
		when(a1.getPrix()).thenReturn(3.0);
		ligne = new LigneCommande(a1, 10);
		assertThat(ligne.getMontant()).isEqualTo(30);
	}
	
	@Test
	void testToString() {
		when(a1.getQuantiteStock()).thenReturn(100);
		when(a1.getPrix()).thenReturn(3.0);
		ligne = new LigneCommande(a1, 10);
		assertThat(ligne).hasToString("Réf. Art.: "+a1.getReference()+" ("+a1.getDesignation()+") | Qté.: "+ligne.getQuantite()+" | Prix U.: "+a1.getPrix()+" | Montant: "+ligne.getMontant()+" | Montant avec livr.: "+ligne.getMontantAvecLivraison());
	}
}
