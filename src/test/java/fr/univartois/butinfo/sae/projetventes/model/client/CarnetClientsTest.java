package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarnetClientsTest {
	private CarnetClients carnetCl;
	
	@BeforeEach
	void setUp() throws Exception {
		carnetCl = new CarnetClients("carnet1");
	}

	@AfterEach
	void tearDown() throws Exception {
		carnetCl = null;
	}

	@Test
	void testCarnetClients() {
		assertThat(carnetCl.getNom()).isEqualTo("carnet1");
		assertThat(carnetCl.getNbClients()).isEqualTo(0);
	}

	@Test
	void testEstPlein() {
		for(int i = 0; i < carnetCl.MAX_CLIENTS; i++) {
			carnetCl.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme));
		}
		assertThat(carnetCl.estPlein()).isEqualTo(true);
	}

	@Test
	void testEstVide() {
		assertThat(carnetCl.estVide()).isEqualTo(true);
		carnetCl.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme));
		assertThat(carnetCl.estVide()).isEqualTo(false);
	}

	@Test
	void testAjouterClient() {
		carnetCl.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme));
		assertThat(carnetCl.getNbClients()).isEqualTo(1);
		
		for (int i = 0;i<carnetCl.MAX_CLIENTS;i++)
			carnetCl.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme));
		assertThat(carnetCl.getNbClients()).isEqualTo(carnetCl.MAX_CLIENTS);
	}

	@Test
	void testSupprimerClient() {
		carnetCl.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme));
		carnetCl.supprimerClient();
	}

	@Test
	void testRechercherClientParReference() {
		fail("Not yet implemented");
	}

	@Test
	void testClientsDansCarnet() {
		fail("Not yet implemented");
	}

	@Test
	void testClientsParticulierDansCarnet() {
		fail("Not yet implemented");
	}

	@Test
	void testClientsEntrepriseDansCarnet() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherClientsParMotCle() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNom() {
		fail("Not yet implemented");
	}

	@Test
	void testSetNom() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNbClients() {
		fail("Not yet implemented");
	}

}
