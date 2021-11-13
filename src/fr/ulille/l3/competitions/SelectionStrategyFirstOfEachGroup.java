package fr.ulille.l3.competitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.ulille.l3.modele.Competitor;
import fr.ulille.l3.util.MapUtil;


/**
 * Type of selection for master. Here the rule is to keep the first one of each group.
 * @author Aurélien,Lucas
 *
 */
public class SelectionStrategyFirstOfEachGroup implements SelectionStrategy{
		
		/**
		 * 
		 * @return List<Competitor> the list of competitors that will access the final phase.
		 */
		@Override
		public List<Competitor> selection(List<League> groupPhase) {
			List<Competitor> selectedCompetitors  = new ArrayList<>();
			for(League l : groupPhase) {
				Map<Competitor,Integer> groupRank = l.getLeaderboard().getRanking();
				groupRank = MapUtil.sortByDescendingValue(groupRank);
				selectedCompetitors.add(groupRank.entrySet().iterator().next().getKey());
				}
				
			return selectedCompetitors;
		}

		/**
		 * Method to control the number of competitors selected for the final phase with this strategy, here we pick the first of each league so the numbers of selected competitors is equal to the number of group
		 */
		@Override
		public int numberOfCompetitorsSelected(List<League> groupPhase) {
			return groupPhase.size();
		}

	}


