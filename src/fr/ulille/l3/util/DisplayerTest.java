package fr.ulille.l3.util;


/** This class centralize all the display that occurs for the tests. The messages are not displayed so it is more readable. Only one instance of displayer can exists.
 * @author Aurélien, Lucas
 */
public class DisplayerTest implements DisplayerInterface{
	
	private static Displayer displayer;
	
	public static Displayer getInstance() {
		if(displayer == null) {
			displayer = new Displayer();
		}
		return displayer;
	}
	
	public void display(String msg) {
		//msg to trash
	}


}
