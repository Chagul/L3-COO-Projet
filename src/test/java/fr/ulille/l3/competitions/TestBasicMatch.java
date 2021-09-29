package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.match.BasicMatch;
import main.java.fr.ulille.l3.modele.Competitor;

public class TestBasicMatch extends TestMatch{

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
