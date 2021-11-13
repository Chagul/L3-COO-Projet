package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.modele.Competitor;

/**
 * Interface that permit to create different strategies for master
 * @author Aurélien, Lucas
 *
 */
interface SelectionStrategy {
	
	public int numberOfCompetitorsSelected(List<League> groupPhase);
	public List<Competitor> selection(List<League> groupPhase);
}
