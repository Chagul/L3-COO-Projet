package main.java.fr.ulille.l3.match;

import main.java.fr.ulille.l3.modele.Competitor;

/** Abstract class that assemble all the commons behavior between all the type of matches
 * @author Aurélien, Lucas
 */
public abstract class Match {
	/**

	 * @param firstCompetitor The first competitor to play the match
	 * @param secondComepetitor The second competitor to play the match

	 */
	protected Competitor firstCompetitor;
	protected Competitor secondCompetitor;

	public Match(Competitor c1, Competitor c2) {
		this.firstCompetitor = c1;
		this.secondCompetitor = c2;
	}

	public abstract Competitor play();
}
