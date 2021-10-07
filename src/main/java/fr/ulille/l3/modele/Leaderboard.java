package main.java.fr.ulille.l3.modele;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.util.Displayer;
import main.java.fr.ulille.l3.util.MapUtil;

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

		this.ranking = new HashMap<>(competitors.size());
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
	 * Print the result of the competition, by descending value. Ranking will be sorted here.
	 */
	public void showRanking() {
		Displayer displayer = Displayer.getInstance();
		ranking = MapUtil.sortByDescendingValue(ranking);
		displayer.display("\n*** RANKING ***");
		for (Map.Entry<Competitor,Integer> entryMap : ranking.entrySet()) {
			displayer.display(entryMap.getKey().getName() + " --> " + entryMap.getValue());
		}
	}


	/**
	 * 
	 * @return The list of competitors with their score attached
	 */
	public Map<Competitor, Integer> getRanking() {
		return ranking;
	}
}
