package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.Competitor;
import main.java.fr.ulille.l3.competitions.Leaderboard;
import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;

class TestLeaderboard {
	
	private Leaderboard leaderboard;
	private Competitor c1, c2, c3;
	List<Competitor> players;
	
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
	
	@Test
	void testInitWithEmptyCompetitorList() throws NullPointerException, EmptyCompetitorsListException {
		List<Competitor> emptyList = new ArrayList<Competitor>();
		assertThrows(EmptyCompetitorsListException.class, () -> {
			leaderboard = new Leaderboard(emptyList);
		});
	}
	
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
