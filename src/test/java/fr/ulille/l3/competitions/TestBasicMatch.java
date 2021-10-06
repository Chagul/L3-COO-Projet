package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.match.BasicMatch;
import main.java.fr.ulille.l3.match.Match;
import main.java.fr.ulille.l3.modele.Competitor;

/**
 * Tests of the BasicMatch class 
 * @author Aurélien,Lucas
 *
 */
public class TestBasicMatch extends TestMatch{
	
	/**
	 * Test if a competitor is returned after a match is played
	 */
	@Test
	void testPlay() {
		assertEquals(Competitor.class, match1.play().getClass());
	}

	@Override
	protected Match createMatch() throws Exception {
		return new BasicMatch(c1,c2);
	}
}
