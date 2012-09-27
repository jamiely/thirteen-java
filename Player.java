/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 15, 2004
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
public abstract class Player extends MyObject {
	String name; Thirteen game; VietnameseThirteenHand hand;
	public Player(Thirteen g, String n){
		name = n;
		game = g;
	}
	public String getName(){
		return name;
	}
	public Hand getHand(){
		return hand;
	}
	public void setHand(Hand h){
		hand = (VietnameseThirteenHand) h;
	}
	public abstract Hand getMove(PlayerInterface g);
	public Thirteen getGame(){
		return game;
	}
	public Taunt getTaunt(){
		return Taunt.NONE;
	}
}
