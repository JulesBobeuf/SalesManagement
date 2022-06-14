package fr.univartois.butinfo.sae.projetventes.model.commande;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EnsembleCommandesTest {

	private EnsembleCommandes ensembleCommandes;
	@Mock Commande commande1;
	@Mock Commande commande2;
	@Mock Commande commande3;
	
	@BeforeEach
	void setUp() throws Exception {
		ensembleCommandes = new EnsembleCommandes();
	}

	@AfterEach
	void tearDown() throws Exception {
		ensembleCommandes = null;
	}

	@Test
	void testEnsembleCommandes() {
		assertThat(ensembleCommandes.estVide()).isTrue();
	}

	@Test
	void testEstPlein() {
		assertThat(ensembleCommandes.estPlein()).isFalse();
	}

	@Test
	void testEstVide() {
		assertThat(ensembleCommandes.estVide()).isTrue();
		ensembleCommandes.ajouterCommande(commande1);
		assertThat(ensembleCommandes.estVide()).isFalse();
	}

	@Test
	void testChercherCommande() {
		ensembleCommandes.ajouterCommande(commande1);
		ensembleCommandes.ajouterCommande(commande2);
		when(commande1.getReference()).thenReturn(2);
		assertThat(ensembleCommandes.chercherCommande(1533)).isNull();
		assertThat(ensembleCommandes.chercherCommande(commande1.getReference())).isEqualTo(commande1);
	}

	@Test
	void testSupprimerCommande() {
		ensembleCommandes.ajouterCommande(commande1);
		ensembleCommandes.ajouterCommande(commande2);
		ensembleCommandes.ajouterCommande(commande3);
		when(commande2.getReference()).thenReturn(2);
		when(commande2.estCloturee()).thenReturn(true);
		assertThat(ensembleCommandes.supprimerCommande(4141)).isFalse();
		assertThat(ensembleCommandes.supprimerCommande(commande2.getReference())).isTrue();
		assertThat(ensembleCommandes.supprimerCommande(commande3.getReference())).isFalse();
	}

	@Test
	void testAjouterCommande() {
		ensembleCommandes.ajouterCommande(commande1);
		Commande[] tab = ensembleCommandes.getCommandes();
		assertThat(tab).hasSize(1);
	}

	@Test
	void testGetCommandes() {
		ensembleCommandes.ajouterCommande(commande1);
		ensembleCommandes.ajouterCommande(commande2);
		Commande[] tab = ensembleCommandes.getCommandes();
		assertThat(tab).hasSize(2);
	}
}
