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
import fr.ulille.l3.exceptions.NoSuchTypeOfStrategyException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.strategy.TypeOfStrategy;
import fr.ulille.l3.util.TestDisplayer;

/**
 * Tests for the competition factory
 * @author Aurélien, Lucas
 *
 */
class TestCompetitionFactory {

	private CompetitionFactory factory;
	private Competitor c1;
	private Competitor c2;
	private List<Competitor> competitors;
	private Competition competition;
	private TestDisplayer displayer = TestDisplayer.getInstance();
	
	/**
	 * Instantiate the factory and create 
	 */
	@BeforeEach
	public void init() {
		this.factory = CompetitionFactory.getInstance();
		this.c1 = new Competitor("c1");
		this.c2 = new Competitor("c2");
		this.competitors = new ArrayList<>();
		competitors.add(c1); competitors.add(c2);
	}
	
	/**
	 * Test the creation of a league by the factory
	 */
	@Test
	void testCreateLeague() {
		this.competition = null;
		try {
			this.competition = factory.createCompetition(TypeOfCompetition.League.getLabel(), competitors, displayer);
		} catch (NullPointerException | CannotCreateCompetitionException | NoSuchTypeOfCompetitionException | NoSuchTypeOfStrategyException e) {
			fail();
		}
		assertEquals(League.class, this.competition.getClass());
	}

	/**
	 * Test the creation of a tournament by the factory
	 */
	@Test
	void testCreateTournament() {
		this.competition = null;
		try {
			this.competition = factory.createCompetition(TypeOfCompetition.Tournament.getLabel(), competitors, displayer);
		} catch (NullPointerException | CannotCreateCompetitionException | NoSuchTypeOfCompetitionException | NoSuchTypeOfStrategyException e) {
			fail();
		}
		assertEquals(Tournament.class, this.competition.getClass());
	}
	
	/**
	 * Test the creation of a master by the factory
	 */
	@Test
	void testCreateMaster() {
		this.competition = null;
		try {
			this.competition = factory.createCompetition(TypeOfCompetition.Master.getLabel(), competitors, 2, TypeOfStrategy.SelectionStrategyFirstOfEachGroup.getLabel(), displayer);
		} catch (NullPointerException | CannotCreateCompetitionException | NoSuchTypeOfCompetitionException | NoSuchTypeOfStrategyException e) {
			fail();
		}
		assertEquals(Master.class, this.competition.getClass());
	}
	
	/**
	 * Test if the factory correctly throws a NoSuchTypeOfCompetitionException when giving it a wrong string as a parameter
	 */
	@Test
	void testThrowsNoSuchTypeOfCompetitionException() {
		assertThrows(NoSuchTypeOfCompetitionException.class, () -> {
			factory.createCompetition("Unknown", competitors, displayer);
		});
		assertThrows(NoSuchTypeOfCompetitionException.class, () -> {
			factory.createCompetition("Unknown", competitors, 0, null, displayer);
		});
	}
}
