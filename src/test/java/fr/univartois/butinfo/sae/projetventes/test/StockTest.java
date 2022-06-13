package fr.univartois.butinfo.sae.projetventes.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.univartois.butinfo.sae.projetventes.model.article.Stock;

class StockTest {

	private static Instant start;
	
	@BeforeAll
	void debut() {
		start = Instant.now();
	}
	
	@AfterAll
	void fin() {
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
	}
	
	@BeforeEach
	void testConstructeur() {
		Stock stock = new Stock("Monsieur Condotta");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
