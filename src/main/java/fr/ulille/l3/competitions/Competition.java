package main.java.fr.ulille.l3.competitions;

import java.util.List;

import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.match.BasicMatch;
import main.java.fr.ulille.l3.modele.Competitor;
import main.java.fr.ulille.l3.modele.Leaderboard;

public abstract class Competition {
	
	private final List<Competitor> competitors;
	protected Leaderboard leaderboard;
	protected int matchesPlayed;


	public Competition(List<Competitor> competitors) throws NullPointerException, EmptyCompetitorsListException {
		this.competitors = competitors;
		this.leaderboard = new Leaderboard(competitors);
		this.matchesPlayed = 0;
	}

	public void play() {
		this.play(competitors);
	}

	protected abstract void play(List<Competitor> competitors);

	/**
	 * Default behaviour of a Match, winner is chosen randomly at this point
	 * @param c1 First competitor of the match
	 * @param c2 Second competitor of the match
	 * @return The winner of the match
	 */
	protected Competitor playMatch(Competitor c1, Competitor c2) {
		Competitor winner = new BasicMatch(c1,c2).play();
		leaderboard.incrScore(winner);
		this.matchesPlayed++;
		System.out.println(c1.getName() + "vs" + c2.getName() + "--> Winner : " + winner.getName());
		return winner;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void ranking() {
		leaderboard.showRanking();
	}
}
