package main.java.fr.ulille.l3.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.fr.ulille.l3.competitions.Competition;
import main.java.fr.ulille.l3.competitions.CompetitionFactory;
import main.java.fr.ulille.l3.exceptions.CompetitorsNumberNotPowerOf2Exception;
import main.java.fr.ulille.l3.exceptions.EmptyCompetitorsListException;
import main.java.fr.ulille.l3.exceptions.NoSuchTypeOfCompetitionException;
import main.java.fr.ulille.l3.modele.Competitor;
import main.java.fr.ulille.l3.util.Displayer;

public class Main {

	public static void main(String[] args) throws NullPointerException, EmptyCompetitorsListException, CompetitorsNumberNotPowerOf2Exception, NoSuchTypeOfCompetitionException {
		Displayer displayer = Displayer.getInstance();

		displayer.display("Entrez votre nombre de compétiteurs");
		Scanner sc = new Scanner(System.in);
		int nbOfCompetitors = 0;
		try {
			nbOfCompetitors = Integer.parseInt(sc.next());
		}catch (NumberFormatException exception) {
			System.exit(1);
		}
		List<Competitor> competitors = new ArrayList<>();
		for(int i = 0; i < nbOfCompetitors; i++) {
			displayer.display("Entre le nom du competiteur");
			competitors.add(new Competitor(sc.next()));
			displayer.display("Competiteur ajouté !");
		}
		displayer.display("Veuillez entrer votre type de competition parmis");
		displayer.display("League ou Tournament");
		sc.close();
		CompetitionFactory factory = new CompetitionFactory();
		Competition competition = factory.createCompetition(sc.next(),competitors);
//		try {
//			league = new Tournament(competitors);
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//		} catch (EmptyCompetitorsListException e) {
//			e.printStackTrace();
//		} catch (CompetitorsNumberNotPowerOf2Exception e) {
//			e.printStackTrace();
//		}

		competition.play();
		competition.ranking();
	}
}
