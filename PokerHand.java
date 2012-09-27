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
public class PokerHand extends Hand {
	public static String SINGLE="single", PAIR="pair", THREEOFAKIND="three of a kind",
		FOUROFAKIND="four of a kind", FULLHOUSE="full house", FLUSH="flush",
		STRAIGHT="straight",STRAIGHTFLUSH="straight flush", ROYALFLUSH="royal flush";
	/**
	 * 
	 */
	public PokerHand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PokerHand(Card c){
		super(c);
	}
	public PokerHand(Vector v){
		super(v);
	}
	public static void init(){
		//handTypes.add()
	}
	public static boolean allCardsEqualValue(Hand h){
		boolean re = true;
		String lastValue;
		if(h.cardCount()==0) return true;
		else lastValue = h.getCard(0).getValue();
		for(int i=0;i<h.cardCount();i++){
			re = re&& h.getCard(i).getValue()==lastValue;
		}
		return re;
	}
	public static boolean allCardsEqualSuit(Hand h){
		boolean re = true;
		String lastSuit;
		if(h.cardCount()==0) return true;
		else lastSuit = h.getCard(0).getSuit();
		for(int i=0;i<h.cardCount();i++){
			re = re&& h.getCard(i).getSuit()==lastSuit;
		}
		return re;
	}
	public static boolean isSingle(Hand h){
		return h.cardCount()==1;
	}
	public static boolean isPair(Hand h){
		return h.cardCount()==2 && allCardsEqualValue(h);
	}
	public static boolean isThreeOfAKind(Hand h){
		return h.cardCount()==3 && allCardsEqualValue(h);
	}
	public static boolean isFourOfAKind(Hand h){
		return h.cardCount()==4 && allCardsEqualValue(h);
	}
	public static boolean isStraight(Hand h){
		//bucket sort
		
		int[] buckets = new int[13];
		int value;
		for(int i=0;i<13;i++) buckets[i] = 0;
		for(int i=0;i<h.cardCount();i++){
			value = getValueValue(h.getCard(i));
			if(buckets[value]==0){
				buckets[value] = 1; 
			}
			else return false; // if there is a pair in the hand, it is not a straight
		}
		boolean flag = false;
		for(int i=0;i<13;i++){
			if(buckets[i]==1){
				flag = true;
			}
			else if(buckets[i]==0 && flag){
				return false;
			}
		}
		return true;
	}
	public String getHandType(Hand h){
		return "None";
	}
	public int evaluateHand(){
		echo ("Evaluating poker hand.");
		return 0;
	}
	public int evaluateCard(Card c){
		return 0;
	}
	public void sort(){
	}
	public int compareTo(Object o){
		if(isEqual(this,(Hand)o)) return 0;
		else if(isGreater(this,(Hand)o)) return 1;
		else return -1;
	}
	public Vector getPossiblePairs(){
		return null;
	}
	public Object clone(){
		return null;
	}
}
