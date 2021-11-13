package fr.ulille.l3.match;

import fr.ulille.l3.modele.Competitor;

/** Abstract class that assemble all the commons behavior between all the type of matches
 * @author Aurélien, Lucas
 */
public abstract class Match {

	protected Competitor firstCompetitor;
	protected Competitor secondCompetitor;

	public Match(Competitor c1, Competitor c2) {
		this.firstCompetitor = c1;
		this.secondCompetitor = c2;
	}

	public abstract Competitor play();
}
