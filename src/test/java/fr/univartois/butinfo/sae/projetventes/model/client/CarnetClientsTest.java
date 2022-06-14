package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
		assertThat(carnetCl.getNbClients()).isZero();
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
		Client client = new ClientParticulier("UN","20 rue des Tulipes, 62000 Lens, France",0,"SUPER",Genre.Homme);
		carnetCl.ajouterClient(client);
		Client recherche = carnetCl.rechercherClientParReference(client.getReference());
		assertThat(client).isEqualTo(recherche);
		
		Client existePas = carnetCl.rechercherClientParReference(15151);
		assertThat(existePas).isNull();
	}

	@Test
	void testClientsDansCarnet() {
		Client client = new ClientParticulier("UN","20 rue des Tulipes, 62000 Lens, France",0,"SUPER",Genre.Homme);
		Client client2 = new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme);
		carnetCl.ajouterClient(client);
		carnetCl.ajouterClient(client2);
		carnetCl.clientsDansCarnet();
	}

	@Test
	void testClientsParticulierDansCarnet() {
		Client client = new ClientParticulier("UN","20 rue des Tulipes, 62000 Lens, France",0,"SUPER",Genre.Homme);
		carnetCl.ajouterClient(client);
		Client[] tab = carnetCl.clientsParticulierDansCarnet();
		assertThat(tab).hasSize(1);
	}

	@Test
	void testClientsEntrepriseDansCarnet() {
		Client client = new ClientEntreprise("UN","20 rue des Tulipes, 62000 Lens, France",0,"SUPER");
		carnetCl.ajouterClient(client);
		Client[] tab = carnetCl.clientsEntrepriseDansCarnet();
		assertThat(tab).hasSize(1);

	}

	@Test
	void testRechercherClientsParMotCle() {
		Client client = new ClientEntreprise("UN","20 rue des Tulipes, 62000 Lens, France",0,"SUPER");
		Client client2 = new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme);
		carnetCl.ajouterClient(client);
		carnetCl.ajouterClient(client2);
		Client[] tab1 = carnetCl.rechercherClientsParMotCle("Tulipes");
		Client[] tab2 = carnetCl.rechercherClientsParMotCle("Cure");
		Client[] tab3 = carnetCl.rechercherClientsParMotCle("existePas");
		assertThat(tab1).hasSize(2);
		assertThat(tab2).hasSize(1);
		assertThat(tab3).isEmpty();
		
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
		assertThat(carnetCl.getNbClients()).isZero();
	}

}
