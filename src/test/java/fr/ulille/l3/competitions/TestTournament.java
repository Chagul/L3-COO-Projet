package test.java.fr.ulille.l3.competitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.Tournament;
import main.java.fr.ulille.l3.excpetions.CompetitorsNumberNotPowerOf2Exception;
import main.java.fr.ulille.l3.modele.Competitor;

public class TestTournament extends TestCompetition {

	@Override
	protected Competition createCompetition() throws Exception {
		this.competitors.add(c1);
		this.competitors.add(c2);
		this.competitors.add(c3);
		this.competitors.add(c4);
		
		return new Tournament(this.competitors);
	}
	
	@Test
	public void testCompetitorsNotPowerOf2Exception() {
		List<Competitor> competitorsNotPowerOf2 = new ArrayList<>();
		competitorsNotPowerOf2.add(c1);
		competitorsNotPowerOf2.add(c2);
		competitorsNotPowerOf2.add(c3);
		assertThrows(CompetitorsNumberNotPowerOf2Exception.class, () -> {
			new Tournament(competitorsNotPowerOf2);
		});
	}
	
	@Test
	public void testRightCountOfMatch() {
		this.competition.play();
		int matchesPlayed = this.competition.getMatchesPlayed();
		int expectedNumberOfMatches = howManyMatchesExpected(competitors);
		assertEquals(expectedNumberOfMatches, matchesPlayed);
	}
	
	private int howManyMatchesExpected(List<Competitor> competitors) {
		return competitors.size()-1;
	}
	
}
