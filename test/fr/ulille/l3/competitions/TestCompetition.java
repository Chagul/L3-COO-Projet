package fr.ulille.l3.competitions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.TestDisplayer;

/**
 * Abstract class that assemble all the commons behaviour between the tests of Competition type classes
 * @author Aurélien,Lucas
 *
 */
public abstract class TestCompetition {

	protected List<Competitor> competitors = new ArrayList<Competitor>();
	protected Competition competition;
	protected Competitor c1;
	protected Competitor c2;
	protected Competitor c3;
	protected Competitor c4;
	protected Competitor c5;
	protected Competitor c6;
	protected TestDisplayer displayer = TestDisplayer.getInstance();

	/**
	 * Init a competition with 5 competitors
	 */
	@BeforeEach
	public void init() {
		c1 = new Competitor("Aurélien");
		c2 = new Competitor("Lucas");
		c3 = new Competitor("Hugo");
		c4 = new Competitor("Antoine");
		c5 = new Competitor("Corentin");
		try {
			this.competition = this.createCompetition();
		}
		catch (Exception e) {
			fail();
		}
	}

	protected abstract Competition createCompetition() throws CannotCreateCompetitionException;
	protected abstract int howManyMatchesExpected(List<Competitor> competitors);

	/**
	 * Test if the null pointer exception is raised when a null list is used to create a Competition type.
	 */
	@Test
	public void testNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new League(null,displayer);
		});
		assertThrows(NullPointerException.class, () -> {
			new Tournament(null,displayer);
		});
		assertThrows(NullPointerException.class, () -> {
			new Master(null, null, 0,displayer);
		});
	}

	/**
	 * Test if the empty list exception is raised when an empty list is used to create a Competition type.
	 */
	@Test
	public void testEmptyListOfCompetitors() {
		assertThrows(EmptyCompetitorsListException.class, () -> {
			new League(new ArrayList<Competitor>(),displayer);
		});
		assertThrows(EmptyCompetitorsListException.class, () -> {
			new Tournament(new ArrayList<Competitor>(),displayer);
		});
		assertThrows(EmptyCompetitorsListException.class, () -> {
			new Master(new ArrayList<Competitor>(), null, 0,displayer);
		});
	}
	
	/**
	 * Test if all the matches are played.
	 * @throws InvalidNumberOfGroupException 
	 * @throws NoSuchTypeOfCompetitionException 
	 */
	@Test
	public void testRightCountOfMatches() throws NoSuchTypeOfCompetitionException, InvalidNumberOfGroupException {
		this.competition.play();
		int matchesPlayed = this.competition.getMatchesPlayed();
		int expectedNumberOfMatches = howManyMatchesExpected(competitors);
		assertEquals(expectedNumberOfMatches, matchesPlayed);
	}
}
