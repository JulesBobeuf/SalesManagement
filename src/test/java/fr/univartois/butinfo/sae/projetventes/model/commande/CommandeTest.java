package fr.univartois.butinfo.sae.projetventes.model.commande;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.univartois.butinfo.sae.projetventes.model.article.Article;
import fr.univartois.butinfo.sae.projetventes.model.client.Client;
import fr.univartois.butinfo.sae.projetventes.model.client.ClientEntreprise;

@ExtendWith(MockitoExtension.class)

class CommandeTest {

	private Commande commande1 ;
	@Mock private Client client1;
	@Mock Article article1;
	@Mock Article article2;
	@Mock Article article3;
	@Mock Article article4;
	@Mock Article article5;
	@Mock Article article6;
	@Mock Article article7;
	@Mock Article article8;
	@Mock Article article9;
	@Mock Article article10;
	@Mock Article article11;
	@Mock Article article12;
	@Mock Article article13;
	@Mock Article article14;
	
	@BeforeEach
	void setUp() throws Exception {
		commande1 = new Commande(client1);
	}

	@AfterEach 
	void tearDown() throws Exception {
		commande1 = null;
	}

	@Test
	void testEstPleine() {
		when(article1.getQuantiteStock()).thenReturn(100);
		when(article1.getReference()).thenReturn(1);
		when(article2.getQuantiteStock()).thenReturn(100);
		when(article2.getReference()).thenReturn(2);
		when(article3.getQuantiteStock()).thenReturn(100);
		when(article3.getReference()).thenReturn(3);
		when(article4.getQuantiteStock()).thenReturn(100);
		when(article4.getReference()).thenReturn(4);
		when(article5.getQuantiteStock()).thenReturn(100);
		when(article5.getReference()).thenReturn(5);
		when(article6.getQuantiteStock()).thenReturn(100);
		when(article6.getReference()).thenReturn(6);
		when(article7.getQuantiteStock()).thenReturn(100);
		when(article7.getReference()).thenReturn(7);
		when(article8.getQuantiteStock()).thenReturn(100);
		when(article8.getReference()).thenReturn(8);
		when(article9.getQuantiteStock()).thenReturn(100);
		when(article9.getReference()).thenReturn(9);
		when(article10.getQuantiteStock()).thenReturn(100);
		when(article10.getReference()).thenReturn(10);
		assertThat(commande1.estPleine()).isEqualTo(false);
		commande1.commander(article1,2);
		commande1.commander(article2,2);
		commande1.commander(article3,2);
		commande1.commander(article4,2);
		commande1.commander(article5,2);
		commande1.commander(article6,2);
		commande1.commander(article7,2);
		commande1.commander(article8,2);
		commande1.commander(article9,2);
		commande1.commander(article10,2);
		assertThat(commande1.getNbLignesCommande()).isEqualTo(10);
		assertThat(commande1.estPleine()).isEqualTo(true);
	}

	@Test
	void testEstVide() {
		assertTrue(commande1.estVide());
		when(article1.getQuantiteStock()).thenReturn(100);
		when(article1.getReference()).thenReturn(1);
		commande1.commander(article1,2);
		assertFalse(commande1.estVide());
	}

	@Test
	void testEstCloturee() {
		assertFalse(commande1.estCloturee());
		commande1.cloturer(true);
		assertTrue(commande1.estCloturee());
	}

	@Test
	void testSupprimerLigneCommande() {
		commande1.supprimerLigneCommande(1);
		when(article1.getQuantiteStock()).thenReturn(100);
		when(article1.getReference()).thenReturn(1);
		commande1.commander(article1,2);
		commande1.supprimerLigneCommande(1);
		commande1.cloturer(true);
		commande1.supprimerLigneCommande(1);
	}

	@Test
	void testCommander() {
		when(article1.getQuantiteStock()).thenReturn(100);
		when(article1.getReference()).thenReturn(1);
		when(article2.getQuantiteStock()).thenReturn(100);
		when(article2.getReference()).thenReturn(2);
		when(article3.getQuantiteStock()).thenReturn(100);
		when(article3.getReference()).thenReturn(3);
		when(article4.getQuantiteStock()).thenReturn(100);
		when(article4.getReference()).thenReturn(4);
		when(article5.getQuantiteStock()).thenReturn(100);
		when(article5.getReference()).thenReturn(5);
		when(article6.getQuantiteStock()).thenReturn(100);
		when(article6.getReference()).thenReturn(6);
		when(article7.getQuantiteStock()).thenReturn(100);
		when(article7.getReference()).thenReturn(7);
		when(article8.getQuantiteStock()).thenReturn(100);
		when(article8.getReference()).thenReturn(8);
		when(article9.getQuantiteStock()).thenReturn(100);
		when(article9.getReference()).thenReturn(9);
		when(article10.getQuantiteStock()).thenReturn(100);
		when(article10.getReference()).thenReturn(10);
		when(article11.getQuantiteStock()).thenReturn(100);
		when(article11.getReference()).thenReturn(11);
		when(article12.getQuantiteStock()).thenReturn(0);
		when(article12.getReference()).thenReturn(12);
		assertFalse(commande1.commander(article5,0));
		assertFalse(commande1.commander(article12,2));
		assertFalse(commande1.commander(article12,2));
		commande1.cloturer(true);
		assertFalse(commande1.commander(article1,2));
	}

	@Test
	void testGetReference() {
		when(article1.getQuantiteStock()).thenReturn(100);
		when(article1.getReference()).thenReturn(1);
		assertThat(commande1.getReference()).isEqualTo(6);
	}

	@Test
	void testGetMontantAvecLivraison() {
		when(article1.getQuantiteStock()).thenReturn(100);
		when(article1.getReference()).thenReturn(1);
		when(article2.getQuantiteStock()).thenReturn(100);
		when(article2.getReference()).thenReturn(2);
		commande1.commander(article1,2);
		commande1.commander(article2,2);
		assertThat(commande1.getMontantAvecLivraison()).isEqualTo(0);
	}

	@Test
	void testGetMontant() {
		//when(article1.getQuantiteStock()).thenReturn(100);
		//when(article1.getReference()).thenReturn(1);
		//commande1.commander(article1,2);
		//commande1.cloturer(true);
		//commande1.cloturer(true);
	}

	@Test
	void testCloturer() {
		when(article1.getQuantiteStock()).thenReturn(100);
		when(article1.getReference()).thenReturn(1);
		commande1.commander(article1,2);
		commande1.cloturer(false);
		commande1.cloturer(true);
	}

	@Test
	void testGetArticle() {
		fail("Not yet implemented");
	}

	@Test
	void testGetQuantite() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
