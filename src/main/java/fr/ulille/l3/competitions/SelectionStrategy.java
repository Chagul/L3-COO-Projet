package main.java.fr.ulille.l3.competitions;

import java.util.List;

import main.java.fr.ulille.l3.modele.Competitor;

interface SelectionStrategy {

	List<Competitor> selection(List<League> groupPhase);
}
