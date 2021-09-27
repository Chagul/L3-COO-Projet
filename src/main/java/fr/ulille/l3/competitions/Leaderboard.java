package main.java.fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import main.java.fr.ulille.l3.excpetions.EmptyCompetitorsListException;

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
		this.ranking.replace(aCompetitor, this.ranking.get(aCompetitor) + 1);
	}

	/**
	 * 
	 */
	public void showRanking() {
		sortRankingByScore();
		for (Map.Entry<Competitor,Integer> entryMap : ranking.entrySet()) {
			System.out.println(entryMap.getKey() + "-" + entryMap.getValue());
		}
	}

	/**
	 * 
	 */
	private void sortRankingByScore() {
		List<Map.Entry<Competitor, Integer>> listToBeSorted = new ArrayList<Map.Entry<Competitor, Integer>>(ranking.entrySet());
		Collections.sort(listToBeSorted, new Comparator<Map.Entry<Competitor, Integer>>() {

			@Override
			public int compare(Entry<Competitor, Integer> o1, Entry<Competitor, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		ranking = new HashMap<>(listToBeSorted.size());
		for(int indexList = 0; indexList < listToBeSorted.size(); indexList++) {
			ranking.put(listToBeSorted.get(indexList).getKey(),listToBeSorted.get(indexList).getValue());
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
