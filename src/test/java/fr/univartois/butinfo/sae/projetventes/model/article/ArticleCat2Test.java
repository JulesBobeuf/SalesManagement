package fr.univartois.butinfo.sae.projetventes.model.article;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArticleCat2Test {
	
	public ArticleCat2 a1;

	@BeforeEach
	void setUp() throws Exception {
		a1 = new ArticleCat2("VTT",150,2,150);
	}

	@AfterEach
	void tearDown() throws Exception {
		a1 = null;
	}

	@Test
	void testArticleCat2StringDoubleIntDouble() {
		assertThat(a1.getCategorie()).isEqualTo("Vélos");
	}

	@Test
	void testGetPoids() {
		assertThat(a1.getPoids()).isEqualTo(150);
	}

	@Test
	void testSetPoids() {
		ArticleCat2 a2 = new ArticleCat2("VTT",150,2,150);
		a1.setPoids(20);
		a2.setPoids(-10);
	}

	@Test
	void testGetHauteurColis() {
		assertThat(a1.getHauteurColis()).isEqualTo(90);
	}

	@Test
	void testGetLargeurColis() {
		assertThat(a1.getLargeurColis()).isEqualTo(170);
	}

	@Test
	void testGetProfondeurColis() {
		assertThat(a1.getProfondeurColis()).isEqualTo(40);
	}

	@Test
	void testGetPoidsKgColis() {
		assertThat(a1.getPoidsKgColis()).isEqualTo(151);
	}

}
