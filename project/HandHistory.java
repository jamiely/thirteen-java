/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 14, 2004
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
import java.util.*;
public class HandHistory extends MyObject {
	protected Vector hands = new Vector();
	public void addHand(Hand h){
		hands.add(h);
	}
	public int handCount(){
		return hands.size();
	}
	public Hand getHand(int i){
		return (Hand) hands.get(i);
	}
	public Vector getHands(){
		return hands;
	}
}
