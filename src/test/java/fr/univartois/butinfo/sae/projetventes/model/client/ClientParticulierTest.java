package fr.univartois.butinfo.sae.projetventes.model.client;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientParticulierTest{

	private ClientParticulier cli;
	private ClientParticulier autreCli;

	@BeforeEach
	void setUp() throws Exception {
		cli = new ClientParticulier("Hong San Fu","10 Rue du Chien Mangé",69,"Chang", Genre.Homme);
		autreCli = new ClientParticulier("Han","11 Rue du Chien Mangé",69,"Ching", Genre.Femme);
	}

	@AfterEach
	void tearDown() throws Exception {
		cli = null;
		autreCli = null;
	}

	@Test
	void testConstructeur() {
		assertThat(cli).isInstanceOf(Client.class);
		assertThat(cli).isInstanceOf(ClientParticulier.class);
		assertThat(cli.getNom()).isEqualTo("Hong San Fu");
		assertThat(cli.getPrenom()).isEqualTo("Chang");
		assertThat(cli.getGenre()).isEqualTo(Genre.Homme);
		assertThat(cli.getPointsFidelite()).isEqualTo(69);
	}
	
	@Test
	void testSetNom() {
		cli.setNom("Paire");
		assertThat(cli.getNom()).isEqualTo("Paire");
	}
	
	@Test
	void testSetPrenom() {
		cli.setPrenom("Benoit");
		assertThat(cli.getPrenom()).isEqualTo("Benoit");
	}

	@Test
	void testSetAdresse() {
		cli.setAdresse("Ici");
		assertThat(cli.getAdresse()).isEqualTo("Ici");
	}
	
	@Test
	void testSetGenre() {
		cli.setGenre(Genre.Femme);
		assertThat(cli.getGenre()).isEqualTo(Genre.Femme);
	}
	
	@Test
	void testSetPointsFidelite() {
		cli.setPointsFidelite(10);
		assertThat(cli.getPointsFidelite()).isEqualTo(10);
	}
	
	@Test
	void testGetRistourne() {
		assertThat(cli.getRistourne()).isZero();
		cli.setPointsFidelite(101);
		assertThat(cli.getRistourne()).isEqualTo(5);
		cli.setPointsFidelite(500);
		assertThat(cli.getRistourne()).isEqualTo(10);
		cli.setPointsFidelite(1000);
		assertThat(cli.getRistourne()).isEqualTo(15);
	}
	
	@Test
	void testToString() {
		assertThat(cli).hasToString("Référence :\t\t"	+ cli.getReference() + "\nNom :\t\t\t" + cli.getNom() + "\nAdresse :\t\t" + cli.getAdresse() + "\nPoints Fidélité :\t"+ cli.getPointsFidelite()+ "\nRistourne (%) :\t\t"+ cli.getRistourne() + "\nPrénom :\t\t"+ cli.getPrenom()+"\nGenre :\t\t\t"+cli.getGenre());
	}
	
	@Test
	void testEquals() {
		assertThat(cli.equals(cli)).isTrue();
		assertThat(cli.equals(autreCli)).isFalse();
	}
}
