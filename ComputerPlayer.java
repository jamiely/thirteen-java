/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on May 30, 2004
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
import java.io.*;
public class ComputerPlayer extends Player {
	protected Vector tauntList = new Vector();
	
	/**
	 * @param g
	 * @param n
	 */
	public ComputerPlayer(Thirteen g, String n) {
		super(g, n);
		loadTaunts();
	}
	/* (non-Javadoc)
	 * @see Player#getMove(PlayerInterface)
	 */
	public Hand getMove(PlayerInterface g) {
		return null;
	}

	public void loadTaunts(){
		for(int i=0;i<Taunt.TYPECOUNT;i++){
			tauntList.add(new Vector());
		}
		FileInputStream f = null;
		BufferedReader in = null;
		try{
			f = new FileInputStream("./taunts/"+this.getClass().getName()+".taunts");
			in = new BufferedReader(new InputStreamReader(f));
		}catch(Exception e){
			return;
		}
		
		Taunt t;
		String line;
		String[] info;
		try{
			line = in.readLine();
			while(!line.equals("")){
				try{
					info = line.split(";");
					t = new Taunt(Integer.parseInt(info[0]),info[1]);
					((Vector)tauntList.get(t.getTauntType())).add(t);
				}catch(Exception e){
					break;
				}
				line = in.readLine();
			}
		}catch(Exception e){
			//
		}
	}
	
	public Taunt getTaunt(int type){
		//int index = (int) Math.floor(Math.random()*Taunt.typeCount());
		Vector taunts = (Vector) tauntList.get(type);
		
//		if(taunts.isEmpty()) return "No taunts available.";
		int index2 = (int) Math.floor(Math.random()*taunts.size());
		
		System.out.println("Getting taunt: type="+type+" number="+index2+" text="+taunts.get(index2));
		return (Taunt) taunts.get(index2); 
	}
	public Taunt getTaunt(){
	
		int cards = getHand().cardCount();
		System.out.println("My taunts:"+tauntList+ " cards:"+cards);
		if(cards == 1){
			int choice = (int) Math.random()*3;
			switch(choice){
				case 0: return getTaunt(Taunt.CONFIDENT);
				case 1: return getTaunt(Taunt.HAPPY);
				case 2: return getTaunt(Taunt.EXCITED);
			}
		}
		else if(cards == 6 || cards == 7){
			return getTaunt(Taunt.NEUTRAL);
		}
		else if(cards < 6){
			return getTaunt(Math.random()<.5?Taunt.HAPPY:Taunt.EXCITED);
		}
		
		return getTaunt(Math.random()<.5?Taunt.SAD:Taunt.ANGRY);
		
	}
	public Vector getAllTaunts(){
		return tauntList;
	}
	
	public static void main(String[] args) {
		ComputerPlayer p = new ComputerPlayer(null,"Jay");
		System.out.println(p.getAllTaunts());
	}
}