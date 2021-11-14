package fr.ulille.l3.strategy;

import java.util.List;

import fr.ulille.l3.competitions.League;
import fr.ulille.l3.modele.Competitor;

/**
 * Interface that permit to create different strategies for master
 * @author Aurélien, Lucas
 *
 */
public interface SelectionStrategy {
	
	public int numberOfCompetitorsSelected(List<League> groupPhase);
	public List<Competitor> selection(List<League> groupPhase);
}
