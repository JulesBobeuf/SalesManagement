package fr.univartois.butinfo.sae.projetventes.model.client;

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
	void testClientEntrepriseStringStringIntString() {
		fail("Not yet implemented");
	}

	@Test
	void testClientEntreprise() {
		fail("Not yet implemented");
	}

	@Test
	void testGetContact() {
		fail("Not yet implemented");
	}

	@Test
	void testSetContact() {
		fail("Not yet implemented");
	}

}
