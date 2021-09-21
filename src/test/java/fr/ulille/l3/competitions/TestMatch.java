package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.BasicMatch;
import main.java.fr.ulille.l3.competitions.Competitor;
import main.java.fr.ulille.l3.competitions.Match;

class TestMatch {

	private Competitor c1;
	private Competitor c2;
	private Match match1;
	@BeforeEach
	void init() {
		c1 = new Competitor("Lucas");
		c2 = new Competitor("Aurélien");
		match1 = new BasicMatch(c1,c2);
	}
	@Test
	void testPlay() {
		assertEquals(Competitor.class, match1.play().getClass());
	}

}
