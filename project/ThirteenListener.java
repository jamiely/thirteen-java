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
public interface ThirteenListener {
	public void newGameStarted();
	public void playerHandsDealt();
	public void newRound();
	public void nextPlayer();
	public void handPlayed(Hand h);
	public void playerPassed();
	public void gameEnded();
	public void gettingMove();
	public void playerWon(Player p);
	public void newMessage(Player p, String s);
}
