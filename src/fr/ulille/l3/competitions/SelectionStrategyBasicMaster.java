package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.MapUtil;

public class SelectionStrategyBasicMaster implements SelectionStrategy{

	private final int NUMBER_OF_COMPETITOR_SELECTED = 2;
	@Override
	public List<Competitor> selection(List<League> groupPhase) {
		List<Competitor> selectedCompetitors  = new ArrayList<>();
		for(League l : groupPhase) {
			Map<Competitor,Integer> groupRank = l.getLeaderboard().getRanking();
			MapUtil.sortByDescendingValue(groupRank);
			Set<Map.Entry<Competitor,Integer>> entryMap = groupRank.entrySet();
			
		}
		return selectedCompetitors;
	}

}
