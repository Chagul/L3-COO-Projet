package fr.ulille.l3.strategy;

/**
 * Test that concern a first of each group strategy specifically 
 * @author Aurélien, Lucas
 *
 */
public class TestSelectionStrategyFirstOfEachGroup extends TestSelectionStrategy {

	/**
	 * Add to the list of the expected selected competitors the right competitors and gives a first of each group strategy
	 * @return SelectionStrategyFirstOfEachGroup strategy
	 */
	@Override
	protected SelectionStrategy createStrategy() {
		createExpectedSelectedCompetitors();
		return new SelectionStrategyFirstOfEachGroup();
	}
	
	/**
	 * Add the correct competitors that should be selected in the list
	 */
	protected void createExpectedSelectedCompetitors() {
		expectedSelectedCompetitors.add(c1); expectedSelectedCompetitors.add(c5);
	}

}
