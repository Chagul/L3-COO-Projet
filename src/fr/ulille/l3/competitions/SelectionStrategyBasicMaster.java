package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.MapUtil;

public class SelectionStrategyBasicMaster implements SelectionStrategy{

	private final int NUMBER_OF_COMPETITOR_SELECTED = 2;
	@Override
	public List<Competitor> selection(List<League> groupPhase) {
		List<Competitor> selectedCompetitors  = new ArrayList<>();
		List<Entry<Competitor,Integer>> temporaryCompetitors = new ArrayList<>();
		for(League l : groupPhase) {
			Map<Competitor,Integer> groupRank = l.getLeaderboard().getRanking();
			MapUtil.sortByDescendingValue(groupRank);
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
				return o1.getValue() - o2.getValue();
			}
		});
		
		selectedCompetitors.add(temporaryCompetitors.get(0).getKey());
		selectedCompetitors.add(temporaryCompetitors.get(1).getKey());
		
		return selectedCompetitors;
	}

}
