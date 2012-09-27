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
import java.util.*;
public abstract class Game extends MyObject {
	Vector players = new Vector();
	int maxPlayers = 0; // if 0, then there is no max
	//Player currentPlayer = 0;
	public int playersCount(){
		return players.size();
	}
	public void addPlayer(Player p){
		players.add(p);
	}
	public Player getPlayer(int i){
		return (Player) players.get(i);
	}
	public void removePlayer(int i){
		players.remove(i);
	}
	public void removePlayer(Player p){
		players.remove(p);
	}
	public Vector getPlayers(){
		return players;
	}
	public void setPlayers(Vector p){
		players = p;
	}
}
