	package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.DisplayerInterface;

/**
 * League is a type of competition with the rule that every competitor must play against others competitors at least twice
 * @author Aurélien, Lucas
 *
 */
public class League extends Competition {

	public League(List<Competitor> competitors,DisplayerInterface displayer) throws NullPointerException, CannotCreateCompetitionException {
		super(competitors,displayer);
		checkIfPossible();
	}
	
	/**
	 * Play all the match in the league with the following rule : every competitor must play against the others 2 times
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		displayer.display("League");
		for(int indexCompetitor1 = 0; indexCompetitor1 < competitors.size(); indexCompetitor1++) {
			for(int indexCompetitor2 = 1+indexCompetitor1; indexCompetitor2 < competitors.size(); indexCompetitor2++) {
				playMatch(competitors.get(indexCompetitor1), competitors.get(indexCompetitor2));
				playMatch(competitors.get(indexCompetitor2), competitors.get(indexCompetitor1));
			}
		}
		
		
	}

	@Override
	protected void checkIfPossible() throws CannotCreateCompetitionException{
		//Nothing to check
	}

	/**
	 * Send to the displayer the ranking of a league formated for printing
	 */
	@Override
	protected void showRanking() {
		this.displayer.display("\n*** RANKING LEAGUE ***");
		super.showRanking();
	}
}
