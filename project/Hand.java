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
public abstract class Hand extends MyObject implements CardContainer, Comparable, Cloneable {
	protected Vector cards = new Vector();
	protected static Hashtable handTypes = new Hashtable();
	protected static boolean initialized = false;
	public Hand(){
		super();
		init();
	}
	public Hand(Vector v){
		this();
		for(int i =0;i<v.size();i++){
			if(v.get(i).getClass().getName()=="Card")
				cards.add(v.get(i));
		}
	}
	public Hand(Card c){
		this();
		cards.add(c);
	}
	public static void init(){
		if (initialized) return;
		initialized = true;
	}
	public Card getCard(int i){
		return (Card) cards.get(i);
	}
	public void addCard(Card c){
		cards.add(c);
	}
	public void addCards(Hand h){
		for(int i=0;i<h.cardCount();i++)
			addCard(h.getCard(i));
	}
	public void addCards(Vector v){
		cards.addAll(v);
	}
	public boolean hasCard(Card c){
		return cards.contains(c);
	}
	public boolean isEmpty(){
		return cardCount()==0;
	}
	public int cardCount(){
		return cards.size();
	}
	public static Hand valueOf(Card c){
		return null;
	}
	public abstract String getHandType(Hand h);
	public abstract int evaluateHand();
	public static boolean isGreater(Hand a, Hand b){
		return a.evaluateHand() > b.evaluateHand();
	}
	public static boolean isEqual(Hand a, Hand b){
		return a.evaluateHand() == b.evaluateHand();
	}
	public static boolean isLess(Hand a, Hand b){
		return a.evaluateHand() < b.evaluateHand();
	}
	public static boolean isGreaterOrEqual(Hand a, Hand b){
		return isGreater(a,b) || isEqual(a,b);
	}
	public static boolean isLessOrEqual(Hand a, Hand b){
		return isLess(a,b)|| isEqual(a,b);
	}
	public static int getSuitValue(Card c){
		return 0;
	}
	public static int getValueValue(Card c){
		return 0;
	}
	public static void main(String args[]){
		/*
		Deck d = new Deck();
		d.setDebug(false);
		Hand h = new Hand();
		h.addCard(d.dealCard());
		System.out.println("Hand Test:\n"+h);
		*/
	}
	public String toString(){
		if(cards.size()==0) return "[skip]";
		String d = "[";
		for(int i = 0;i<cards.size();i++){
			d += getCard(i).toString();
			//if(i%5 == 0 && i!=0)
				//d += "\n";
		}
		return d+"]";
	}
	public static Card getLowestCard(Hand h){
		Card lowest = h.getCard(0);
		for(int i=1;i<h.cardCount();i++){
			if(h.evaluateCard(lowest)>h.evaluateCard(h.getCard(i)))
				lowest = h.getCard(i);
		}
		return lowest;
	}
	public static Card getHighestCard(Hand h){
		Card highest = h.getCard(0);
		for(int i=1;i<h.cardCount();i++){
			if(h.evaluateCard(highest)<h.evaluateCard(h.getCard(i)))
				highest = h.getCard(i);
		}
		return highest;
	}
	public abstract int evaluateCard(Card c);
	public abstract int compareTo(Object o);
	public Card removeCard(int i){
		return (Card) cards.remove(i);
	}
	public Card removeCard(Card c){
		cards.remove(c);
		return c;
	}
	public abstract void sort();
	public abstract Vector getPossiblePairs();
	public abstract Object clone();
	public void removeCards(Vector cards){
		cards.remove(cards);
	}
	public Vector getCards(){
		return cards;
	}
	public void removeCards(Hand h){
		//echo("Removing cards:"+h);
		for(int i=0;i<h.cardCount();i++)
			cards.remove(h.getCard(i));
		//cards.remove(h.getCards());
	}
	public void clearHand(){
		cards.clear();
	}
	public boolean equals(Hand h){
		boolean equal = true;
		
		if(cardCount() != h.cardCount()) return false;
		
		for(int i=0;i<cardCount();i++){
			equal = equal && h.hasCard(getCard(i));
		}
		return equal;
	}
}
