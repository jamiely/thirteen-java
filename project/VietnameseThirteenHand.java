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
public class VietnameseThirteenHand extends PokerHand {
	public static String STRAIGHT3 = "3-card straight", STRAIGHT4 ="4-card straight",
		STRAIGHT5="5-card straight",STRAIGHT6="6-card straight",
		STRAIGHT7="7-card straight",STRAIGHT8="8-card straight",
		STRAIGHT9="9-card straight",STRAIGHT10="10-card straight",
		STRAIGHT11="11-card straight",STRAIGHT12="12-card straight",
		STRAIGHT13="13-card straight",CUT="cut",SUPERCUT="supercut";
		
	public static Hashtable SUITVALUES = new Hashtable(), VALUEVALUES = new Hashtable();
	
	/**
	 * 
	 */
	public VietnameseThirteenHand() {
		super();
		init();
		debug = false;
	}
	public VietnameseThirteenHand(Card c){
		super(c);
		init();
	}
	public VietnameseThirteenHand(Vector v){
		super(v);
		init();
	}
	public static void init(){
		
		SUITVALUES.put(Card.SPADE,INTEGERS.get(0));
		SUITVALUES.put(Card.CLUB,INTEGERS.get(1));
		SUITVALUES.put(Card.DIAMOND,INTEGERS.get(2));
		SUITVALUES.put(Card.HEART,INTEGERS.get(3));
	
		VALUEVALUES.put(Card.THREE,INTEGERS.get(0));
		VALUEVALUES.put(Card.FOUR,INTEGERS.get(1));
		VALUEVALUES.put(Card.FIVE,INTEGERS.get(2));
		VALUEVALUES.put(Card.SIX,INTEGERS.get(3));
		VALUEVALUES.put(Card.SEVEN,INTEGERS.get(4));
		VALUEVALUES.put(Card.EIGHT,INTEGERS.get(5));
		VALUEVALUES.put(Card.NINE,INTEGERS.get(6));
		VALUEVALUES.put(Card.TEN,INTEGERS.get(7));
		VALUEVALUES.put(Card.JACK,INTEGERS.get(8));
		VALUEVALUES.put(Card.QUEEN,INTEGERS.get(9));
		VALUEVALUES.put(Card.KING,INTEGERS.get(10));
		VALUEVALUES.put(Card.ACE,INTEGERS.get(11));
		VALUEVALUES.put(Card.TWO,INTEGERS.get(12));

		handTypes.put(SINGLE,SINGLE); handTypes.put(PAIR,PAIR);
		handTypes.put(THREEOFAKIND,THREEOFAKIND);
		handTypes.put(FOUROFAKIND,FOUROFAKIND);

		// straights
		handTypes.put(STRAIGHT3,STRAIGHT3); handTypes.put(STRAIGHT4,STRAIGHT4);
		handTypes.put(STRAIGHT5,STRAIGHT5); handTypes.put(STRAIGHT6,STRAIGHT6);
		handTypes.put(STRAIGHT7,STRAIGHT7); handTypes.put(STRAIGHT8,STRAIGHT8);
		handTypes.put(STRAIGHT9,STRAIGHT9); handTypes.put(STRAIGHT10,STRAIGHT10);
		handTypes.put(STRAIGHT11,STRAIGHT11); handTypes.put(STRAIGHT12,STRAIGHT12);
		handTypes.put(STRAIGHT13,STRAIGHT13); 		 
		
		// cuts
		handTypes.put(CUT,CUT); handTypes.put(SUPERCUT,SUPERCUT);				 
	}
	public String getHandType(Hand h){
		String type="INVALID";
		if(isSingle(h)) type = SINGLE;
		else if(isPair(h)) type = PAIR;
		else if(isThreeOfAKind(h)) type = THREEOFAKIND;
		else if(isFourOfAKind(h)) type = FOUROFAKIND;
		else if(isCut(h)) type = CUT;
		else if(isSuperCut(h)) type = SUPERCUT;
		else if(isStraight(h)){
			//debugOut("IS STRAIGHT!");
			switch(h.cardCount()){
				 case 3: type = STRAIGHT3; break;
				 case 4: type = STRAIGHT4; break;
				 case 5: type = STRAIGHT5; break;
				 case 6: type = STRAIGHT6; break;
				 case 7: type = STRAIGHT7; break;
				 case 8: type = STRAIGHT8; break;
				 case 9: type = STRAIGHT9; break;
				 case 10: type = STRAIGHT10; break;
				 case 11: type = STRAIGHT11; break;
				 case 12: type = STRAIGHT12; break;
				 case 13: type = STRAIGHT13; break;				 
			}
		}
		return type;
	}
	public static boolean isCut(Hand h){
		return h.cardCount()==6 && true;
	}
	public static boolean isSuperCut(Hand h){
		return h.cardCount()==8 && true;
	}
	public static int getSuitValue(Card c){
		return ((Integer) SUITVALUES.get(c.getSuit())).intValue();
	}
	public static int getValueValue(Card c){
		return ((Integer) VALUEVALUES.get(c.getValue())).intValue();
	}
	public int evaluateHand(){
		int val;
		if(cardCount() == 0) val = 0;
		else val = evaluateCard(getHighestCard(this));
		debugOut ("Eval hand:" + this + " : "+val);
		return val; // return the value of the highest card
	}
	public static void main(String args[]){
		Deck d = new Deck();
		echo("Original\n"+d);
		d.shuffle();
		echo("Shuffled\n"+d);
		Hand h = new VietnameseThirteenHand();
		
		Card a;
		int size=d.cardCount();
		for(int i=0;i<13;i++){
			a = d.dealCard();
			//echo("Dealing card:"+a);
			h.addCard(a);
		}
		
		d.sort();
		
		echo("Sorted deck:" + d);
		
		System.out.println("Hand:"+h+(PokerHand.isSingle(h)?"IS SINGLE":"IS NOT SINGLE"));
		h.sort();
		System.out.println("Sorted:" + h);
		Card c = h.getCard(0);
		echo("HighestCard:"+getHighestCard(h)+" Lowest Card:"+getLowestCard(h));
		
		//System.out.println(SUITVALUES +"\n"+ VALUEVALUES);
		//System.out.println("Suit:"+c.getSuit());
		//System.out.println("Suit Val:"+getSuitValue(c)+" Val Val:"+getValueValue(c));
		//System.out.println((Hand.isGreaterOrEqual(h,h))?"0 is greater than or equal to 1":"1 is greater than 0");
		//System.out.println("Highest cArd:"+getHighestCard(h));
		//System.out.println("Lowest cArd:"+getLowestCard(h));
		//for(int i=0;i<h.cardCount();i++)
		//	System.out.println(h.getCard(i) + " eval:" + h.evaluateCard(h.getCard(i)));
			
		// test evaluation functions
		
		//Hand s1 = new VietnameseThirteenHand();
		//s1.addCard(new Card(Card.SPADE,Card.EIGHT));
		//s1.addCard(new Card(Card.CLUB,Card.EIGHT));
		//s1.addCard(new Card(Card.HEART,Card.EIGHT));
		//s1.addCard(new Card(Card.DIAMOND,Card.TEN));
		
		//System.out.println("Hand test:" + s1 + " Type:" + s1.getHandType(s1));
		//System.out.println("is straight?" + (isStraight(s1)?"Yes":"No"));
		echo("Possible fours:" + ((VietnameseThirteenHand)h).getPossibleFours());
		echo("Possible pairs:" + ((VietnameseThirteenHand)h).getPossiblePairsAlt());
		echo("Possible cuts:" + ((VietnameseThirteenHand)h).getPossibleCuts());
		echo("\n\nAll possible hands:\n");
		Vector v = ((VietnameseThirteenHand)h).getPossibleHands();
		for(int i=0;i<v.size();i++)
			echo(""+v.get(i));
		//echo("Possible straights:" + ((VietnameseThirteenHand)h).getPossibleStraightsAlt());
	}
	public int evaluateCard(Card c){
		//echo ("Evaluating viet card.");
		return getValueValue(c) * 10 + getSuitValue(c);
	}
	/**
	 * Returns true if hand a can beat hand b.
	 * @param a Hand
	 * @param b Hand
	 * @return
	 */
	public boolean canBeatHand(Hand a, Hand b){
		if(!sameHandType(a,b)) return false; // make sure they are of same type
		if(isLess(a,b)) return false; // make sure that b > a
		return true;
	}
	public boolean sameHandType(Hand a, Hand b){
		return getHandType(a) == getHandType(b);
	}
	public void sort(){
		Vector v = new Vector();
		for(int i =0;i<cardCount();i++){
			Hand h = new VietnameseThirteenHand();
			v.add(h);
			h.addCard(getCard(i));
		}
		cards.clear();
		//echo(v);
		quickSort(v);
		//echo(v);
		for(int i=0;i<v.size();i++)
			addCard(((Hand)v.get(i)).getCard(0));
	}
	public static boolean isStraight(Hand h){
		boolean ret = true;
		Vector v = new Vector();
		VietnameseThirteenHand tmp;
		for(int i=0;i<h.cardCount();i++){
			tmp = new VietnameseThirteenHand();
			v.add(tmp);
			tmp.addCard(h.getCard(i));
		}
		quickSort(v);
		Hand tmp2 = new VietnameseThirteenHand();
		for(int i =0;i<v.size();i++){
			tmp2.addCard(((Hand)v.get(i)).getCard(0));
		}
		//echo("tmp2 hand:"+tmp2);
		if(tmp2.cardCount() == 0) return false;
		int val = getValueValue(tmp2.getCard(0));
		for(int i =1;i<tmp2.cardCount();i++){
			val++;
			ret = ret && getValueValue(tmp2.getCard(i))==(val);
		}
		return ret;
	}
	public int compareTo(Object o){
		if(evaluateHand() == ((VietnameseThirteenHand)o).evaluateHand()) return 0;
		else if(evaluateHand() > ((VietnameseThirteenHand)o).evaluateHand()) return 1;
		else return -1;
	}
	public Vector getPossibleHands(){
		// create single-card hands
		Vector hands = new Vector();
		Hand h;
		hands.add(new VietnameseThirteenHand());
		hands.addAll(getPossibleSingles());
		hands.addAll(getPossibleFours());
		hands.addAll(getPossiblePairsAlt());
		hands.addAll(getPossibleStraightsAlt());
		hands.addAll(getPossibleCuts());
		// create pairs
		
		return hands;
	}
	public Vector getPossibleStraights(){
		Vector hands=new Vector();
		Vector ret= new Vector();
		int lastValue;
		//Integer lastValue;
		Card c;
		if(cardCount()==0) // if there are no cards left, return an empty vector 
			return hands;
		Hand h;
		hands.addAll(getPossibleSingles());
		quickSort(hands);
		//hands = handsToCards(hands);
		h = (Hand)hands.get(0);
		lastValue= getValueValue(h.getCard(0)); //(Integer) VALUEVALUES.get(h.getCard(0).getValue());

		h = new VietnameseThirteenHand();
		for(int i =1;i<hands.size();i++){
			c = (Card) ((Hand) hands.get(i)).getCard(0);
			//if(VALUEVALUES.get(c.getValue()).equals(lastValue)){
			if(getValueValue(c) == lastValue+1){
				h.addCard(c);
				if(h.cardCount() >= 3){
					ret.add((Hand) h.clone());
				}
			}
			else{
				h = new VietnameseThirteenHand();
			}
			lastValue =getValueValue(c); 
		}
		return ret;		
	}
	public Vector getPossibleStraightsAlt(){
		Vector ret= new Vector();
		int size = VALUEVALUES.size();
		Vector[] buckets = new Vector[size];
		for(int i=0;i<size;i++) buckets[i]=new Vector();
		for(int i=0;i<cardCount();i++){
			buckets[getValueValue(getCard(i))].add(getCard(i));
		}
		Hand h;
		Vector tmp, hands = new Vector();
		hands.add(new VietnameseThirteenHand());
		Card c;
		
		
		int last = -1000, sublast=-1000;
		for(int i=0;i<size-1;i++){ // size-1 here so that it excludes 2 from being part of a straight
			//System.out.println("Buckets:"+buckets[i]);
			if( buckets[i].size() > 0 && (i == last + 1 || last == -1000)){
				tmp = new Vector();
				for(int k=1;k<buckets[i].size();k++){ // for each number in the bucket beyond the first
					for(int m=0;m<hands.size();m++){ // clone each hand
						h = (Hand) hands.get(m);
						tmp.add(h.clone());
					}
				}
				hands.addAll(tmp);
				for(int j=0;j<hands.size();j++){
					h = (Hand) hands.get(j);
					h.addCard((Card)buckets[i].get(j%buckets[i].size()));
				}
				h = (Hand) hands.get(0);
				if(h.cardCount() >= 3){
					for(int j=0;j<hands.size();j++){
						h = (Hand) hands.get(j);
						if(h.cardCount()>=3)
							ret.add(h.clone());
					}
				}	
			}
			else{
				hands.clear();
				hands.add(new VietnameseThirteenHand());
			}
			last = i;
		}
		return ret;		
	}
		
	/**
	 * Given a straight, will return sub straights that can be formed from that straight
	 * @param h
	 * @return
	 */
	public Vector getSubStraights(Hand h){
		return null;
	}
	public Vector getPossibleFours(){
		Vector hands=new Vector();
		Vector ret= new Vector();
		String lastValue;
		Card c;
		if(cardCount()==0) return hands;
		Hand h;
		hands.addAll(getPossibleSingles());
		quickSort(hands);
		//hands = handsToCards(hands);
		h = (Hand)hands.get(0);
		lastValue=h.getCard(0).getValue();
		int count = 1;
		for(int i =1;i<hands.size();i++){
			c = (Card) ((Hand) hands.get(i)).getCard(0);
			if(c.getValue() == lastValue){
				count++;
				h = new VietnameseThirteenHand();
				for(int j=0;j<count;j++){
					h.addCard((Card) ((Hand) hands.get(i-j)).getCard(0));	
				}
				if(h.cardCount() > 2)
					ret.add(h);
			}
			else{
				count = 1;
			}
			lastValue = c.getValue();
		}
		return ret;
	}/*
	public Vector getPossiblePairs(){
		Vector hands=new Vector();
		Vector ret= new Vector();
		String lastValue;
		Card c;
		if(cardCount()==0) return hands;
		Hand h;
		hands.addAll(getPossibleSingles());
		quickSort(hands);
		//hands = handsToCards(hands);
		h = (Hand)hands.get(0);
		lastValue=h.getCard(0).getValue();
		
		for(int i =1;i<hands.size();i++){
			c = (Card) ((Hand) hands.get(i)).getCard(0);
			if(c.getValue() == lastValue){
				h = new VietnameseThirteenHand(c);
				h.addCard((Card) ((Hand) hands.get(i-1)).getCard(0));
				ret.add(h);
			}
			lastValue = c.getValue();
		}
		return ret;
	}*/
	public Vector getPossiblePairsAlt(){
		Vector ret = new Vector();
		int size = VALUEVALUES.size();
		Vector[] buckets = new Vector[size];
		for(int i=0;i<size;i++) buckets[i]=new Vector();
		for(int i=0;i<cardCount();i++){
			buckets[getValueValue(getCard(i))].add(getCard(i));
		}
		Hand h= new VietnameseThirteenHand();
		for(int i=0;i<buckets.length;i++){
			//System.out.println("Buckets:"+buckets[i]);
			if(buckets[i].size() < 2) continue;
			for(int j=0;j<buckets[i].size();j++){
				for(int k=j+1;k<buckets[i].size();k++){
					h= new VietnameseThirteenHand();
					h.addCard((Card)buckets[i].get(j));
					h.addCard( (Card)buckets[i].get(k) );
					//System.out.println("1:"+h.getCard(0)+"2:"+h.getCard(1));
					if(h.cardCount()==2) ret.add(h);
				}
				
			}
		}
		return ret;
	}
	public Vector getPossibleSingles(){
		Vector hands = new Vector();
		for(int i =0;i<cardCount();i++){
			hands.add(new VietnameseThirteenHand(getCard(i))); 
		}		
		return hands;
	}
	public Vector getPossibleCuts(){
		Vector ret = new Vector(), pairs = getPossiblePairsAlt();
		int last = 0;
		Card c;
		Hand h,tmp=new VietnameseThirteenHand();
		last = -100;
		for(int i=0;i<pairs.size();i++){ // will never include 2 pair in a cut, b/c of NOTE
			h = (Hand)pairs.get(i);
			c = h.getCard(0);
			if(last + 1 == getValueValue(c) || last == -100){
				for(int j=0;j<h.cardCount();j++){
					tmp.addCard(h.getCard(j));
				}
				//getPossibleCutsHelper(tmp,ret); // NOTE prevents pair of 2's from being in a cut
			}else{
				getPossibleCutsHelper(tmp,ret);
				tmp = new VietnameseThirteenHand();
			}
			last = getValueValue(c);
		}
		return ret;
	}
	public void getPossibleCutsHelper(Hand tmp,Vector ret){
		Hand retHand;
		for(int j=0;j<tmp.cardCount();j+=2){
			retHand = new VietnameseThirteenHand();
			for(int k=j;k<tmp.cardCount();k+=2){
				retHand.addCard(tmp.getCard(k));
				retHand.addCard(tmp.getCard(k+1));
				if(retHand.cardCount() == 6 || retHand.cardCount() == 8)
					ret.add(retHand.clone());
			}
	
		}
	}
	/**
	 * Converts an array of hands to an array of cards
	 * @param v
	 * @return
	 */
	public Vector handsToCards(Vector v){
		Vector cards = new Vector();
		Hand h;
		for(int i=0;i<v.size();i++){
			h = (Hand) v.get(i);
			for(int j=0;j<h.cardCount();j++){
				cards.add(h.getCard(j));
			}
		}
		return cards;
	}
	public Object clone(){
		Hand h = new VietnameseThirteenHand();
		for(int i=0;i<cardCount();i++){
			h.addCard(getCard(i));
		}
		return h;
	}
}
