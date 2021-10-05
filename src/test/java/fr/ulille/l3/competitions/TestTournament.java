package test.java.fr.ulille.l3.competitions;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.Tournament;

public class TestTournament extends TestCompetition {

	@Override
	protected Competition createCompetition() throws Exception {
		return new Tournament(this.competitors);
	}
}
