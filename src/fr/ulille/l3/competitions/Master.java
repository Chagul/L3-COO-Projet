package fr.ulille.l3.competitions;

import java.util.List;

import fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import fr.ulille.l3.modele.Competitor;

public abstract class Master extends Competition{
	
protected SelectionStrategy selection; 

	public Master(List<Competitor> competitors) throws NullPointerException, EmptyCompetitorsListException {
		super(competitors);
		// TODO Auto-generated constructor stub
	}

}
