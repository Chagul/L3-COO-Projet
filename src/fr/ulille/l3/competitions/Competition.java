package fr.ulille.l3.competitions;

import java.util.List;
import java.util.Map;

import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.NoSuchTypeOfMatchException;
import fr.ulille.l3.match.Match;
import fr.ulille.l3.match.MatchFactory;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.modele.Leaderboard;
import fr.ulille.l3.util.DisplayerInterface;
import fr.ulille.l3.util.MapUtil;

/**
 * Abstract class that assemble all the commons behavior between all the competition
 * @author Aurélien,Lucas
 *
 */
public abstract class Competition {
	
	private final List<Competitor> competitors;
	protected Leaderboard leaderboard;
	protected int matchesPlayed;
	private MatchFactory matchFactory;
	protected DisplayerInterface displayer;
	

	public Competition(List<Competitor> competitors,DisplayerInterface displayer) throws NullPointerException, EmptyCompetitorsListException {
		this.competitors = competitors;
		this.leaderboard = new Leaderboard(competitors);
		this.matchesPlayed = 0;
		this.matchFactory = new MatchFactory();
		this.displayer = displayer;
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
		Match matchToPlay = createMatch(c1, c2);
		Competitor winner = matchToPlay.play();
		incrementScoreOfWinnner(winner);
		incrementMatchesPlayed();
		this.displayer.display(c1 + " vs " + c2 + " --> Winner : " + winner);
		return winner;
	}

	private Match createMatch(Competitor c1, Competitor c2) {
		Match matchToPlay = null;
		try {
			matchToPlay = this.matchFactory.createMatch("BasicMatch", c1,c2);
		} catch (NoSuchTypeOfMatchException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return matchToPlay;
	}
	
	protected void incrementMatchesPlayed() {
		this.matchesPlayed++;
	}
	
	protected void incrementScoreOfWinnner(Competitor winner) {
		this.leaderboard.incrScore(winner);
	}

	/**
	 * 
	 * @return The number of matches played so far
	 */
	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	/**
	 * Display the leaderboard with all the results
	 */
	public Map<Competitor,Integer> ranking() {
		return leaderboard.getRanking();
	}
	
	protected Leaderboard getLeaderboard() {
		return this.leaderboard;
	}
	
	protected void showRanking() {
		Map<Competitor,Integer> ranks = this.ranking();
		ranks = MapUtil.sortByDescendingValue(ranks);
		this.displayer.display("\n*** RANKING ***");
		for (Map.Entry<Competitor,Integer> entryMap : ranks.entrySet()) {
			displayer.display("Player " + entryMap.getKey().getName() + " --> Score " + entryMap.getValue());
		}
	}
	
	public List<Competitor> getCompetitors() {
		return competitors;
	}
	
	public int getNbCompetitors() {
		return this.competitors.size();
	}
}
