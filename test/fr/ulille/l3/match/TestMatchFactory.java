package fr.ulille.l3.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ulille.l3.exceptions.NoSuchTypeOfMatchException;
import fr.ulille.l3.modele.Competitor;

/**
 * Tests for the match factory
 * @author Aurélien, Lucas
 *
 */
class TestMatchFactory {

	private MatchFactory factory;
	private Competitor c1;
	private Competitor c2;
	
	/**
	 * Instantiate the factory and two competitors to try to play some matches
	 */
	@BeforeEach
	public void init() {
		this.factory = new MatchFactory();
		this.c1 = new Competitor("c1");
		this.c2 = new Competitor("c2");
	}
	
	/**
	 * Test if a basic match is rightly created with two competitors by the factory
	 * @throws NoSuchTypeOfMatchException
	 */
	@Test
	void testCreateBasicMatch() throws NoSuchTypeOfMatchException {
		Match basicMatch = this.factory.createMatch(TypeOfMatch.BasicMatch.getLabel(), c1, c2);
		assertEquals(BasicMatch.class, basicMatch.getClass());
	}
	
	/**
	 * Test if the NoSuchTypeOfMatchException is thrown when giving a wrong string
	 */
	@Test
	void testThrowsNoSuchTypeOfMatchException() {
		assertThrows(NoSuchTypeOfMatchException.class, () -> {
			this.factory.createMatch("Unknown match", c1, c2);
		});
	}

}
