package main.java.fr.ulille.l3.competitions;

import java.util.Random;

public class BasicMatch extends Match {

	public BasicMatch(Competitor c1, Competitor c2) {
		super(c1,c2);
	}
	
	@Override
	public Competitor play() {
		Random rng = new Random();
		int randomWinner = rng.nextInt(2);
		return randomWinner == 0 ? this.firstCompetitor : this.secondCompetitor;
	}

}
