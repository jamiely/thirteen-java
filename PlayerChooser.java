import java.util.*;
import javax.swing.*;

/*
 * Jamie Ly
 * jal39@drexel.edu
 * CS ##:TITLE
 * Assignment ## Program ##
 * 
 * Created on Jun 2, 2004
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
public class PlayerChooser extends JPanel {
	JLabel number;
	JComboBox cbxPlayers;
	/**
	 * 
	 */
	public PlayerChooser(int i) {
		super();
		number = new JLabel(String.valueOf(i));
		add(number);
		
		cbxPlayers = new JComboBox();
		cbxPlayers.addItem("Random Player");
		cbxPlayers.addItem("Low AI Player");
		cbxPlayers.addItem("None");
		add(cbxPlayers);
	}
	public JComboBox getComboBox(){
		return cbxPlayers;
	}
	public JLabel getLabel(){
		return number;
	}
	public void setSelected(int i){
		getComboBox().setSelectedIndex(i);
	}
	public static void main(String[] args) {
	}
}
