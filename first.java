import java.awt.Color;    

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class first extends JPanel {
	
	
	JButton Confirm = new JButton ("confirmer");
	DefaultListModel<String> arbrelist = new DefaultListModel<>();
	JList liste = new JList(arbrelist);
	JLabel texte = new JLabel ("choisissez votre arbre : ");
	List<treelayout> arbres = new ArrayList<treelayout>();
	
	public first () {
		for (int r=0 ; r<arbres.size();r++) {
			 arbrelist.addElement(arbres.get(r).debut.nomr.getText());
		 }
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liste.setPreferredSize(new Dimension (150,150));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc =new GridBagConstraints();
		this.setBackground(Color.WHITE);

		Confirm.setPreferredSize(new Dimension(150,60));
	 gbc.weightx = 1.0;
	 gbc.weighty = 1.0;	
	//placement du Label
	 gbc.gridx=3;
	 gbc.gridy=0;
	 gbc.gridheight=1;
	 gbc.gridwidth=GridBagConstraints.REMAINDER;
	 gbc.anchor=GridBagConstraints.SOUTHWEST;
	 gbc.insets = new Insets (15,15,15,15);
	 this.add(texte,gbc);
	 //placement du menu scrollable
	 gbc.weightx = 1.5;
	 gbc.weighty = 4.0;	
	 gbc.anchor=GridBagConstraints.CENTER;
	 gbc.gridx=3;
	 gbc.gridy=1;
	 gbc.gridheight=3;
	 gbc.gridwidth=2;
	 gbc.fill=GridBagConstraints.BOTH;
	 this.add(liste,gbc);
	 //placement du bouton nouveau
	 gbc.weightx = 0.5;
	 gbc.weighty = 0.5;	
	 gbc.gridx=0;
	 gbc.gridy=4;
	 gbc.gridheight =GridBagConstraints.REMAINDER;
	 gbc.gridwidth= 1;
	 gbc.fill=GridBagConstraints.NONE;
	 gbc.anchor=GridBagConstraints.SOUTHWEST;

	 //placement du bouton confirmation
	 //gbc.fill=GridBagConstraints.BOTH;
	 gbc.gridx=4;
	 gbc.gridy=4;
	 gbc.gridwidth=GridBagConstraints.REMAINDER;
	 gbc.gridheight = 1;
	 gbc.anchor=GridBagConstraints.SOUTHEAST;
	 
	 this.add(Confirm,gbc);
	
	 
}
	
	public static void main (String args []) 
	{
		JFrame fen = new JFrame();
		fen.setContentPane(new first());
		fen.setSize(500,400);
		fen.setVisible(true);
		
		
		
		
	}
}