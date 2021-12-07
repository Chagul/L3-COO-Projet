package fr.ulille.l3.util;

import fr.ulille.l3.competitions.Competition;

/**
 * Interface that will be implemented in all observer of a competition
 * @author Aurélien,Lucas
 */
public interface CompetitionObserver {

	public void update();
	
	public void changeCompetition(Competition compet);
}
