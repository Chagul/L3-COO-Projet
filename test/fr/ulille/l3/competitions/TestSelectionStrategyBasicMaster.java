package fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.modele.Leaderboard;
import fr.ulille.l3.util.TestDisplayer;

/**
 * Tests that concern a basic master strategy specifically 
 * @author Aurélien, Lucas
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
class TestSelectionStrategyBasicMaster {
	
	protected TestDisplayer displayer = TestDisplayer.getInstance(); 
	
	protected Competitor c1;
	protected Competitor c2;
	protected Competitor c3;
	protected Competitor c4;
	protected Competitor c5;
	protected Competitor c6;
	protected Competitor c7;
	protected Competitor c8;
	protected List<Competitor> competitorsInGroup1;
	protected List<Competitor> competitorsInGroup2;
	protected League group1;
	protected League group2;
	protected Leaderboard rankGroup1;
	protected Leaderboard rankGroup2;
	protected List<League> groups;
	protected List<Competitor> expectedSelectedCompetitors;
	protected List<Competitor> selectedCompetitors;
	
	/**
	 * Create two leagues of 4 competitors and fix scores to the competitors to artificially create a ranking, then use this ranking to create two lists of competitors :
	 * - expectedSelectedCompetitors the competitors that should be selected by the strategy 
	 * - selectedCompetitors the competitors that are actually selected by the strategy by the selection method
	 */
	@BeforeAll
	void init() {
		c1 = new Competitor("Aurélien");
		c2 = new Competitor("Lucas");
		c3 = new Competitor("Hugo");
		c4 = new Competitor("Antoine");
		c5 = new Competitor("Corentin");
		c6 = new Competitor("Ambre");
		c7 = new Competitor("Axel");
		c8 = new Competitor("Bastien");
		competitorsInGroup1 = new ArrayList<>();
		competitorsInGroup2 = new ArrayList<>();
		
		competitorsInGroup1.add(c1); competitorsInGroup1.add(c2); competitorsInGroup1.add(c3); competitorsInGroup1.add(c4);
		competitorsInGroup2.add(c5); competitorsInGroup2.add(c6); competitorsInGroup2.add(c7); competitorsInGroup2.add(c8);
	
		group1 = null;
		group2 = null;
		try {
			group1 = new League(competitorsInGroup1, displayer);
			group2 = new League(competitorsInGroup2, displayer);
		} catch (NullPointerException | CannotCreateCompetitionException e) {
			e.printStackTrace();
			fail();
		}
		
		rankGroup1 = group1.leaderboard;
		rankGroup2 = group2.leaderboard;
		rankGroup1.addScore(c1, 6); rankGroup1.addScore(c2, 4); rankGroup1.addScore(c3, 2); rankGroup1.addScore(c4, 0);
		rankGroup2.addScore(c5, 5); rankGroup2.addScore(c6, 3); rankGroup2.addScore(c7, 1); rankGroup2.addScore(c8, 0);
		
		groups = new ArrayList<>();
		groups.add(group1); groups.add(group2);
		
		expectedSelectedCompetitors = new ArrayList<>();
		expectedSelectedCompetitors.add(c1); expectedSelectedCompetitors.add(c2); expectedSelectedCompetitors.add(c5); 
		expectedSelectedCompetitors.add(c6); expectedSelectedCompetitors.add(c3); expectedSelectedCompetitors.add(c7);
		
		SelectionStrategy strategy = new SelectionStrategyBasicMaster();
		selectedCompetitors = strategy.selection(groups);
	}
	
	/**
	 * Test if the selection method actually selects the right number of competitors
	 */
	@Test
	void testNumberOfCompetitorsSelected() {
		assertEquals(expectedSelectedCompetitors.size(), selectedCompetitors.size());
	}

	/**
	 * Test if the selection method actually selects the right competitors
	 */
	@Test
	void testSelection() {
		assertArrayEquals(expectedSelectedCompetitors.toArray(), selectedCompetitors.toArray());
	}
	

}
