package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.TestDisplayer;

class TestCompetitionFactory {

	private CompetitionFactory factory;
	private Competitor c1;
	private Competitor c2;
	private TestDisplayer displayer = TestDisplayer.getInstance();
	@BeforeEach
	public void init() {
		this.factory = CompetitionFactory.getInstance();
		this.c1 = new Competitor("c1");
		this.c2 = new Competitor("c2");
	}
	
	@Test
	void testCreateLeague() {
		List<Competitor> competitors = new ArrayList<>();
		competitors.add(c1); competitors.add(c2);
		Competition league = null;
		try {
			league = factory.createCompetition("League", competitors, 0,displayer);
		} catch (NullPointerException | CannotCreateCompetitionException | NoSuchTypeOfCompetitionException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(League.class, league.getClass());
	}

	@Test
	void testCreateTournament() {
		List<Competitor> competitors = new ArrayList<>();
		competitors.add(c1); competitors.add(c2);
		Competition tournament = null;
		try {
			tournament = factory.createCompetition("Tournament", competitors, 0,displayer);
		} catch (NullPointerException | CannotCreateCompetitionException | NoSuchTypeOfCompetitionException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(Tournament.class, tournament.getClass());
	}
	
	@Test
	void testThrowsNoSuchTypeOfCompetitionException() {
		List<Competitor> competitors = new ArrayList<>();
		competitors.add(c1); competitors.add(c2);
		assertThrows(NoSuchTypeOfCompetitionException.class, () -> {
			factory.createCompetition("Unknown", competitors, 0,displayer);
		});
	}
}
