import java.util.Hashtable;

/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 13, 2004
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
public class Card extends MyObject {
	String suit, value;
	static boolean initialized = false;
	static final String SPADE="spade",CLUB="club",DIAMOND="diamond",HEART="heart";
	static final String TWO="2", THREE="3", FOUR="4", FIVE="5", SIX="6",
		SEVEN="7", EIGHT="8", NINE="9", TEN="10", JACK="J", QUEEN="Q",
		KING="K", ACE="A";
	static Hashtable SUITS = new Hashtable();
	{}
	static Hashtable VALUES = new Hashtable();
	{
		
	}
	public static void init(){
		if (initialized) return;
		initialized = true;
		SUITS.put(SPADE,SPADE);
		SUITS.put(CLUB,CLUB);
		SUITS.put(DIAMOND,DIAMOND);
		SUITS.put(HEART,HEART);
		
		VALUES.put(TWO,TWO);
		VALUES.put(THREE,THREE);
		VALUES.put(FOUR,FOUR);
		VALUES.put(FIVE,FIVE);
		VALUES.put(SIX,SIX);
		VALUES.put(SEVEN,SEVEN);
		VALUES.put(EIGHT,EIGHT);
		VALUES.put(NINE,NINE);
		VALUES.put(TEN,TEN);
		VALUES.put(JACK,JACK);
		VALUES.put(QUEEN,QUEEN);
		VALUES.put(KING,KING);
		VALUES.put(ACE,ACE);
	}
	public Card(String suit, String value){
		init();
		this.suit = SUITS.contains(suit)?suit:SPADE;
		this.value = VALUES.contains(value)?value:THREE;
		if(this.isDebug())
			if(!SUITS.contains(suit))
				this.debugOut("Invalid suit: "+suit);
			else if (!VALUES.contains(value))
				this.debugOut("Invalid value: "+value);
	}
	public String toString(){
		return "("+suit+","+value+")";
	}
	public static void main(String args[]){
		Card c = new Card(SPADE,NINE);
		System.out.println("Card:"+c);
	}
	public String getSuit(){
		return suit;
	}
	public String getValue(){
		return value;
	}
	public int valueCount(){
		return VALUES.size();
	}
	public int suitCount(){
		return SUITS.size();
	}
}
