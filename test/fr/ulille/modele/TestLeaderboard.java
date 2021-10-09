package fr.ulille.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.modele.Competitor;
import main.java.fr.ulille.l3.modele.Leaderboard;

/**
 * Tests that concern the leaderboard specifically 
 * @author Aurélien, Lucas
 *
 */
public class TestLeaderboard {
	
	private Leaderboard leaderboard;
	private Competitor c1, c2, c3;
	List<Competitor> players;
	
	
	/**
	 * Init a new leaderboard with 3 players that have 0 points each
	 */
	@BeforeEach
	void init() {
		c1 = new Competitor("Lucas");
		c2 = new Competitor("Aurélien");
		c3 = new Competitor("Hugo");
		players = new ArrayList<>();
		players.add(c1); players.add(c2); players.add(c3);
		try {
			leaderboard = new Leaderboard(players);
		} catch (NullPointerException | EmptyCompetitorsListException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test if the leaderboard set point to 0 for everybody in the players
	 */
	@Test
	void testInit() {
		boolean valuesToZero = true;
		Map<Competitor, Integer> ranks = leaderboard.getRanking();
		ArrayList<Integer> scores = new ArrayList<>(ranks.values());
		int i = 0;
		while(i < scores.size() && valuesToZero) {
			if(scores.get(i) != 0) {
				valuesToZero = false;
			}
			i++;
		}
		assertEquals(true, valuesToZero);
	}
	
	/**
	 * Test if exceptions are thrown when we give and empty competitor list to create the leaderboard
	 * @throws NullPointerException 
	 * @throws EmptyCompetitorsListException 
	 */
	@Test
	void testInitWithEmptyCompetitorList() throws NullPointerException, EmptyCompetitorsListException {
		List<Competitor> emptyList = new ArrayList<Competitor>();
		assertThrows(EmptyCompetitorsListException.class, () -> {
			leaderboard = new Leaderboard(emptyList);
		});
	}
	
	/**
	 * Test if the scores are incremented when incrScore is called
	 */
	@Test
	void testIncrScore() {
		leaderboard.incrScore(c3);
		leaderboard.incrScore(c3);
		leaderboard.incrScore(c2);
		Map<Competitor, Integer> ranks = leaderboard.getRanking();
		assertEquals(0, ranks.get(c1));
		assertEquals(1, ranks.get(c2));
		assertEquals(2, ranks.get(c3));
		leaderboard.showRanking();
	}
	
	

}
