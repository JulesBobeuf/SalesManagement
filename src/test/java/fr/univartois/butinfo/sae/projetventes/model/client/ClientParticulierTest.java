package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientParticulierTest{

	private ClientParticulier cli;

	@BeforeEach
	void setUp() throws Exception {
		cli = new ClientParticulier("Hong San Fu","10 Rue du Chien Mangé",69,"Chang", Genre.Homme);
	}

	@AfterEach
	void tearDown() throws Exception {
		cli = null;
	}

	@Test
	void testGetNom() {
		assertThat(cli.getNom()).isEqualTo("Hong San Fu");
	}
	
	@Test
	void testSetNom() {
		cli.setPrenom("Paire");
		assertThat(cli.getPrenom()).isEqualTo("Paire");
	}
	
	@Test
	void testGetPrenom() {
		assertThat(cli.getPrenom()).isEqualTo("Chang");
	}
	
	@Test
	void testSetPrenom() {
		cli.setPrenom("Benoit");
		assertThat(cli.getPrenom()).isEqualTo("Benoit");
	}
	
	@Test
	void testGetGenre() {
		assertThat(cli.getGenre()).isEqualTo(Genre.Homme);
	}

	@Test
	void testSetGenre() {
		cli.setGenre(Genre.Femme);
		assertThat(cli.getGenre()).isEqualTo(Genre.Femme);
	}
	
	@Test
	void testToString() {
		assertThat(cli.toString()).isEqualTo("Référence :\t\t"	+ cli.getReference() + "\nNom :\t\t\t" + cli.getNom() + "\nAdresse :\t\t" + cli.getAdresse() + "\nPoints Fidélité :\t"+ cli.getPointsFidelite()+ "\nRistourne (%) :\t\t"+ cli.getRistourne() + "\nPrénom :\t\t"+ cli.getPrenom()+"\nGenre :\t\t\t"+cli.getGenre());
	}
	
}
