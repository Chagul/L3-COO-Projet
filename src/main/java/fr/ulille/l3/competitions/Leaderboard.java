package main.java.fr.ulille.l3.competitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.util.MapUtil;

public class Leaderboard {

	private Map<Competitor,Integer> ranking;  

	/**
	 * 
	 * @param competitors
	 * @throws NullPointerException
	 * @throws EmptyCompetitorsListException
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
	 * 
	 * @param aCompetitor
	 */
	public void incrScore(Competitor aCompetitor) {
		this.ranking.put(aCompetitor, this.ranking.get(aCompetitor) + 1);
	}

	/**
	 * 
	 */
	public void showRanking() {
		ranking = MapUtil.sortByDescendingValue(ranking);
		for (Map.Entry<Competitor,Integer> entryMap : ranking.entrySet()) {
			System.out.println(entryMap.getKey().getName() + "->" + entryMap.getValue());
		}
	}


	/**
	 * 
	 * @return
	 */
	public Map<Competitor, Integer> getRanking() {
		return ranking;
	}
}
