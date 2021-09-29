package main.java.fr.ulille.l3.match;

import main.java.fr.ulille.l3.modele.Competitor;

public abstract class Match {

	protected Competitor firstCompetitor;
	protected Competitor secondCompetitor;

	public Match(Competitor c1, Competitor c2) {
		this.firstCompetitor = c1;
		this.secondCompetitor = c2;
	}

	public abstract Competitor play();
}
