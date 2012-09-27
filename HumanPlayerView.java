import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
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
public class HumanPlayerView extends PlayerView implements ActionListener{
	protected JButton btnSubmit;
	protected JComboBox cmbxMoves;
	protected ComboBoxModel cmbxMovesModel;
	boolean ready = false;
	HandView handView;
	//protected Hand selectedHand;
	/**
	 * @param p
	 */
	public HumanPlayerView(Player p){
		this(p,false);
	}
	public HumanPlayerView(Player p, boolean vertical){
		super();
		player = p;
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//if(vertical) this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//else this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		JPanel upperPanel = new JPanel();
		JPanel lowerPanel = new JPanel();
		
		upperPanel.add(new Avatar(p,0));
		upperPanel.add(Box.createRigidArea(new Dimension(20,20)));
		
		handView = new HandView(p.getHand());
		handView.setSelectable(true);
		handView.setOpenHand(true);
		
		upperPanel.add(handView);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		upperPanel.add(btnSubmit);
		
		upperPanel.setBackground(Color.GREEN);
		
		cmbxMoves = new JComboBox();
		lowerPanel.add(cmbxMoves);
		lowerPanel.setBackground(Color.GREEN);
		cmbxMoves.addItem("Test0");
		cmbxMoves.addItem("Test1");
		cmbxMoves.addItem("Test2");
		cmbxMoves.addActionListener(this);
		
		add(upperPanel);
		add(lowerPanel);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
	public synchronized void updateAvailableMoves(){
		ready = false;
		cmbxMoves.removeAllItems();
		//System.out.println("Current:"+player.getGame().currentPlayer.getName());
		if(player.getGame().currentPlayer == player){
			Vector v = player.getGame().legalMoves();
			//System.out.println("available moves:"+v);
			/*
			if(v.size()==1)
			{
				setSelectedHand((Hand)v.get(0));
				return;
			} */
			for(int i=0;i<v.size();i++){
				cmbxMoves.addItem(v.get(i));
				// find event to display tool tip, possibly set tool tip diff when mouse move
				cmbxMoves.setToolTipText(v.get(i).toString()); 
			}	
					
			cmbxMoves.setVisible(true);
		}else{
			//cmbxMoves.addItem("Waiting for your turn");
			cmbxMoves.setVisible(false);
		}
		ready = true;
	}	
	public synchronized boolean isReady(){
		return ready;
	}
	public void actionPerformed(ActionEvent e){
		//System.out.println("Action performed, source:"+e.getSource().getClass().getName()+" comm:"+e.getActionCommand());
		/*
		if(e.getSource().getClass().getName().equals("javax.swing.JComboBox") && !isReady()){
			JComboBox cb = (JComboBox) e.getSource();
			try{
				if(cb.getItemCount()==1){
					setSelectedHand((Hand)cb.getItemAt(0));
				}				
			}catch(Exception ex){
				
			}
			
		}*/
		if(e.getSource()==cmbxMoves && isReady()){
		//if(e.getSource().getClass().getName().equals("javax.swing.JComboBox") && isReady()){
			JComboBox cb = (JComboBox) e.getSource();
			//int moveIndex = cb.getSelectedIndex();
			setSelectedHand((Hand)cb.getSelectedItem());
			cb.setVisible(false);
			handView.clearSelected();
		}
		else if(e.getSource() == btnSubmit){
			System.out.println("SUBMIT");
			Vector v = player.getGame().legalMoves();
			boolean isLegal = false;
			for(int i=0;i<v.size();i++){
				isLegal = isLegal || ((Hand)v.get(i)).equals(handView.getSelected());
				System.out.println(v.get(i) + ":" + handView.getSelected());
			}
			if(isLegal){
				setSelectedHand((Hand) handView.getSelected().clone());
				handView.clearSelected();
			}
		}
	}
	public static void main(String[] args) {
	}

	/**
	 * @param hand
	 */
	public void setSelectedHand(Hand hand) {
		//selectedHand = hand;
		//System.out.println("Set selected hand.");
		((GUIPlayer)player).setSelectedHand(hand);
	}

}