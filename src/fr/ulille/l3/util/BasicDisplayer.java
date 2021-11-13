package fr.ulille.l3.util;


/** This class centralize all the display that occurs. Only one instance of displayer can exists.
 * @author Aurélien, Lucas
 */
public class BasicDisplayer implements DisplayerInterface{
	
	private static BasicDisplayer displayer;
	
	public static BasicDisplayer getInstance() {
		if(displayer == null) {
			displayer = new BasicDisplayer();
		}
		return displayer;
	}
	
	public void display(String msg) {
		System.out.println(msg);
	}


}
