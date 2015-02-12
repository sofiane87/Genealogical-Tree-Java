import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class treelayout extends JFrame {
		
	JMenuBar menu = new JMenuBar();
	JMenu ajouter = new JMenu ("ajouter");
	
	JMenu supprimer = new JMenu ("supprimer");
	JMenu modif = new JMenu ("remplacer");
	JMenu rechercher = new JMenu ("rechercher");
	JMenu actualiser = new JMenu ("actualiser");
	
	JMenuItem modifier = new JMenuItem ("remplacer un membre");
	JMenuItem ancetre = new JMenuItem ("ajouter un ancetre");
	JMenuItem descendants =new JMenuItem("ajouter un descendant ");
	JMenuItem supr = new JMenuItem("supprimer un membre de la famille");
	JMenuItem cousins = new JMenuItem ("rechercher des cousins");
	JMenuItem personne = new JMenuItem ("rechercher un individus ");
	JMenuItem rechdescendants = new JMenuItem("rechercher un descendant");
	JMenuItem raffraichir = new JMenuItem("rafraichir ?");
	JPanel paneau = new JPanel();
	accueil page;
	 identite debut ;

	 
	 public void paintComponent(Graphics g){

		 for (int k = 0 ; k<debut.enfant.size();k++) 
		 {
		   g.drawLine(debut.posX+50, debut.hauteur*100+150+debut.noeud.getHeight(),debut.enfant.get(k).posX+50,debut.enfant.get(k).hauteur*100+150);
		 	
		}
	 }
	
 public treelayout (String titre,identite a,accueil p) 
 	{

 	 this.page = p;
 	// paneau.setWheelScrollingEnabled(true);
 	// paneau.setVerticalScrollBar(new JScrollBar());
 	// paneau.setHorizontalScrollBar(new JScrollBar());
	 this.setContentPane(paneau);
	 this.setSize(850,1000);
	 this.setLayout(null);
	 this.setLocationRelativeTo(null);
	 this.setTitle("la famille "+titre);
	 
	 actualiser.add(raffraichir);
	 ajouter.add(ancetre);
	 ajouter.add(descendants);
	 rechercher.add(personne);
	 rechercher.add(cousins);
	 rechercher.add(rechdescendants);
	 modif.add(modifier);
	 supprimer.add(supr);
	 
	 menu.add(actualiser);
	 menu.add(ajouter);
	 menu.add(rechercher);
	 menu.add(supprimer);
	 //menu.add(modif); 
	 menu.setBounds(0,0,this.getWidth(),50);
	 debut = a;
	 
	 this.add(menu);
	 this.setVisible(true);
	 
	 raffraichir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				treelayout.this.debut.vider(treelayout.this.paneau);
				treelayout.this.debut.afficher(treelayout.this.paneau);
			}
			});
	 ancetre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						  final JFrame test = new JFrame ();
				    	  final JTextField rnom = new JTextField ();
				    	  final JTextField rprenom = new JTextField ();
				    	  final JTextField rdate = new JTextField ();
				    	  final JTextField rsexe = new JTextField ();
				    	  
				    	  JLabel i = new JLabel ("entrez les informations du nouvel ancêtre : ");
				    	  JLabel n = new JLabel("Nom :");
				    	  JLabel p = new JLabel ("Prenom :");
				    	  JLabel d = new JLabel ("Age : ");
				    	  JLabel s = new JLabel ("Sexe : ");
				    	  final List<JTextField> crite = new ArrayList<JTextField>();
				    	  JButton val = new JButton ("valider");
				    	  val.addActionListener(new ActionListener() {
				    		  public void actionPerformed(ActionEvent event) {
				    			  
				    			  identite premier = new identite (rnom.getText(),rprenom.getText(),rdate.getText(),rsexe.getText());getClass();
				    			  debut.hdecalage(1);
				    			  premier = debut.enfanter(premier);
				    			  premier.descendance.addAll(debut.descendance);		
				    			  
				    			  debut = premier ;
				    			

				    			  treelayout.this.debut.enfant.get(0).parent = treelayout.this.debut;
				    			  
				    			  treelayout.this.debut.enfant.get(0).parentr.setText(treelayout.this.debut.nomr.getText()+" "+treelayout.this.debut.prenomr.getText());
				    			  treelayout.this.debut.enfantr.setText(treelayout.this.debut.enfant.get(0).nomr.getText()+" "+treelayout.this.debut.enfant.get(0).prenomr.getText() );
				    			  
				    			  
				    			  treelayout.this.debut.most();
				    			  treelayout.this.debut.dessin_init(treelayout.this.getWidth()/(treelayout.this.debut.feuille()+1));
				    			  System.out.println(treelayout.this.debut.feuille());
				    			  treelayout.this.debut.dessin_second();
				    			  treelayout.this.debut.dessin_troisiem();
				    			  Boolean taux = false;
				    				int decal = 0;
				    				for (int w = 0 ; w<treelayout.this.debut.mostleft.size();w++)
				    				{if (treelayout.this.debut.mostleft.get(w).posX+treelayout.this.getWidth()/2-treelayout.this.debut.posX-50 < 0) {taux = true;
				    																											decal = Math.max(decal,-treelayout.this.debut.mostleft.get(w).posX+20);}
				    				
				    				}
				    				
				    				if (taux == true) {treelayout.this.debut.decalage(decal);}
				    				else {
				    				treelayout.this.debut.decalage(treelayout.this.getWidth()/2-treelayout.this.debut.posX-50);
				    				}
				    				 //affichage de l'arbre 
				    			  treelayout.this.debut.afficher(paneau);
				    			  //treelayout.this.revalidate();
				    			  //treelayout.this.repaint();
				    			  test.dispose();  
				    			  treelayout.this.raffraichir.doClick();
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
				 treelayout.this.raffraichir.doClick();
					}
					
					});
	 
	 descendants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				final JFrame test = new JFrame ();
		    	  final JTextField rnom = new JTextField ();
		    	  final JTextField rprenom = new JTextField ();
		    	  final JTextField rdate = new JTextField ();
		    	  final JTextField rsexe = new JTextField ();
		    	  final JTextField pnom = new JTextField ();
		    	  final JTextField pprenom = new JTextField ();
		    	  
		    	  JLabel i = new JLabel ("informations concernant le  parent : ");
		    	  
		    	  JLabel pn = new JLabel ("Nom : ");
		    	  JLabel pp = new JLabel ("Prenom :");
		    	  
		    	  JLabel message = new JLabel ("informations concernant l'enfant : ");
		    	  
		    	  JLabel n = new JLabel("Nom :");
		    	  JLabel p = new JLabel ("Prenom :");
		    	  JLabel d = new JLabel ("Age : ");
		    	  JLabel s = new JLabel ("Sexe : ");
		    	  
		    	  
		    	  JButton val = new JButton ("valider");
		    	  val.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent event) {
		    			 

		    			 final identite fils = new identite (rnom.getText(),rprenom.getText(),rdate.getText(),rsexe.getText());
		    			 fils.setVisible(false);
	
				    			  final List<List<identite>> reponse = debut.rechercher_liste(pnom.getText(),pprenom.getText());
				    			  test.dispose();
				    			  
				    			  JButton valider = new JButton ("valider");
					  				 final JDialog name = new JDialog ();
					  				 
					  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
					  				final JList choix = new JList(arbrelist);
					  				for (int r=0 ; r<reponse.size();r++) {
					  					if (reponse.get(r).get(reponse.get(r).size()-1).dater.getText().length() != 0) 
					  					 {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).dater.getText());
					  					 }
					  					else {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText());}
					  					
					  				}
					  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					  				choix.setPreferredSize(new Dimension (150,150));
					  				 choix.setPreferredSize(new Dimension (150,150));
					  				 
					  				 //positionnement dans le name 
					  				 name.setLocationRelativeTo(null);
					  				 name.setSize(400,200);
					  				 name.setTitle("acces a la bonne personne ");
					  				 
					  				 name.add(new JLabel ("choisissez la personne souhaitée :  "),BorderLayout.NORTH);

					  				 name.add(choix);
					  				 name.add(new JScrollPane(choix));
					  				 
					  				 name.add(valider,BorderLayout.SOUTH); 
					  				 name.setVisible(true);
					  				 
					  				 valider.addActionListener(new ActionListener() {
					  					public void actionPerformed(ActionEvent event) {
					  						name.dispose();
					  						debut.ajout(reponse.get(choix.getSelectedIndex()),fils/*.get(reponse.get(choix.getSelectedIndex()).size()-1),fils*/);
					  						fils.setVisible(true);
					  						treelayout.this.raffraichir.doClick();
					  					  
					  					  treelayout.this.debut.most();
						    			  treelayout.this.debut.dessin_init(treelayout.this.getWidth()/(treelayout.this.debut.feuille()+1));
						    			  
						    			  treelayout.this.debut.dessin_second();
						    			  treelayout.this.debut.dessin_troisiem();
						    			  Boolean taux = false;
						    				int decal = 0;
						    				for (int w = 0 ; w<treelayout.this.debut.mostleft.size();w++)
						    				{if (treelayout.this.debut.mostleft.get(w).posX+treelayout.this.getWidth()/2-treelayout.this.debut.posX-50 < 0) {taux = true;
						    																											decal = Math.max(decal,-treelayout.this.debut.mostleft.get(w).posX+20);}
						    				
						    				}
						    				
						    				if (taux == true) {treelayout.this.debut.decalage(decal);}
						    				else {
						    				treelayout.this.debut.decalage(treelayout.this.getWidth()/2-treelayout.this.debut.posX-50);
						    				}
						    				 //affichage de l'arbre 
						    			  treelayout.this.debut.afficher(paneau);
						    			  treelayout.this.revalidate();
						    			  treelayout.this.repaint();
						    			  treelayout.this.raffraichir.doClick();
					  					}
					  				 });
		   			  
				    		
		    			 
		    			 /*if (debut.est_descendant(pnom.getText(),pprenom.getText())) {
		    				
		    			 debut.ajout(pnom.getText(),pprenom.getText(),fils);
		    			 treelayout.this.revalidate();
		    			 treelayout.this.repaint();
		    			 test.dispose();
		    			 
		    			 }
		    			 else {
		    				
		    				 fils.setVisible(false);
		    			 		
		    			 JOptionPane jop = new JOptionPane();			
	  				    	int option = jop.showConfirmDialog(null, "Le parent desingé n'existe pas , voulez vous créer un nouvel ancetre ?", "attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	  				    				
	  				    	if(option == JOptionPane.OK_OPTION){ancetre.doClick();
	  				    										test.dispose();
	  				    	}
		    			 		}*/
		    			 
		    			  
		    		  }
		    	  });
		    	  
		    	//propriété de test 
		    	  test.setSize(400,450);
		    	  test.setTitle("modification ");
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //

		    	  //disposition des différents Fields
		    	  test.add(i);
		    	  i.setBounds(25,20,350,30);
		    	  
		    	  test.add(pn);
		    	  test.add(pnom);
		    	  pn.setBounds (25,50,70,30);
		    	  pnom.setBounds(100,50,200,30);
		    	  
		    	  test.add(pp);
		    	  test.add(pprenom);
		    	  pp.setBounds(25,90,70,30);
		    	  pprenom.setBounds(100,90,200,30);

		    	  test.add(message);
		    	  message.setBounds(25,130,350,30);
		    	  test.add(n);
		    	  test.add(rnom);
		    	  n.setBounds(25,180,70,30);
		    	  rnom.setBounds(100,180,200,30);
		    	  
		    	  
		    
		    	  test.add(p);
		    	  test.add(rprenom);
		    	  p.setBounds(25,220,60,30);
		    	  rprenom.setBounds(100,220,200,30);
		    	  
	
		    	
		    	  test.add(d);
		    	  test.add(rdate);
		    	  d.setBounds(25,260,70,30);
		    	  rdate.setBounds(100,260,200,30);
		    	  
		    	  test.add(s);
		    	  test.add(rsexe);
		    	  s.setBounds(25,300,70,30);
		    	  rsexe.setBounds(100,300,200,30);
		    	  
		    	  
		    	  val.setBounds(05,350,95,50);
		    	  test.add(val);
		    	  
		 test.setVisible(true);   
		 treelayout.this.raffraichir.doClick();
				
			}
			
			});
				
				
 	
	 
	 
	 
	 personne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				final JFrame test = new JFrame ();
		    	  final JTextField pnom = new JTextField ();
		    	  final JTextField pprenom = new JTextField ();
		    	  
		    	  JLabel i = new JLabel ("informations sur la personne recherchée : ");
		    	  
		    	  JLabel pn = new JLabel ("Nom : ");
		    	  JLabel pp = new JLabel ("Prenom :");
		    	  
		    	 
		    	  
		    	  
		    	  JButton val = new JButton ("valider");
		    	  val.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent event) {
		    			  
		    			  final List<List<identite>> reponse = debut.rechercher_liste(pnom.getText(),pprenom.getText());
		    			  test.dispose();
		    			  
		    			  JButton valider = new JButton ("valider");
			  				 final JDialog name = new JDialog ();
			  				 
			  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
			  				final JList choix = new JList(arbrelist);
			  				for (int r=0 ; r<reponse.size();r++) {
			  					if (reponse.get(r).get(reponse.get(r).size()-1).dater.getText().length() != 0) 
			  					 {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).dater.getText());
			  					 }
			  					else {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText());}
			  					
			  				}
			  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  				choix.setPreferredSize(new Dimension (150,150));
			  				 choix.setPreferredSize(new Dimension (150,150));
			  				 
			  				 //positionnement dans le name 
			  				 name.setLocationRelativeTo(null);
			  				 name.setSize(400,200);
			  				 name.setTitle("acces a la bonne personne ");
			  				 
			  				 name.add(new JLabel ("choisissez la personne souhaitée :  "),BorderLayout.NORTH);

			  				 name.add(choix);
			  				 name.add(new JScrollPane(choix));
			  				 
			  				 name.add(valider,BorderLayout.SOUTH); 
			  				 name.setVisible(true);
			  				 
			  				 valider.addActionListener(new ActionListener() {
			  					public void actionPerformed(ActionEvent event) {
			  						System.out.println(reponse.get(choix.getSelectedIndex()).get(reponse.get(choix.getSelectedIndex()).size()-1).posX);
			  						
			  						reponse.get(choix.getSelectedIndex()).get(reponse.get(choix.getSelectedIndex()).size()-1).setVisible(true);
			  						name.dispose();
			  						
			  						
			  					}
			  				 });
   			  
		    		  }
		    	  });
		    	  
		    	//propriété de test 
		    	  test.setSize(400,250);
		    	  test.setTitle("rechercher un individu ");
		    	  test.setResizable(false);
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //

		    	  //disposition des différents Fields
		    	  test.add(i);
		    	  i.setBounds(25,20,350,30);
		    	  
		    	  test.add(pn);
		    	  test.add(pnom);
		    	  pn.setBounds (25,50,70,30);
		    	  pnom.setBounds(100,50,200,30);
		    	  
		    	  test.add(pp);
		    	  test.add(pprenom);
		    	  pp.setBounds(25,90,70,30);
		    	  pprenom.setBounds(100,90,200,30);

		    	  val.setBounds(05,150,95,50);
		    	  test.add(val);
		    	  
		 test.setVisible(true); 
				
				
			}
			
			});
	 
	 cousins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				
				// ouverture de la fenetre initale : 
				
				
				final JFrame test = new JFrame ();
		    	  final JTextField pnom = new JTextField ();
		    	  final JTextField pprenom = new JTextField ();
		    	  final JTextField ordre = new JTextField();
		    	  
		    	  JLabel i = new JLabel ("informations sur la personne recherchée : ");
		    	  
		    	  JLabel pn = new JLabel ("Nom : ");
		    	  JLabel pp = new JLabel ("Prenom :");
		    	  JLabel num = new JLabel ("ordre :");
		    	 
		    	  
		    	  
		    	  JButton val = new JButton ("valider");
		    	  
		    	  //action du premier bouton valider : 
		    	  
		    	  val.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent event) {
		    			  
		    			  //tentative de rechercher du bon individus : 
		    			  
		    			  //System.out.println(debut.enfant.get(0).enfant.get(0).prenomr.getText());
		    			  //System.out.println(debut.enfant.get(1).enfant.get(0).prenomr.getText());
		    			  
		    			  for (int k = 0; k<debut.descendant_degré(2).size(); k++)
		    				  
		    			  {System.out.println(debut.descendant_degré(2).get(k).prenomr.getText());}
		    			  
		    			  final List<List<identite>> reponse = debut.rechercher_liste(pnom.getText(),pprenom.getText());
		    			  test.dispose();
		    			  
		    			  
		    			  //action du secon bouton valider 
		    			  
		    			  JButton valider = new JButton ("valider");
			  				 final JDialog name = new JDialog ();
			  				 
			  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
			  				final JList choix = new JList(arbrelist);
			  				for (int r=0 ; r<reponse.size();r++) {
			  					if (reponse.get(r).get(reponse.get(r).size()-1).dater.getText().length() != 0) 
			  					 {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).dater.getText());
			  					 }
			  					else {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText());}
			  					
			  				}
			  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  				choix.setPreferredSize(new Dimension (150,150));
			  				 choix.setPreferredSize(new Dimension (150,150));
			  				 
			  				 //positionnement dans le name 
			  				 name.setLocationRelativeTo(null);
			  				 name.setSize(400,200);
			  				 name.setTitle("acces a la bonne personne ");
			  				 
			  				 name.add(new JLabel ("choisissez la personne souhaitée :  "),BorderLayout.NORTH);

			  				 name.add(choix);
			  				 name.add(new JScrollPane(choix));
			  				 
			  				 name.add(valider,BorderLayout.SOUTH); 
			  				 name.setVisible(true);
			  				 
			  				 //role du troisiemme bouton valider
			  				 valider.addActionListener(new ActionListener() {
			  					public void actionPerformed(ActionEvent event) {
			  					
			  				
			  						
			  					
		    			  final List<identite> rep = debut.Recherche_cousin(Integer.parseInt(ordre.getText()),reponse.get(choix.getSelectedIndex()));
		    			  
		    			  
		    			  //affichage de la liste des cousins 
		    			  
		    			  JButton valider = new JButton ("valider");
			  				 final JDialog name = new JDialog ();
			  				 
			  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
			  				final JList choix = new JList(arbrelist);
			  				for (int r=0 ; r<rep.size();r++) {
			  					if (rep.get(r).dater.getText().length() != 0) 
			  					 {arbrelist.addElement(rep.get(r).nomr.getText()+" "+rep.get(r).prenomr.getText()+" "+rep.get(r).dater.getText());
			  					 }
			  					else {arbrelist.addElement(rep.get(r).nomr.getText()+" "+rep.get(r).prenomr.getText());}
			  					
			  					
			  					
			  				}
			  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  				choix.setPreferredSize(new Dimension (150,150));
			  				 choix.setPreferredSize(new Dimension (150,150));
			  				 
			  				 //positionnement dans le name 
			  				 name.setLocationRelativeTo(null);
			  				 name.setSize(400,250);
			  				 name.setTitle("acces a la bonne personne ");
			  				 
			  				 name.add(new JLabel ("choisissez la personne souhaitée :  "),BorderLayout.NORTH);

			  				 name.add(choix);
			  				 name.add(new JScrollPane(choix));
			  				 
			  				 name.add(valider,BorderLayout.SOUTH); 
			  				 name.setVisible(true);
			  				 
			  				 valider.addActionListener(new ActionListener() {
			  					public void actionPerformed(ActionEvent event) {
			  						rep.get(choix.getSelectedIndex()).setVisible(true);
			  						name.dispose();
			  						
			  								}
			  				 			});
			  				 
			  					}
			  				 	});
			  				test.dispose();
		    		  }
		    		  
		    	  });
		    	  
		    	//propriété de test 
		    	  test.setSize(400,250);
		    	  test.setTitle("recherche un cousin ");
		    	  test.setResizable(false);
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //

		    	  //disposition des différents Fields
		    	  test.add(i);
		    	  i.setBounds(25,20,350,30);
		    	  
		    	  test.add(pn);
		    	  test.add(pnom);
		    	  pn.setBounds (25,50,70,30);
		    	  pnom.setBounds(100,50,200,30);
		    	  
		    	  test.add(pp);
		    	  test.add(pprenom);
		    	  pp.setBounds(25,90,70,30);
		    	  pprenom.setBounds(100,90,200,30);
		    	  
		    	  test.add(num);
		    	  num.setBounds(25,130,70,30);
		    	  test.add(ordre);
		    	  ordre.setBounds(100,130,200,30);

		    	  val.setBounds(280,160,95,50);
		    	  test.add(val);
		    	  
		 test.setVisible(true); 
				
				
				
			}
			
			});
	 
	 rechdescendants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
// ouverture de la fenetre initale : 
				
				
				final JFrame test = new JFrame ();
		    	  final JTextField pnom = new JTextField ();
		    	  final JTextField pprenom = new JTextField ();
		    	  final JTextField ordre = new JTextField();
		    	  
		    	  JLabel i = new JLabel ("informations sur l'ancetre : ");
		    	  
		    	  JLabel pn = new JLabel ("Nom : ");
		    	  JLabel pp = new JLabel ("Prenom :");
		    	  JLabel num = new JLabel ("ordre :");
		    	 
		    	  
		    	  
		    	  JButton val = new JButton ("valider");
		    	  
		    	  //action du premier bouton valider : 
		    	  
		    	  val.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent event) {
		    			  
		    			  //tentative de rechercher du bon individus : 
		    			  
		    			  //System.out.println(debut.enfant.get(0).enfant.get(0).prenomr.getText());
		    			  //System.out.println(debut.enfant.get(1).enfant.get(0).prenomr.getText());
		    			  
		    			  for (int k = 0; k<debut.descendant_degré(2).size(); k++);
		    			  
		    			  final List<List<identite>> reponse = debut.rechercher_liste(pnom.getText(),pprenom.getText());
		    			  test.dispose();
		    			  
		    			  
		    			  //action du secon bouton valider 
		    			  
		    			  JButton valider = new JButton ("valider");
			  				 final JDialog name = new JDialog ();
			  				 
			  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
			  				final JList choix = new JList(arbrelist);
			  				for (int r=0 ; r<reponse.size();r++) {
			  					if (reponse.get(r).get(reponse.get(r).size()-1).dater.getText().length() != 0) 
			  					 {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).dater.getText());
			  					 }
			  					else {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText());}
			  					
			  				}
			  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  				choix.setPreferredSize(new Dimension (150,150));
			  				 choix.setPreferredSize(new Dimension (150,150));
			  				 
			  				 //positionnement dans le name 
			  				 name.setLocationRelativeTo(null);
			  				 name.setSize(400,200);
			  				 name.setTitle("partir de la bonne personne ");
			  				 
			  				 name.add(new JLabel ("choisissez la personne de depart :   "),BorderLayout.NORTH);

			  				 name.add(choix);
			  				 name.add(new JScrollPane(choix));
			  				 
			  				 name.add(valider,BorderLayout.SOUTH); 
			  				 name.setVisible(true);
			  				 
			  				 //role du troisiemme bouton valider
			  				 valider.addActionListener(new ActionListener() {
			  					public void actionPerformed(ActionEvent event) {
			  					
			  				
			  						
			  					
		    			  final List<identite> rep = reponse.get(choix.getSelectedIndex()).get(reponse.size()-1).descendant_degré(Integer.parseInt(ordre.getText()));
		    			  
		    			  
		    			  //affichage de la liste des cousins 
		    			  
		    			  JButton valider = new JButton ("valider");
			  				 final JDialog name = new JDialog ();
			  				 
			  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
			  				final JList choix = new JList(arbrelist);
			  				for (int r=0 ; r<rep.size();r++) {
			  					if (rep.get(r).dater.getText().length() != 0) 
			  					 {arbrelist.addElement(rep.get(r).nomr.getText()+" "+rep.get(r).prenomr.getText()+" "+rep.get(r).dater.getText());
			  					 }
			  					else {arbrelist.addElement(rep.get(r).nomr.getText()+" "+rep.get(r).prenomr.getText());}
			  					
			  					
			  					
			  				}
			  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  				choix.setPreferredSize(new Dimension (150,150));
			  				 choix.setPreferredSize(new Dimension (150,150));
			  				 
			  				 //positionnement dans le name 
			  				 name.setLocationRelativeTo(null);
			  				 name.setSize(400,250);
			  				 name.setTitle("choisir le descendant :   ");
			  				 
			  				 name.add(new JLabel ("choisissez le descendant qui vous interesse :  "),BorderLayout.NORTH);

			  				 name.add(choix);
			  				 name.add(new JScrollPane(choix));
			  				 
			  				 name.add(valider,BorderLayout.SOUTH); 
			  				 name.setVisible(true);
			  				 
			  				 valider.addActionListener(new ActionListener() {
			  					public void actionPerformed(ActionEvent event) {
			  						rep.get(choix.getSelectedIndex()).setVisible(true);
			  						name.dispose();
			  						
			  								}
			  				 			});
			  				 
			  					}
			  				 	});
			  				test.dispose();
		    		  }
		    		  
		    	  });
		    	  
		    	//propriété de test 
		    	  test.setSize(400,250);
		    	  test.setTitle("recherche d'un descendant ");
		    	  test.setResizable(false);
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //

		    	  //disposition des différents Fields
		    	  test.add(i);
		    	  i.setBounds(25,20,350,30);
		    	  
		    	  test.add(pn);
		    	  test.add(pnom);
		    	  pn.setBounds (25,50,70,30);
		    	  pnom.setBounds(100,50,200,30);
		    	  
		    	  test.add(pp);
		    	  test.add(pprenom);
		    	  pp.setBounds(25,90,70,30);
		    	  pprenom.setBounds(100,90,200,30);
		    	  
		    	  test.add(num);
		    	  num.setBounds(25,130,70,30);
		    	  test.add(ordre);
		    	  ordre.setBounds(100,130,200,30);

		    	  val.setBounds(280,160,95,50);
		    	  test.add(val);
		    	  
		 test.setVisible(true); 
				
				
				
			}
			
	
			
			});
	 
	
	 
	 
	/* modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				final JFrame test = new JFrame ();
		    	  final JTextField rnom = new JTextField ();
		    	  final JTextField rprenom = new JTextField ();
		    	  final JTextField rdate = new JTextField ();
		    	  final JTextField rsexe = new JTextField ();
		    	  final JTextField pnom = new JTextField ();
		    	  final JTextField pprenom = new JTextField ();
		    	  
		    	  JLabel i = new JLabel ("informations concernant le  parent : ");
		    	  
		    	  JLabel pn = new JLabel ("Nom : ");
		    	  JLabel pp = new JLabel ("Prenom :");
		    	  
		    	  JLabel message = new JLabel ("informations concernant l'enfant : ");
		    	  
		    	  JLabel n = new JLabel("Nom :");
		    	  JLabel p = new JLabel ("Prenom :");
		    	  JLabel d = new JLabel ("Age : ");
		    	  JLabel s = new JLabel ("Sexe : ");
		    	  
		    	  
		    	  JButton val = new JButton ("valider");
		    	  val.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent event) {
		    			 

		    			 final identite fils = new identite (rnom.getText(),rprenom.getText(),rdate.getText(),rsexe.getText());
		    			 fils.setVisible(false);
	
				    			  final List<List<identite>> reponse = debut.rechercher_liste(pnom.getText(),pprenom.getText());
				    			  test.dispose();
				    			  
				    			  JButton valider = new JButton ("valider");
					  				 final JDialog name = new JDialog ();
					  				 
					  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
					  				final JList choix = new JList(arbrelist);
					  				for (int r=0 ; r<reponse.size();r++) {
					  					if (reponse.get(r).get(reponse.get(r).size()-1).dater.getText().length() != 0) 
					  					 {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).dater.getText());
					  					 }
					  					else {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText());}
					  					
					  				}
					  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					  				choix.setPreferredSize(new Dimension (150,150));
					  				 choix.setPreferredSize(new Dimension (150,150));
					  				 
					  				 //positionnement dans le name 
					  				 name.setLocationRelativeTo(null);
					  				 name.setSize(400,200);
					  				 name.setTitle("acces a la bonne personne ");
					  				 
					  				 name.add(new JLabel ("choisissez la personne souhaitée :  "),BorderLayout.NORTH);

					  				 name.add(choix);
					  				 name.add(new JScrollPane(choix));
					  				 
					  				 name.add(valider,BorderLayout.SOUTH); 
					  				 name.setVisible(true);
					  				 
					  				 valider.addActionListener(new ActionListener() {
					  					public void actionPerformed(ActionEvent event) {
					  						name.dispose();
					  						identite ancien = reponse.get(choix.getSelectedIndex()).get(reponse.get(choix.getSelectedIndex()).size()-1);
					  						
					  						if (debut == ancien )
					  						{
					  						fils.enfant.addAll(ancien.enfant);
					  						ancien.descendance.remove(ancien);
					  						fils.descendance.addAll(ancien.descendance);
					  						fils.enfantr.setText(ancien.enfantr.getText());
					  						
					  						debut = fils;
					  						fils.setVisible(true);}
					  						
					  						else {
					  						debut.modifier(ancien, fils);
					  						fils.setVisible(true);
					  						}
					  						
					  						  treelayout.this.debut.most();
							    			  treelayout.this.debut.dessin_init(treelayout.this.getWidth()/(treelayout.this.debut.feuille()+1));
							    			  treelayout.this.debut.dessin_second();
							    			  treelayout.this.debut.dessin_troisiem();
							    			  Boolean taux = false;
							    				int decal = 0;
							    				for (int w = 0 ; w<treelayout.this.debut.mostleft.size();w++)
							    				{if (treelayout.this.debut.mostleft.get(w).posX+treelayout.this.getWidth()/2-treelayout.this.debut.posX-50 < 0) {taux = true;
							    																											decal = Math.max(decal,-treelayout.this.debut.mostleft.get(w).posX+20);}
							    				
							    				}
							    				
							    				if (taux == true) {treelayout.this.debut.decalage(decal);}
							    				else {
							    				treelayout.this.debut.decalage(treelayout.this.getWidth()/2-treelayout.this.debut.posX-50);}
							    				 //affichage de l'arbre 
							    			  treelayout.this.debut.afficher(paneau);
							    			  
							    			  treelayout.this.revalidate();
							    			  treelayout.this.repaint();
							    			  treelayout.this.raffraichir.doClick();
					  					}
					  				 });

		    		  }
		    	  });
		    	  
		    	//propriété de test 
		    	  test.setSize(400,450);
		    	  test.setTitle("modification ");
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //

		    	  //disposition des différents Fields
		    	  test.add(i);
		    	  i.setBounds(25,20,350,30);
		    	  
		    	  test.add(pn);
		    	  test.add(pnom);
		    	  pn.setBounds (25,50,70,30);
		    	  pnom.setBounds(100,50,200,30);
		    	  
		    	  test.add(pp);
		    	  test.add(pprenom);
		    	  pp.setBounds(25,90,70,30);
		    	  pprenom.setBounds(100,90,200,30);

		    	  test.add(message);
		    	  message.setBounds(25,130,350,30);
		    	  test.add(n);
		    	  test.add(rnom);
		    	  n.setBounds(25,180,70,30);
		    	  rnom.setBounds(100,180,200,30);
		    	  
		    	  
		    
		    	  test.add(p);
		    	  test.add(rprenom);
		    	  p.setBounds(25,220,60,30);
		    	  rprenom.setBounds(100,220,200,30);
		    	  
	
		    	
		    	  test.add(d);
		    	  test.add(rdate);
		    	  d.setBounds(25,260,70,30);
		    	  rdate.setBounds(100,260,200,30);
		    	  
		    	  test.add(s);
		    	  test.add(rsexe);
		    	  s.setBounds(25,300,70,30);
		    	  rsexe.setBounds(100,300,200,30);
		    	  
		    	  
		    	  val.setBounds(05,350,95,50);
		    	  test.add(val);
		    	  
		    	  test.setVisible(true);
				
				
			}
			
			});*/
	 
	 supr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				final JFrame test = new JFrame ();
		    	  final JTextField pnom = new JTextField ();
		    	  final JTextField pprenom = new JTextField ();
		    	  
		    	  JLabel i = new JLabel ("informations sur la personne recherchée : ");
		    	  
		    	  JLabel pn = new JLabel ("Nom : ");
		    	  JLabel pp = new JLabel ("Prenom :");
		    	  
		    	 
		    	  
		    	  
		    	  JButton val = new JButton ("valider");
		    	  val.addActionListener(new ActionListener() {
		    		  public void actionPerformed(ActionEvent event) {
		    			  
		    			  final List<List<identite>> reponse = debut.rechercher_liste(pnom.getText(),pprenom.getText());
		    			  test.dispose();
		    			  
		    			  JButton valider = new JButton ("valider");
			  				 final JDialog name = new JDialog ();
			  				 
			  				DefaultListModel<String> arbrelist = new DefaultListModel<>();
			  				final JList choix = new JList(arbrelist);
			  				for (int r=0 ; r<reponse.size();r++) {
			  					if (reponse.get(r).get(reponse.get(r).size()-1).dater.getText().length() != 0) 
			  					 {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).dater.getText());
			  					 }
			  					else {arbrelist.addElement(reponse.get(r).get(reponse.get(r).size()-1).nomr.getText()+" "+reponse.get(r).get(reponse.get(r).size()-1).prenomr.getText());}
			  					
			  				}
			  				choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			  				choix.setPreferredSize(new Dimension (150,150));
			  				 choix.setPreferredSize(new Dimension (150,150));
			  				 
			  				 //positionnement dans le name 
			  				 name.setLocationRelativeTo(null);
			  				 name.setSize(400,200);
			  				 name.setTitle("acces a la bonne personne ");
			  				 
			  				 name.add(new JLabel ("choisissez la personne à supprimer :  "),BorderLayout.NORTH);

			  				 name.add(choix);
			  				 name.add(new JScrollPane(choix));
			  				 
			  				 name.add(valider,BorderLayout.SOUTH); 
			  				 name.setVisible(true);
			  				 
			  				 valider.addActionListener(new ActionListener() {
			  					public void actionPerformed(ActionEvent event) {
			  						System.out.println(reponse.get(choix.getSelectedIndex()).get(reponse.get(choix.getSelectedIndex()).size()-1).posX);
			  						
			  						if (!reponse.get(choix.getSelectedIndex()).get(reponse.get(choix.getSelectedIndex()).size()-1).equals(treelayout.this.debut)) {
			  						
			  						reponse.get(choix.getSelectedIndex()).get(reponse.get(choix.getSelectedIndex()).size()-1).vider(treelayout.this.paneau);
			  						treelayout.this.debut.supprimer(reponse.get(choix.getSelectedIndex()).get(reponse.get(choix.getSelectedIndex()).size()-1));
			  						name.dispose();
			  						treelayout.this.debut.most();
					    			  treelayout.this.debut.dessin_init(treelayout.this.getWidth()/(treelayout.this.debut.feuille()+1));
					    			  treelayout.this.debut.dessin_second();
					    			  treelayout.this.debut.dessin_troisiem();
					    			  
					    			  Boolean taux = false;
					    				int decal = 0;
					    				for (int w = 0 ; w<treelayout.this.debut.mostleft.size();w++)
					    				{if (treelayout.this.debut.mostleft.get(w).posX+treelayout.this.getWidth()/2-treelayout.this.debut.posX-50 < 0) {taux = true;
					    																											decal = Math.max(decal,-treelayout.this.debut.mostleft.get(w).posX+20);}
					    				
					    				}
					    				
					    				if (taux == true) {treelayout.this.debut.decalage(decal);}
					    				else {
					    				treelayout.this.debut.decalage(treelayout.this.getWidth()/2-treelayout.this.debut.posX-50);
					    			
					    				}
					    				 //affichage de l'arbre 
					    			  treelayout.this.debut.afficher(paneau);
					    			  treelayout.this.revalidate();
					    			  treelayout.this.repaint();
					    			  treelayout.this.raffraichir.doClick();
			  						}
			  						
			  						else {JOptionPane jop = new JOptionPane();			
			  				    	int option = jop.showConfirmDialog(null, "Vous etes sur le point de supprimer un arbre , en etes vous sur ? ", "attention!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    				
			  				    	if(option == JOptionPane.OK_OPTION){
			  				    		
			  				    	
			  				    	 
			  				    	 page.fond.arbrelist.remove(choix.getSelectedIndex());
			  				    	 page.fond.arbres.remove(choix.getSelectedIndex());
			  				    	 page.fond.revalidate();
			  				    	 page.fond.repaint();
			  				    	 page.fond.revalidate();
			  				    	 page.fond.repaint();
			  				    	 treelayout.this.dispose();
			  				    	 name.dispose();}
			  				    	
			  						}
			  						
			  					}
			  				 });
			  				    	
		    		  }
	  				 });	
			  						
			  
		    		 
		    	  
		    	//propriété de test 
		    	  test.setSize(400,250);
		    	  test.setTitle("rechercher un individu ");
		    	  test.setResizable(false);
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //

		    	  //disposition des différents Fields
		    	  test.add(i);
		    	  i.setBounds(25,20,350,30);
		    	  
		    	  test.add(pn);
		    	  test.add(pnom);
		    	  pn.setBounds (25,50,70,30);
		    	  pnom.setBounds(100,50,200,30);
		    	  
		    	  test.add(pp);
		    	  test.add(pprenom);
		    	  pp.setBounds(25,90,70,30);
		    	  pprenom.setBounds(100,90,200,30);

		    	  val.setBounds(05,150,95,50);
		    	  test.add(val);
		    	  
		 test.setVisible(true); 
		    		  }
		    	  });
				
	
		
		
			  				 
			  				 
	 
	 paneau.setBackground(Color.white);
	 this.debut.most();
	 this.debut.dessin_init(this.getWidth()/(this.debut.feuille()+1));
	this.debut.dessin_second();
	this.debut.dessin_troisiem();

 Boolean taux = false;
		int decal = 0;
		for (int w = 0 ; w<treelayout.this.debut.mostleft.size();w++)
		{if (treelayout.this.debut.mostleft.get(w).posX+treelayout.this.getWidth()/2-treelayout.this.debut.posX-50 < 0) {taux = true;
																									decal = Math.max(decal,-treelayout.this.debut.mostleft.get(w).posX+20);}
		
		}
		
		if (taux == true) {treelayout.this.debut.decalage(decal);}
		else {
		treelayout.this.debut.decalage(treelayout.this.getWidth()/2-treelayout.this.debut.posX-50);
	
		}
	 //affichage de l'arbre 
	
	
	this.debut.afficher(paneau);
	
	treelayout.this.raffraichir.doClick();
	
 	}
 
 
	 }
 	
 
		    	  



