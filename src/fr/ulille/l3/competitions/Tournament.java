package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.List;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.DisplayerInterface;

/**
 * Tournament is a type of competition that need modulo 2 of competitor, each match has one loser and one winner, the loser will not compete in the next round.
 * @author Aurélien, Lucas
 *
 */
public class Tournament extends Competition {

	public Tournament(List<Competitor> competitors,DisplayerInterface displayer) throws NullPointerException, CannotCreateCompetitionException {
		super(competitors,displayer);
		checkIfPossible();
	}

	/**
	 * Check if the number of competitors in the list is a modulo 2. It is needed to check if a Tournament is possible
	 * @param numberOfCompetitor The list of competitors to be checked
	 * @throws CompetitorsNumberNotPowerOf2 Exception if modulo 2 is not respected
	 */
	private void checkModulo2(List<Competitor> competitors) throws CompetitorsNumberNotPowerOf2Exception {
		int numberOfCompetitor = competitors.size();
		while(numberOfCompetitor > 1) {
			if(numberOfCompetitor%2 != 0){
				throw new CompetitorsNumberNotPowerOf2Exception();
			}
			numberOfCompetitor = numberOfCompetitor/2;
		}
	}

	/**
	 * Play a match following the rules of a Tournament, two competitors goes against each other, the loser is eliminated and the winner will play against the others winners of the round.
	 * @param competitors The list of competitors that will compete in this tournament
	 */
	@Override
	protected void play(List<Competitor> competitors) {
		this.displayer.display("Tournament");
		List<Competitor> remainingCompetitors = new ArrayList<Competitor>(competitors);
		while(remainingCompetitors.size() > 1) {
			Competitor c1 = remainingCompetitors.get(0);
			Competitor c2 = remainingCompetitors.get(1);
			Competitor winner = playMatch(c1,c2);
			removeLooserFromCompetitors(remainingCompetitors, c1, c2, winner);
		}
	}

	/**
	 * Allow to remove the loser of the match from the list, the winner goes to next round and is put at the end of the list.
	 * @param remainingCompetitors The list with all the competitors still in the league
	 * @param c1 First competitor that played a match against c2
	 * @param c2 Second competitor that played a match against c1
	 * @param winner The winner between c1 and c2
	 */
	private void removeLooserFromCompetitors(List<Competitor> remainingCompetitors, Competitor c1, Competitor c2, Competitor winner) {
		if(winner.equals(c1)) {
			remainingCompetitors.remove(c2);
			if(remainingCompetitors.size() != 2) {
				remainingCompetitors.add(c1);
				remainingCompetitors.remove(0);
			}
		} 
		else {
			remainingCompetitors.remove(c1);
			if(remainingCompetitors.size() != 2) {
				remainingCompetitors.add(c2);
				remainingCompetitors.remove(0);
			}
		}
	}

	@Override
	protected void checkIfPossible() throws CannotCreateCompetitionException {
		this.checkModulo2(this.getCompetitors());
	}

	/**
	 * Send to the displayer the ranking of a tournament formated for printing
	 */
	@Override
	protected void showRanking() {
		this.displayer.display("\n*** RANKING TOURNAMENT ***");
		super.showRanking();
	}

}

