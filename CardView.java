import java.awt.LayoutManager;

import javax.swing.*;
import java.awt.*;

/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 27, 2004
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
public class CardView extends JPanel {
	static boolean imagesLoaded = false;
	static final int DEFAULTWIDTH = 100, DEFAULTHEIGHT=150,
		DEFAULTBORDER=2, DEFAULTARCWIDTH = 15,DEFAULTARCHEIGHT=25;
	static int cardwidth=DEFAULTWIDTH, cardheight=DEFAULTHEIGHT, 
		border=DEFAULTBORDER, arcwidth=DEFAULTARCWIDTH, archeight=DEFAULTARCHEIGHT;
	protected Card card;
	//public static final int SPADE = 0, CLUB =1, DIAMOND = 2, HEART = 3;
	public static Image[] suitImages = new Image[4]; 
	/**
	 * 
	 */
	public CardView(Card c) {
		super();
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(DEFAULTWIDTH,DEFAULTHEIGHT));
		this.setBackground(Color.WHITE);
		card = c;/*
		cardwidth = DEFAULTWIDTH;
		cardheight = DEFAULTHEIGHT;
		border = DEFAULTBORDER;
		arcwidth = DEFAULTARCWIDTH;
		archeight = DEFAULTARCHEIGHT;*/
		System.out.println("Cardwidht:"+cardwidth+" Cardheight:"+cardheight);
		
		
	}

	/**
	 * @param arg0
	 */
	public CardView(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public CardView(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CardView(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	public static void paintCard(int x, int y, Graphics g,Card c){
		paintCard(x,y,g,c,Color.WHITE);	
	}
	public static void paintCard(int x, int y, Graphics g,Card c,Color cardColor){
		paintCard(x,y,g,c,Color.WHITE,true);	
	}
	public static void paintCard(int x, int y, Graphics g,Card c,Color cardColor, boolean viewable){
		
		if(!imagesLoaded){
/*			suitImages[Thirteen.SPADE]= Toolkit.getDefaultToolkit().getImage("./images/spade.gif");
			suitImages[Thirteen.CLUB]= Toolkit.getDefaultToolkit().getImage("./images/club.gif");
			suitImages[Thirteen.DIAMOND]= Toolkit.getDefaultToolkit().getImage("./images/diamond.gif");
			suitImages[Thirteen.HEART]= Toolkit.getDefaultToolkit().getImage("./images/heart.gif");
*/			
			suitImages[Thirteen.SPADE]= Toolkit.getDefaultToolkit().getImage("./images/spade_sm.gif");
			suitImages[Thirteen.CLUB]= Toolkit.getDefaultToolkit().getImage("./images/club_sm.gif");
			suitImages[Thirteen.DIAMOND]= Toolkit.getDefaultToolkit().getImage("./images/diamond_sm.gif");
			suitImages[Thirteen.HEART]= Toolkit.getDefaultToolkit().getImage("./images/heart_sm.gif");			
			imagesLoaded = true;
		}
		g.setColor(Color.BLACK);
		//g.drawRect(0,0,100,100);
		//g.drawRoundRect(x,y,cardwidth,cardheight,15,25);
		g.fillRoundRect(x,y,cardwidth,cardheight,15,25);
		
		g.setColor(cardColor);
		g.fillRoundRect(x+border,y+border,cardwidth-2*border,
			cardheight-2*border,15,25);
		
		if(!viewable) return;
		
		//g.setColor(Color.BLACK);
		//g.drawRect(x + 20, y + 30, 60, 90);	
			
		if(c.getSuit() == Card.SPADE || c.getSuit() == Card.CLUB)
			g.setColor(Color.BLACK);
		else g.setColor(Color.RED);		
		g.drawString(c.getValue(),x+8,y+22);
		
		int suitValue = 0;
		if(c.getSuit().equals("club")) suitValue = 1;
		else if(c.getSuit().equals("diamond")) suitValue = 2;
		else if(c.getSuit().equals("heart")) suitValue = 3;
		
		g.drawImage(suitImages[suitValue],x+8,y+25,cardColor,null);
		//g.drawString(c.getSuit(),x+8,y+35);
		//System.out.println("****************");
	}
	public void paintCard(Graphics g, Card c){
		paintCard(0,0,g,card);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		paintCard(g,card);
	}

	public static void main(String[] args) {
		JFrame frmMain = new JFrame("CardTest");
		frmMain.getContentPane().add(new CardView(new Card("H","8")));
		frmMain.pack();
		frmMain.setVisible(true);
	}
	public static void scale(double percentage){
		if(percentage <= 0) return;
		border = (int) Math.ceil(percentage * DEFAULTBORDER);
		cardwidth = (int) Math.ceil(percentage * DEFAULTWIDTH);
		cardheight = (int) Math.ceil(percentage * DEFAULTHEIGHT);
		arcwidth = (int) Math.ceil(percentage * DEFAULTARCWIDTH);
		archeight = (int) Math.ceil(percentage * DEFAULTARCHEIGHT);
	}
	/**
	 * @return
	 */
	public static int getCardHeight() {
		return cardheight;
	}

	/**
	 * @return
	 */
	public static int getCardWidth() {
		return cardwidth;
	}

	/**
	 * @return
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param i
	 */
	public static void setCardHeight(int i) {
		cardheight = i;
	}

	/**
	 * @param i
	 */
	public static void setCardWidth(int i) {
		cardwidth = i;
	}

	/**
	 * @param card
	 */
	public void setCard(Card card) {
		this.card = card;
	}

	/**
	 * @return
	 */
	public static int getCardBorder() {
		return border;
	}

	/**
	 * @param i
	 */
	public static void setCardBorder(int i) {
		border = i;
	}

}
