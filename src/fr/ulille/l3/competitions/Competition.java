package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.ulille.l3.exceptions.CannotCreateCompetitionException;
import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.exceptions.NoSuchTypeOfMatchException;
import fr.ulille.l3.match.Match;
import fr.ulille.l3.match.MatchFactory;
import fr.ulille.l3.match.TypeOfMatch;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.modele.Leaderboard;
import fr.ulille.l3.util.DisplayerInterface;
import fr.ulille.l3.util.MapUtil;
import fr.ulille.l3.util.SpecialObservable;

/**
 * Abstract class that assemble all the commons behavior between all the competition
 * @author Aurélien,Lucas
 *
 */
public abstract class Competition extends SpecialObservable{
	
	private final List<Competitor> competitors;
	protected Leaderboard leaderboard;
	protected int matchesPlayed;
	private MatchFactory matchFactory;
	protected DisplayerInterface displayer;
	protected Match lastMatch;

	public Competition(List<Competitor> competitors,DisplayerInterface displayer) throws NullPointerException, EmptyCompetitorsListException {
		this.competitors = competitors;
		this.leaderboard = new Leaderboard(competitors);
		this.matchesPlayed = 0;
		this.matchFactory = new MatchFactory();
		this.displayer = displayer;
		this.lastMatch = null;
		this.competitionObservers = new ArrayList<>();
	}

	/**
	 * Checks the parameters to know if the competition can be correctly created or not.
	 * @throws CannotCreateCompetitionException If the competition can't be created
	 */
	protected abstract void checkIfPossible() throws CannotCreateCompetitionException;
	protected abstract void play(List<Competitor> competitors);
	
	public void play() {
		this.play(competitors);
		this.showRanking();
	}

	/**
	 * Default behaviour of a Match, winner is chosen randomly at this point
	 * @param c1 First competitor of the match
	 * @param c2 Second competitor of the match
	 * @return The winner of the match
	 */
	public Competitor playMatch(Competitor c1, Competitor c2) {
		Match matchToPlay = createMatch(c1, c2);
		this.lastMatch = matchToPlay;
		matchToPlay.play();
		Competitor winner = matchToPlay.getWinner();
		incrementScoreOfWinnner(winner);
		incrementMatchesPlayed();
		this.displayer.display("\n" + c1 + "vs " + c2 + "--> Winner : " + winner + "\n");
		this.somethingHappened();
		return winner;
	}

	/**
	 * Create a basicmatch by default with the given competitor
	 * @param c1 The first competitor in the match 
	 * @param c2 The second competitor in the match
	 * @return The match created
	 */
	private Match createMatch(Competitor c1, Competitor c2) {
		Match matchToPlay = null;
		try {
			matchToPlay = this.matchFactory.createMatch(TypeOfMatch.BasicMatch.getLabel(), c1,c2);
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
	 * Display the leaderboard with all the results ordered
	 * @return The map containing the ranking
	 */
	public Map<Competitor,Integer> ranking() {
		Map<Competitor,Integer> ranks = leaderboard.getRanking();
		ranks = MapUtil.sortByDescendingValue(ranks);
		return ranks;
	}
	
	public Leaderboard getLeaderboard() {
		return this.leaderboard;
	}
	
	/**
	 * Send to the displayer the ranking formated for printing
	 */
	protected void showRanking() {
		Map<Competitor,Integer> ranks = this.ranking();
		for (Map.Entry<Competitor,Integer> entryMap : ranks.entrySet()) {
			displayer.display("Player " + entryMap.getKey().getName() + " --> won " + entryMap.getValue() + " matches");
		}
	}
	
	/**
	 * 
	 * @return The last match played
	 */
	public Match getLastMatch() {
		return this.lastMatch;
	}
	
	public List<Competitor> getCompetitors() {
		return competitors;
	}
	
	public int getNbCompetitors() {
		return this.competitors.size();
	}
}
