/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 28, 2004
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
public class GUIPlayer extends Player {
	ThirteenApplication app;
	Hand selectedHand = null;
	/**
	 * @param g
	 * @param n
	 */
	public GUIPlayer(Thirteen g, String n) {
		super(g, n);
		//app = g;
		// TODO Auto-generated constructor stub
	}
	public void setApplicationLink(ThirteenApplication a){
		app = a;
	}

	/* (non-Javadoc)
	 * @see Player#getMove(Thirteen)
	 */
	public Hand getMove(PlayerInterface g) {
		hand.sort();
		Vector moves = g.legalMoves();
		waitForSelectedHand();
		Hand move = getSelectedHand();
		hand.removeCards(move);
		setSelectedHand(null);
		return move;
	}

	public synchronized void waitForSelectedHand(){
		while(!selectedHandIsSet()) 
			try{
				wait(200);
				//System.out.println("Waiting for move.");
			}
			catch(InterruptedException e){	}
	}
	public static void main(String[] args) {
	}
	/**
	 * @return
	 */
	public Hand getSelectedHand() {
		return selectedHand;
	}

	/**
	 * @param hand
	 */
	public void setSelectedHand(Hand hand) {
		selectedHand = hand;
	}
	public boolean selectedHandIsSet(){
		return selectedHand != null;
	}
}
