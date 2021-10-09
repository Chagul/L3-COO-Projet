package main.java.fr.ulille.l3.competitions;

import java.util.List;

import main.java.fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import main.java.fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import main.java.fr.ulille.l3.modele.Competitor;

public class CompetitionFactory {

	public Competition createCompetition(String typeCompetition, List<Competitor> listOfCompetitors) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException {
		if(typeCompetition.equals("League")){
			return new League(listOfCompetitors);
		}
		else if(typeCompetition.equals("Tournament")) {
			return new Tournament(listOfCompetitors);
		}
		
		throw new NoSuchTypeOfCompetitionException("There is no competition with that name");
	}

	
}
