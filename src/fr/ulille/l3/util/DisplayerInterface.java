package fr.ulille.l3.util;

/**
 * Interface describing the necessary methods to implement a correct type of Displayer
 * @author Aurélien, Lucas
 *
 */
public interface  DisplayerInterface {
	
	/**
	 * Called to display a message in a stream
	 * @param msg The message that should be print.
	 */
	public abstract void display(String msg);
}
