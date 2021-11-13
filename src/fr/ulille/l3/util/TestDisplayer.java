package fr.ulille.l3.util;


/** This class centralize all the display that occurs for the tests. The messages are not displayed so it is more readable. Only one instance of displayer can exists.
 * @author Aurélien, Lucas
 */
public class TestDisplayer implements DisplayerInterface{
	
	private static 	TestDisplayer displayer;
	
	public static TestDisplayer getInstance() {
		if(displayer == null) {
			displayer = new TestDisplayer();
		}
		return displayer;
	}

	public void display(String msg) {
		//msg to trash
	}

}
