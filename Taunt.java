/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 30, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author DaAznAngel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Taunt {
	public static final Taunt NONE = new Taunt(0,"NONE"); 
	protected int tauntType;
	public static final int NEUTRAL = 0, ANGRY = 1, HAPPY = 2, 
		SAD = 3, EXCITED = 4, CONFIDENT = 5, TYPECOUNT=6;
	protected String tauntText;
	public Taunt(int type, String taunt){
		tauntType = type;
		tauntText = taunt; 
	}
	public String toString(){
		return tauntText;
	}
	public static int typeCount(){
		return TYPECOUNT;
	}
	/**
	 * @return
	 */
	public String getTauntText() {
		return tauntText;
	}

	/**
	 * @return
	 */
	public int getTauntType() {
		return tauntType;
	}

	/**
	 * @param string
	 */
	public void setTauntText(String string) {
		tauntText = string;
	}

	/**
	 * @param i
	 */
	public void setTauntType(int i) {
		tauntType = i;
	}

}
