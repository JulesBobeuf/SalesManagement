package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientEntrepriseTest{

	private ClientEntreprise ce1;

	@BeforeEach
	void setUp() throws Exception {
		ce1 = new ClientEntreprise("Pierre","Rue de Pierre",150,"Un contact");
	}

	@AfterEach
	void tearDown() throws Exception {
		ce1 = null;
	}

	@Test
	void testSaisirInfos() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testClientEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	void testGetContact() {
		assertThat(ce1.getContact()).isEqualTo("Un contact");
	}

	@Test
	void testSetContact() {
		ce1.setContact("Bleu");
		assertThat(ce1.getContact()).isEqualTo("Bleu");
	}

}

