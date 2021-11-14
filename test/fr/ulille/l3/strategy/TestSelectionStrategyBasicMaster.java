package fr.ulille.l3.strategy;

/**
 * Tests that concern a basic master strategy specifically 
 * @author Aurélien, Lucas
 *
 */
class TestSelectionStrategyBasicMaster extends TestSelectionStrategy {
	
	/**
	 * Add to the list of the expected selected competitors the right competitors and gives a default master strategy
	 * @return SelectionStrategyBasicMaster strategy
	 */
	@Override
	protected SelectionStrategy createStrategy() {
		createExpectedSelectedCompetitors();
		return new SelectionStrategyBasicMaster();
	}

	/**
	 * Add the correct competitors that should be selected in the list
	 */
	protected void createExpectedSelectedCompetitors() {
		expectedSelectedCompetitors.add(c1); expectedSelectedCompetitors.add(c2); expectedSelectedCompetitors.add(c5); 
		expectedSelectedCompetitors.add(c6); expectedSelectedCompetitors.add(c3); expectedSelectedCompetitors.add(c7);
	}

}
