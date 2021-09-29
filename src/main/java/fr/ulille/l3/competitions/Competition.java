package main.java.fr.ulille.l3.competitions;

import java.util.List;
import java.util.Map;

import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;

public abstract class Competition {
	private final List<Competitor> competitors;
	protected Leaderboard leaderboard;


	public Competition(List<Competitor> competitors) throws NullPointerException, EmptyCompetitorsListException {
		this.competitors = competitors;
		this.leaderboard = new Leaderboard(competitors);
	}

	public void play() {
		this.play(competitors);
	}

	protected abstract void play(List<Competitor> competitors);

	protected void playMatch(Competitor c1, Competitor c2) {
		Competitor winner = new BasicMatch(c1,c2).play();
		leaderboard.incrScore(winner);
		System.out.println(c1.getName() + "vs" + c2.getName() + "--> Winner : " + winner.getName());
	}

	public void ranking() {
		leaderboard.showRanking();
	}
}
