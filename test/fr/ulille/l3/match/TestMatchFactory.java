package fr.ulille.l3.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.exceptions.NoSuchTypeOfMatchException;
import main.java.fr.ulille.l3.match.BasicMatch;
import main.java.fr.ulille.l3.match.Match;
import main.java.fr.ulille.l3.match.MatchFactory;
import main.java.fr.ulille.l3.modele.Competitor;

class TestMatchFactory {

	private MatchFactory factory;
	private Competitor c1;
	private Competitor c2;
	
	@BeforeEach
	public void init() {
		this.factory = new MatchFactory();
		this.c1 = new Competitor("c1");
		this.c2 = new Competitor("c2");
	}
	
	@Test
	void testCreateBasicMatch() throws NoSuchTypeOfMatchException {
		Match basicMatch = this.factory.createMatch("BasicMatch", c1, c2);
		assertEquals(BasicMatch.class, basicMatch.getClass());
	}
	
	@Test
	void testThrowsNoSuchTypeOfMatchException() {
		assertThrows(NoSuchTypeOfMatchException.class, () -> {
			this.factory.createMatch("Unknown match", c1, c2);
		});
	}

}
