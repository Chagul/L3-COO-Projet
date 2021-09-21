package main.java.fr.ulille.l3.competitions;

import java.util.List;
import java.util.Map;

public abstract class Competition {
	private final List<Competitor> competitors;
	
	public Competition(List<Competitor> competitors) {
		this.competitors = competitors;
	}
	
	public void play() {
		
	}
	
	protected void play(List<Competitor> competitors) {
		
	}
	
	protected void playMatch(Competitor c1, Competitor c2) {
		
	}
	
	public Map<Competitor, Integer> ranking() {
		return null;
	}
}
