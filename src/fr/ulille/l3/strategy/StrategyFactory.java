package fr.ulille.l3.strategy;

import fr.ulille.l3.exceptions.NoSuchTypeOfStrategyException;

/**
 * Class implementing the factory method pattern. Use it to create any type of strategy.
 * @author Aurélien, Lucas
 *
 */
public class StrategyFactory {

	private static StrategyFactory factory;
	/**
	 * Create a strategy with the chosen one
	 * @param typeStrategy The strategy name
	 * @return The strategy created
	 * @throws NoSuchTypeOfStrategyException Thrown if the given name does not correspond to any strategy known
	 */
	public SelectionStrategy createStrategy(String typeStrategy) throws NoSuchTypeOfStrategyException {
		if(typeStrategy.toLowerCase().equals(TypeOfStrategy.SelectionStrategyBasicMaster.getLabel())){
			return new SelectionStrategyBasicMaster();
		}
		else if(typeStrategy.toLowerCase().equals(TypeOfStrategy.SelectionStrategyFirstOfEachGroup.getLabel())) {
			return new SelectionStrategyFirstOfEachGroup();
		}

		throw new NoSuchTypeOfStrategyException("There is no strategy with that name");
	}

	/**
	 * Singleton of the class, it is to be sure that only one instance of the factory exists.
	 * @return Instance of the factory
	 */
	public static StrategyFactory getInstance() {
		if(factory == null) {
			factory = new StrategyFactory();
		}
		return factory;
	}

}
