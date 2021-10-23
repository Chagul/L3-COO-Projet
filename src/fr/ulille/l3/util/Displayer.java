package fr.ulille.l3.util;


/** This class centralize all the display that occurs. Only one instance of displayer can exists.
 * @author Aurélien, Lucas
 */
public class Displayer {
	
	private static Displayer displayer;
	
	public static Displayer getInstance() {
		if(displayer == null) {
			displayer = new Displayer();
		}
		return displayer;
	}

	
	public void display(String msg) {
		System.out.println(msg);
	}
}
