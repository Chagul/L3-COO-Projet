package fr.ulille.l3.match;

import fr.ulille.l3.modele.Competitor;

/** Abstract class that assemble all the commons behavior between all the type of matches
 * @author Aurélien, Lucas
 */
public abstract class Match {

	protected Competitor firstCompetitor;
	protected Competitor secondCompetitor;
	protected Competitor winner;
	protected Competitor loser;
	
	public Match(Competitor c1, Competitor c2) {
		this.firstCompetitor = c1;
		this.secondCompetitor = c2;
		this.winner = null;
		this.loser = null;
	}

	public abstract void play();
	
	public Competitor getWinner() {
		return this.winner;
	}
	
	public Competitor getLoser() {
		return this.loser;
	}
}
