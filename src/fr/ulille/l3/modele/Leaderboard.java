package fr.ulille.l3.modele;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fr.ulille.l3.exceptions.EmptyCompetitorsListException;

/**
 * Centralize all the informations about the ranking, competitors, their wins and their score.
 * @author Aurélien, Lucas
 *
 */
public class Leaderboard {
	
	private Map<Competitor,Integer> ranking;  

	/**
	 * 
	 * @param competitors The competitors present in the competitions played
	 * @throws NullPointerException Thrown if the competitor list point to an NULL referenced array
	 * @throws EmptyCompetitorsListException Thrown if the competitor list is empty
	 */
	public Leaderboard(List<Competitor> competitors) throws NullPointerException, EmptyCompetitorsListException {
		if(competitors.isEmpty()) {
			throw new EmptyCompetitorsListException();
		}

		this.ranking = new LinkedHashMap<>(competitors.size());
		for(Competitor c : competitors) {
			ranking.put(c, 0);
		}

	}

	/**
	 * Increment the score of a competitor
	 * @param aCompetitor The competitor that will get a point
	 */
	public void incrScore(Competitor aCompetitor) {
		this.ranking.put(aCompetitor, this.ranking.get(aCompetitor) + 1);
	}

	/**
	 * Increment the score of a competitor by the value given in parameter
	 * @param aCompetitor The competitor that will get a point
	 * @param scoreToAdd The value that has to be added to the actual score of the competitor
	 */
	public void addScore(Competitor aCompetitor, int scoreToAdd) {
		this.ranking.put(aCompetitor, this.ranking.get(aCompetitor) + scoreToAdd);
	}

	/**
	 * 
	 * @return The list of competitors with their score attached
	 */
	public Map<Competitor, Integer> getRanking() {
		return ranking;
	}
}
