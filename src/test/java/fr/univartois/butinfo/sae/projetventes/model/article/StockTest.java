package fr.univartois.butinfo.sae.projetventes.model.article;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.univartois.butinfo.sae.projetventes.model.article.Article;
import fr.univartois.butinfo.sae.projetventes.model.article.Stock;

@ExtendWith(MockitoExtension.class)
class StockTest {
	
	private Stock stock;
	@Mock Article a1;
	@Mock Article a2;
	@Mock Article a3;
	@Mock Article a4;
	@Mock Article a5;
	@Mock Article a6;
	@Mock Article a7;
	@Mock Article a8;
	@Mock Article a9;
	@Mock Article a10;

	@BeforeEach
	public void init() {
		stock = new Stock("stock");
	}
	
	@Test
	void testConstructeur() {
		assertThat(stock.getNom()).isEqualTo("stock");
		assertThat(stock.getNbArticles()).isEqualTo(0);
	}

	@Test
	void testEstPlein() {
		assertThat(stock.estPlein()).isEqualTo(false);
		stock.ajouterArticle(a1);
		stock.ajouterArticle(a2);
		stock.ajouterArticle(a3);
		stock.ajouterArticle(a4);
		stock.ajouterArticle(a5);
		stock.ajouterArticle(a6);
		stock.ajouterArticle(a7);
		stock.ajouterArticle(a8);
		stock.ajouterArticle(a9);
		stock.ajouterArticle(a10);
		assertThat(stock.estPlein()).isEqualTo(true);
	}

	@Test
	void testEstVide() {
		assertThat(stock.estVide()).isEqualTo(true);
		stock.ajouterArticle(a1);
		assertThat(stock.estVide()).isEqualTo(false);
	}

	@Test
	void testAjouterArticleSupprimerArticle() {
		stock.ajouterArticle(a1);
		assertThat(stock.articlesDansStock()[0]).isEqualTo(a1);
		stock.supprimerArticle(a1);
		assertThat(stock.getNbArticles()).isEqualTo(0);
	}

	@Test
	void testRechercherArticleParReference() {
		stock.ajouterArticle(a1);
		stock.ajouterArticle(a2);
		stock.ajouterArticle(a3);
		when(a1.getReference()).thenReturn(0);
		when(a2.getReference()).thenReturn(1);
		assertThat(stock.rechercherArticleParReference(1)).isEqualTo(a2);
	}


	@Test
	void testRechercherArticlesCategorie() {
		stock.ajouterArticle(a1);
		stock.ajouterArticle(a2);
		stock.ajouterArticle(a3);
		when(a1.getCategorie()).thenReturn("car");
		when(a2.getCategorie()).thenReturn("zar");
		when(a3.getCategorie()).thenReturn("car");
		Article[] result = new Article[2];
		result[0] = a1;
		result[1] = a3;
		assertThat(stock.rechercherArticlesCategorie("car")).isEqualTo(result);
	}

	@Test
	void testGetNomSetNom() {
		stock.setNom("wow");
		assertThat(stock.getNom()).isEqualTo("wow");
	}

	@Test
	void testGetNbArticles() {
		assertThat(stock.getNbArticles()).isEqualTo(0);
	}

}
