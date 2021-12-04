package fr.ulille.l3.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.match.Match;
import fr.ulille.l3.util.CompetitionObserver;

public class TestBookmaker extends TestObservers {
	private final Double DEFAULT_ODDS = 1.0;
	private final Double MODIFIER = 0.1;

	
	protected Bookmaker createObserver() {
		return new Bookmaker(competitors, null);
	}
	
	/**
	 * Test if all the odds for the competitors are set to 1.0
	 */
	@Test
	public void testInitialisationCote() {
		HashMap<Competitor,Double> odds = (HashMap<Competitor, Double>) ((Bookmaker) this.observer).getCompetitorsAndTheirOdds();
		for(Entry<Competitor, Double> set : odds.entrySet()) {
			assertEquals(set.getValue(), DEFAULT_ODDS);
		}
	}
	
	/**
	 * Test if the loser has seen its odd changed by -0.1 and if the winner has seen its odd changed by +0.1
	 * @throws NullPointerException
	 * @throws CannotCreateCompetitionException
	 */
	@Test 
	public void testOddChangedAfterMatch() throws NullPointerException, CannotCreateCompetitionException {
		for(CompetitionObserver o : competition.getCompetitionObservers()) {
			if(o.getClass().equals(Bookmaker.class)) {
				this.observer = (Bookmaker) o;
			}
		}
		competition.play();
		HashMap<Competitor,Double> odds = (HashMap<Competitor, Double>) ((Bookmaker) this.observer).getCompetitorsAndTheirOdds();
		Match lastMatch = competition.getLastMatch();
		Competitor winner = lastMatch.getWinner();
		Competitor loser = lastMatch.getLoser();
		assertEquals(odds.get(winner),DEFAULT_ODDS+MODIFIER);
		assertEquals(odds.get(loser),DEFAULT_ODDS-MODIFIER);
	}
}
