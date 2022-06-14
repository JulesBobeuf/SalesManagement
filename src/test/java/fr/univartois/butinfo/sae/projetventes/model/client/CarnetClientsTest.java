package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
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
		Client client = new ClientParticulier("UN","20 rue des Tulipes, 62000 Lens, France",0,"SUPER",Genre.Homme);
		Client client2 = new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme);
		carnetCl.ajouterClient(client);
		carnetCl.ajouterClient(client2);
		carnetCl.supprimerClient(client2);
		assertThat(carnetCl.getNbClients()).isEqualTo(1);
		carnetCl.supprimerClient(client2);
		assertThat(carnetCl.getNbClients()).isEqualTo(1);
	}


	@Test
	void testRechercherClientParReference() {
		
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
		assertThat(carnetCl.getNom()).isEqualTo("carnet1");
	}

	@Test
	void testSetNom() {
		carnetCl.setNom("autre");
		assertThat(carnetCl.getNom()).isEqualTo("autre");
	}

	@Test
	void testGetNbClients() {
		assertThat(carnetCl.getNbClients()).isEqualTo(0);
	}

}
