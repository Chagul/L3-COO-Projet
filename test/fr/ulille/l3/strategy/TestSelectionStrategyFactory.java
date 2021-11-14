package fr.ulille.l3.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import fr.ulille.l3.exceptions.NoSuchTypeOfStrategyException;

/**
 * Tests for the strategy factory
 * @author Aurélien, Lucas
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
class TestSelectionStrategyFactory {
	
	protected StrategyFactory factory;

	/**
	 * Instantiate a strategy factory
	 */
	@BeforeAll
	public void init() {
		factory = StrategyFactory.getInstance();
	}
	
	/**
	 * Test the creation of a selection strategy basic master by the factory
	 */
	@Test
	void testCreateSelectionStrategyBasicMaster() {
		try {
			assertEquals(SelectionStrategyBasicMaster.class, factory.createStrategy(TypeOfStrategy.SelectionStrategyBasicMaster.getLabel()).getClass());
		} catch (NoSuchTypeOfStrategyException e) {
			fail();
		}
	}

	/**
	 * Test the creation of a selection strategy first of each group by the factory
	 */
	@Test
	void testCreateSelectionStrategyFirstOfEachGroup() {
		try {
			assertEquals(SelectionStrategyFirstOfEachGroup.class, factory.createStrategy(TypeOfStrategy.SelectionStrategyFirstOfEachGroup.getLabel()).getClass());
		} catch (NoSuchTypeOfStrategyException e) {
			fail();
		}
	}
	
	/**
	 * Test if the factory correctly throws a NoSuchTypeOfStrategyException when giving it a wrong string as a parameter
	 */
	@Test
	void testThrowsNoSuchTypeOfStrategyException() {
		assertThrows(NoSuchTypeOfStrategyException.class, () -> {
			factory.createStrategy("Unknown");
		});
	}
}
