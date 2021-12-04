package fr.ulille.l3.match;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.ulille.l3.modele.Competitor;

/**
 * Tests of the BasicMatch class 
 * @author Aurélien,Lucas
 */
public class TestBasicMatch extends TestMatch{
	
	/**
	 * Test if a competitor is returned after a match is played
	 */
	@Test
	void testPlay() {
		match1.play();
		assertEquals(Competitor.class, match1.getWinner().getClass());
	}

	@Override
	protected Match createMatch() throws Exception {
		return new BasicMatch(this.c1, this.c2);
	}
}
