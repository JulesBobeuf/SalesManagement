package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientEntrepriseTest{

	private ClientEntreprise ce1;
	private ClientEntreprise ce2;

	@BeforeEach
	void setUp() throws Exception {
		ce1 = new ClientEntreprise("Pierre","Rue de Pierre",69,"Un contact");
		ce2 = new ClientEntreprise("Jean","Rue de Jean",3000,"Un autre contact");
	}

	@AfterEach
	void tearDown() throws Exception {
		ce1 = null;
		ce2 = null;
	}

	@Test
	void testConstructeur() {
		assertThat(ce1).isInstanceOf(Client.class);
		assertThat(ce1).isInstanceOf(ClientEntreprise.class);
		assertThat(ce1.getNom()).isEqualTo("Pierre");
		assertThat(ce1.getAdresse()).isEqualTo("Rue de Pierre");
		assertThat(ce1.getPointsFidelite()).isEqualTo(69);
		assertThat(ce1.getContact()).isEqualTo("Un contact");
	}
	
	@Test
	void testSetNom() {
		ce1.setNom("Paire");
		assertThat(ce1.getNom()).isEqualTo("Paire");
	}
	
	@Test
	void testSetAdresse() {
		ce1.setAdresse("Ici");
		assertThat(ce1.getAdresse()).isEqualTo("Ici");
	}
	
	@Test
	void testSetPointsFidelite() {
		ce1.setPointsFidelite(10);
		assertThat(ce1.getPointsFidelite()).isEqualTo(10);
	}
	
	@Test
	void testSetContact() {
		ce1.setContact("Bleu");
		assertThat(ce1.getContact()).isEqualTo("Bleu");
	}
	
	@Test
	void testGetRistourne() {
		assertThat(ce1.getRistourne()).isZero();
		ce1.setPointsFidelite(101);
		assertThat(ce1.getRistourne()).isEqualTo(5);
		ce1.setPointsFidelite(500);
		assertThat(ce1.getRistourne()).isEqualTo(10);
		ce1.setPointsFidelite(1000);
		assertThat(ce1.getRistourne()).isEqualTo(15);
	}
	
	@Test
	void testToString() {
		assertThat(ce1).hasToString("Référence :\t\t"	+ ce1.getReference() + "\nNom :\t\t\t" + ce1.getNom() + "\nAdresse :\t\t" + ce1.getAdresse() + "\nPoints Fidélité :\t"+ ce1.getPointsFidelite()+ "\nRistourne (%) :\t\t"+ ce1.getRistourne()+ "\nContact :\t\t"+ ce1.getContact());
	}
	
	@Test
	void testEquals() {
		assertThat(ce1.equals(ce1)).isTrue();
		assertThat(ce1.equals(ce2)).isFalse();
	}
}

