package fr.ulille.l3.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.ulille.l3.competitions.League;
import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.MapUtil;

/**
 * Basic strategy for a master, the 2 at the top of the leaderboard of each first phases and select the 2 best third of all first phases
 * @author Aurélien, Lucas
 *
 */
public class SelectionStrategyBasicMaster implements SelectionStrategy{

	private final int NUMBER_OF_COMPETITOR_SELECTED = 2;
	
	/**
	 * 
	 * @return The list of competitors that will access the final phase.
	 */
	@Override
	public List<Competitor> selection(List<League> groupPhase) {
		List<Competitor> selectedCompetitors  = new ArrayList<>();
		List<Entry<Competitor,Integer>> temporaryCompetitors = new ArrayList<>();
		for(League l : groupPhase) {
			Map<Competitor,Integer> groupRank = l.getLeaderboard().getRanking();
			groupRank = MapUtil.sortByDescendingValue(groupRank);
			int indexMap = 0;
			for(Entry<Competitor, Integer> entry : groupRank.entrySet()) {
				Competitor currentCompetitor = entry.getKey();
				if(indexMap < NUMBER_OF_COMPETITOR_SELECTED) {
					selectedCompetitors.add(currentCompetitor);
				}else{
					temporaryCompetitors.add(entry);
				}
				indexMap++;
			}
			
		}
		Collections.sort(temporaryCompetitors, new Comparator<Entry<Competitor,Integer>>() {

			@Override
			public int compare(Entry<Competitor, Integer> o1, Entry<Competitor, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		selectedCompetitors.add(temporaryCompetitors.get(0).getKey());
		selectedCompetitors.add(temporaryCompetitors.get(1).getKey());
		
		return selectedCompetitors;
	}

	/**
	 * Method to control the number of competitors selected for the final phase with this strategy, here we pick the first two of each league and the 2 best third overall so it's 2*nbOfGroup + 2
	 */
	@Override
	public int numberOfCompetitorsSelected(List<League> groupPhase) {
		return groupPhase.size()*2 + 2;
	}

}
