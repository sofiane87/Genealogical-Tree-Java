import java.awt.Color;     

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class accueil extends JFrame {
		
		JMenuItem nouveau = new JMenuItem("nouvel arbre ?");
		JMenuBar menu = new JMenuBar();
		JMenu nouv =new JMenu ("nouveau");
		JMenuItem supr = new JMenuItem("supprimer un arbre");
		JMenu sup =new JMenu ("suprimer");
		first fond = new first();
		
		
	 public accueil () {
		 
		 this.setSize(1000,800);
		 //this.setContentPane(new pancueil());
		 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 this.setLayout(new GridLayout(2,1));
		 this.add(new pancueil());
		 this.add(fond);
		 this.setLocationRelativeTo(null);
		 menu.setSize(this.WIDTH,50);
		 nouv.add(nouveau);
		 menu.add(nouv);
		 sup.add(supr);
		 menu.add(sup);
		 this.setJMenuBar(menu);
		 
		 
		 nouveau.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					
					 final JFrame test = new JFrame ();
			    	  final JTextField rnom = new JTextField ();
			    	  final JTextField rprenom = new JTextField ();
			    	  final JTextField rdate = new JTextField ();
			    	  final JTextField rsexe = new JTextField ();
			    	  
			    	  JLabel i = new JLabel ("entrez les informations du plus vieil ancêtre : ");
			    	  JLabel n = new JLabel("Nom :");
			    	  JLabel p = new JLabel ("Prenom :");
			    	  JLabel d = new JLabel ("Age : ");
			    	  JLabel s = new JLabel ("Sexe : ");
			    	  final List<JTextField> crite = new ArrayList<JTextField>();
			    	  JButton val = new JButton ("valider");
			    	  
			    	  val.addActionListener(new ActionListener() {
			    		  public void actionPerformed(ActionEvent event) {
			    			  identite premier = new identite (rnom.getText(),rprenom.getText(),rdate.getText(),rsexe.getText());
			    			  premier.setVisible(false);
			    			  treelayout arbre = new treelayout (premier.nomr.getText(),premier,accueil.this);

			    		
			    			  fond.arbres.add(arbre);
			    			  fond.arbrelist.addElement(rnom.getText());
			    			  fond.revalidate();
			    			  fond.repaint();
			    			  accueil.this.revalidate();
			    			  accueil.this.repaint();
			    			  test.dispose();
			    			  
			    			  
			    		  }
			    		  
			    	
			    		  
			    	  });
			    	  

			    	 
			    	  //propriété de test 
			    	  test.setSize(400,300);
			    	  test.setTitle("modification ");
			    	  test.setLayout(null);
			    	  test.setLocationRelativeTo(null);
			    	  //
			    	  
			    	  //disposition des différents Fields
			    	  
			    	  test.add(i);
			    	  i.setBounds(25,20,350,30);
			    	  test.add(n);
			    	  test.add(rnom);
			    	  n.setBounds(25,50,70,30);
			    	  rnom.setBounds(100,50,200,30);
			    	  
			    	  
			    
			    	  test.add(p);
			    	  test.add(rprenom);
			    	  p.setBounds(25,90,60,30);
			    	  rprenom.setBounds(100,90,200,30);
			    	  
		
			    	
			    	  test.add(d);
			    	  test.add(rdate);
			    	  d.setBounds(25,130,70,30);
			    	  rdate.setBounds(100,130,200,30);
			    	  
			    	  test.add(s);
			    	  test.add(rsexe);
			    	  s.setBounds(25,170,70,30);
			    	  rsexe.setBounds(100,170,200,30);
			    	  
			    	  
			    	  val.setBounds(05,200,95,50);
			    	  test.add(val);
			    	  
			 test.setVisible(true);   	  
			    	  
					
				 }
		    });
		 
		 supr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					
					JButton valider = new JButton ("valider");
	  				 final JDialog name = new JDialog ();
	  				 
	  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
	  				final JList choix = new JList(arbrelist);
	  				for (int r=0 ; r<fond.arbres.size();r++) {
	  					 arbrelist.addElement(fond.arbres.get(r).debut.nomr.getText());
	  				 }
	  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	  				choix.setPreferredSize(new Dimension (150,150));
	  				 choix.setPreferredSize(new Dimension (150,150));
	  				 
	  				 //positionnement dans le name 
	  				 name.setLocationRelativeTo(null);
	  				 name.setSize(400,200);
	  				 name.setTitle("suppression d'arbre");
	  				 
	  				 name.add(new JLabel ("choisissez la: "),BorderLayout.NORTH);

	  				 name.add(choix);
	  				 name.add(new JScrollPane(choix));
	  				 
	  				 name.add(valider,BorderLayout.SOUTH); 
	  				 name.setVisible(true);
	  				 valider.addActionListener(new ActionListener(){
	  				      public void actionPerformed(ActionEvent event){
	  				    	
	  				    	JOptionPane jop = new JOptionPane();			
	  				    	int option = jop.showConfirmDialog(null, "Vous etes sur le point de supprimer un arbre , en etes vous sur ? ", "attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	  				    				
	  				    	if(option == JOptionPane.OK_OPTION){
	  				    		
	  				    	
	  				    	 
	  				    	 fond.arbrelist.remove(choix.getSelectedIndex());
	  				    	 fond.arbres.remove(choix.getSelectedIndex());
	  				    	 fond.revalidate();
	  				    	 fond.repaint();
	  				    	 accueil.this.revalidate();
	  				    	 accueil.this.repaint();
	  				    	 name.dispose();
	  				    	}
	  				    	
				 }
		    });
		
				}
		    });
		 
		 
		 		this.fond.Confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						
						fond.arbres.get(accueil.this.fond.liste.getSelectedIndex()).setVisible(true);
						
						
					 }
			    });
		 		
			    
					
		 
		 this.setVisible(true);
		 
		 
		 
		 }
	 
	 				

public static void main (String args []) {
	 accueil fen = new accueil();
	 }

}