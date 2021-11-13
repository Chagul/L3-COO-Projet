package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.InvalidNumberOfGroupException;
import fr.ulille.l3.modele.Competitor;

/**
 * Tests that concern a Master specifically 
 * @author Aurélien, Lucas
 *
 */
class TestMaster extends TestCompetition {
	
	protected Competitor c6;
	protected Competitor c7;
	protected Competitor c8;
	protected Competitor c9;
	protected SelectionStrategy strategy = new SelectionStrategyBasicMaster();
	protected final int NB_MATCHES_IN_FINALSTAGE = 7;
	protected final int NB_GROUPS_IN_MASTER = 3;

	/**
	 * Create a Master with 9 competitors at the start, 3 groups with the default strategy.
	 * @throws CannotCreateCompetitionException 
	 * @throws NullPointerException 
	 */
	@Override
	protected Competition createCompetition() throws NullPointerException, CannotCreateCompetitionException {
		c6 = new Competitor("Ambre");
		c7 = new Competitor("Axel");
		c8 = new Competitor("Bastien");
		c9 = new Competitor("Anaïs");
		
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		this.competitors.add(c5);
		this.competitors.add(c6);
		this.competitors.add(c7);
		this.competitors.add(c8);
		this.competitors.add(c9);
		return new Master(this.competitors, strategy, NB_GROUPS_IN_MASTER, displayer);
	}
	
	/**
	 * Calculate how many matches should be played in the entire master. (groups and final stage)
	 * @param competitors The list of competitors at the beginning of the tournament
	 * @return The number of matches expected with the given list
	 */
	@Override
	protected int howManyMatchesExpected(List<Competitor> competitors) {
		int expectedMatches = 0;
		Master m = (Master) this.competition;
		for(League l : m.groups) {
			for(int i = 0; i < l.getNbCompetitors(); i++) {
				expectedMatches += (l.getNbCompetitors()-1)-i;
			}
		}
		expectedMatches = expectedMatches * 2;
		expectedMatches += NB_MATCHES_IN_FINALSTAGE;
		return expectedMatches;
	}
	
	/**
	 * Test if the right number of group has been created.
	 */
	@Test
	public void testRightNumberOfGroups() {
		Master m = (Master) this.competition;
		assertEquals(NB_GROUPS_IN_MASTER, m.groups.size());
	}
	
	/**
	 * Test if there is the right number of competitors in the final stage of the master. This number depends on the strategy applied.
	 */
	@Test
	public void testRightNumberOfCompetitorsInFinalStage() {
		Master m = (Master) this.competition;
		m.play();
		int expectedNbCompetitors = this.strategy.numberOfCompetitorsSelected(m.groups);
		assertEquals(m.finalStage.getNbCompetitors(), expectedNbCompetitors);
	}
	
	/**
	 * Test if the invalid number of group exception is raised when creating a master with an impossible number of groups.
	 */
	@Test
	public void testThrowsInvalidNumberOfGroupException() {
		assertThrows(InvalidNumberOfGroupException.class, () -> {
			new Master(this.competitors, strategy, 2, displayer);
		});
	}

	

}
