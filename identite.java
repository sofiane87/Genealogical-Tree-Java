import java.awt.BorderLayout;
import java.awt.Color;    
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class identite extends JFrame {
		
// Information relatives à la personne et boutons associés 
	
		JButton prec = new JButton ("<");
		JButton next =new JButton(">");
		JLabel nom = new JLabel ("Nom : ");
		JLabel prenom = new JLabel ("Prénom : ");
		JLabel date = new JLabel ("age : ");
		JLabel sexe = new JLabel ("sexe : ");
		JLabel nomr = new JLabel ("");
		JLabel prenomr = new JLabel ("");
		JLabel dater = new JLabel ("");
		JLabel sexer = new JLabel ("");
		JLabel enfantr= new JLabel("");
		JLabel parentr= new JLabel ();
		JMenuBar mb = new JMenuBar();
		
		JMenu supr = new JMenu("supprimer");
		JMenu add  = new JMenu("ajouter");
		JMenu modif = new JMenu ("modifier");
		JLabel descendants = new JLabel ("enfants : ");
		JLabel Parents = new JLabel ("Parents : ");
		JMenuItem photo = new JMenuItem ("ajouter des photos");
		JMenuItem ajouter = new JMenuItem("ajouter un critere");
		JMenuItem modifier = new JMenuItem ("modifier profil");
		JPanel blanc = new JPanel();
		JMenuItem Psupprimer = new JMenuItem ("suprimer photo ");
		JMenuItem Csupprimer = new JMenuItem ("suprimer critere ");
		String mot ;
		int i = 0;
		int j = 0;
			

		 diapo pan = new diapo();
		 String profil = "src\\defaut.jpg";
		List<duo> crit = new ArrayList<duo> ();
		List<JLabel> icrit = new ArrayList<JLabel> ();
		
		//informations relative à la structure d'arbre 
		
		List<identite> enfant = new ArrayList<identite> ();
		List<identite> descendance = new ArrayList<identite> ();
		identite parent;
		
		//définition du contour de l'arbre 
		List<identite> mostleft = new ArrayList<identite> ();
		List<identite> mostright = new ArrayList<identite> ();
		
		//definition hauteur et profondeur 
		int hauteur = 0;
		
		//JButton noeud = new JButton();
		Bouton noeud = new Bouton(this.prenomr.getText(),profil);
		int posX = 0 ;
		static int saut = 0;


		{descendance.add(this);}
		 
	

		
	
	public identite() {
	
		/*for (int x=0 ;x<enfant.size();x++)
		{
			enfantr.setText(enfantr.getText()+enfant.get(x).nomr.getText()+" "+enfant.get(x).prenomr.getText()+" , ");
		}*/
		
		
		pan.setPreferredSize(new Dimension(200,300));
		//autre.setPreferredSize(new Dimension(40,40));
		//photo.setPreferredSize(new Dimension(80,40));
		//modifier.setPreferredSize(new Dimension(80,40));
		pan.setPreferredSize(new Dimension(400,400));
		blanc.setBackground(Color.WHITE);
		this.setContentPane(blanc);
		this.setLayout(null);
		this.setSize(600,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		//action du bouton next 
		
		next.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        //Via cette instruction, on passe au prochain conteneur de la pile
		        pan.cl.next(pan);
		      }
		    });
		
		//action du bouton prec
		prec.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        //Via cette instruction, on passe au prochain conteneur de la pile
		        pan.cl.previous(pan);
		      }
		    });
		
		//action du bouton photo
		
		photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				//choix du nom de l'image
				JButton valider = new JButton ("valider");
				 final JDialog name = new JDialog ();
				 final JTextField choix = new JTextField ();
				 name.setLocationRelativeTo(null);		 
				 name.setLayout(new GridLayout(3,1));
				 name.setSize(300,150);
				 name.setTitle("Nom de la Photo");
				 name.add(new JLabel ("entrez le nom de la photo : "));
				 choix.setPreferredSize(new Dimension (200,50));
				 name.add(choix);
				 name.add(valider); 
				 name.setVisible(true);
				 
					valider.addActionListener(new ActionListener(){
					      public void actionPerformed(ActionEvent event){
					    	  mot = choix.getText();
					    	  name.dispose();
					    	  
								pan.liste.add(mot);
								
								//choix de l'image
								addimage a = new addimage();
								if (!(a.fichier.equals("")))
									profil = a.fichier;
									pan.ajouter(a.fichier);
									//modification de la liste (verification)
									System.out.println(pan.liste);
									
					      }
					    });

		
				

						
			}
			
			
		});
		
		//action du bouton ajouter 
		
		ajouter.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		       
		    	final JFrame fen = new JFrame ();
		    	JLabel titre = new JLabel ("intitulé");
			    JLabel reponse = new JLabel ("réponse");
			    final JTextField a = new JTextField ();
			    final JTextField b = new JTextField ();
			    JButton valider = new JButton ("valider");
		       
		       fen.setSize(500,250);
		       fen.setLocationRelativeTo(null);
		       fen.setTitle("Ajout de critere");
		       fen.setLayout(null);
		       fen.add(a);
		       fen.add(b);
		       fen.add(titre);
		       fen.add(reponse);
		       fen.setResizable(false);
		       
		        titre.setBounds(10, 20, 100, 50);
		        a.setBounds(90,30,150,30);
		        reponse.setBounds(10, 90, 100, 50);
		        b.setBounds(90,100,325,30);
		        fen.add(valider);
		        valider.setBounds(350,160,130,30);
		        
		        valider.addActionListener(new ActionListener(){
				      public void actionPerformed(ActionEvent event){
				    	  fen.dispose();
				    	  identite.this.ajouter(new duo (a.getText(),b.getText()));
				    	  identite.this.revalidate();
				    	  identite.this.repaint();
					        
					      }
					    });
		        fen.setVisible(true);
		       
		       
		       
		      }
		    });
		
		//fonction du bouton modifier 
		
		modifier.addActionListener(new ActionListener(){
				 
				public void actionPerformed(ActionEvent event){
		    	  final JFrame test = new JFrame ();
		    	  final JTextField rnom = new JTextField (nomr.getText());
		    	  final JTextField rprenom = new JTextField (prenomr.getText());
		    	  final JTextField rdate = new JTextField (dater.getText());
		    	  final JTextField rsexe = new JTextField (sexer.getText());
		    	  JLabel n = new JLabel("Nom :");
		    	  JLabel p = new JLabel ("Prenom :");
		    	  JLabel d = new JLabel ("Age : ");
		    	  JLabel s = new JLabel ("Sexe : ");
		    	  final List<JTextField> crite = new ArrayList<JTextField>();
		    	  JButton val = new JButton ("valider");
		    	  
		    	  
		    	  
		    	 
		    	  //propriété de test 
		    	  test.setSize(400,300+crit.size()*50);
		    	  test.setTitle("modification ");
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //
		    	  
		    	  //disposition des différents Fields
		    	  
		
		    	  test.add(n);
		    	  test.add(rnom);
		    	  n.setBounds(25,20,70,30);
		    	  rnom.setBounds(100,20,200,30);
		    	  
		    	  
		    
		    	  test.add(p);
		    	  test.add(rprenom);
		    	  p.setBounds(25,60,60,30);
		    	  rprenom.setBounds(100,60,200,30);
		    	  
	
		    	
		    	  test.add(d);
		    	  test.add(rdate);
		    	  d.setBounds(25,100,70,30);
		    	  rdate.setBounds(100,100,200,30);
		    	  
		    	  test.add(s);
		    	  test.add(rsexe);
		    	  s.setBounds(25,140,70,30);
		    	  rsexe.setBounds(100,140,200,30);
		    	  
		    	  for (int k = 0 ; k <crit.size();k++) 
		    	  {
		    		JLabel a = new JLabel (crit.get(k).nom);
		    		JTextField b = new JTextField (crit.get(k).prenom);
		    		crite.add(b);
		    		test.add(a);
		    		test.add(crite.get(k));
		    		a.setBounds(25,180+k*(40),70,30);
		    		crite.get(k).setBounds(100,180+k*(40),200,30);  
		    	  }
		    	  
		    	  val.setBounds(05,200+(crit.size())*50,95,50);
		    	  test.add(val);
		    	  
		    	  val.addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent event){ 
						  
						 
						  test.dispose();
						  nomr.setText(rnom.getText());
						  prenomr.setText(rprenom.getText());
						  dater.setText(rdate.getText());
						  sexer.setText(rsexe.getText());
						  noeud.setText(rprenom.getText());
						  for (int w = 0 ; w <crit.size();w++)
						  {
							  String save = crit.get(w).nom;
							  identite.this.supprimer(save);
							  identite.this.ajouter(new duo (save,crite.get(w).getText()));
						  }
						  identite.this.repaint();
						  identite.this.revalidate();
						  

					  }
				    });

		    	  test.setVisible(true);
		    	  
				      }
				    });
		    	  
		    	  
		    	  
			  
		
		
		//action du bouton supprimer photo
		
		 Psupprimer.addActionListener(new ActionListener() {
	  			public void actionPerformed(ActionEvent event) {
	  			pan.supprimer();
	  			

	  						
	  			}
	  			
	
	  			
	  			
	  		});
	    	  
	    	  
		 
		 //action du bouton supprimer Crietere 
		 
	    	  Csupprimer.addActionListener(new ActionListener() {
		  			public void actionPerformed(ActionEvent event) {
		  			
		  				 JButton valider = new JButton ("valider");
		  				 final JDialog name = new JDialog ();
		  				 DefaultListModel<String> imagelist = new DefaultListModel<>();
		  				 for (int r=0 ; r<crit.size();r++) {
		  					 imagelist.addElement(crit.get(r).nom);
		  				 }
		  				 
		  				 //reglage de la JLISTE
		  				 
		  				
		  				 final JList choix = new JList<>(imagelist);
		  				 choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		  				 choix.setPreferredSize(new Dimension (150,150));
		  				 
		  				 //positionnement dans le name 
		  				 name.setLocationRelativeTo(null);
		  				 name.setSize(400,200);
		  				 name.setTitle("suppression de critere");
		  				 
		  				 name.add(new JLabel ("choisissez la: "),BorderLayout.NORTH);

		  				 name.add(choix);
		  				 name.add(new JScrollPane(choix));
		  				 
		  				 name.add(valider,BorderLayout.SOUTH); 
		  				 name.setVisible(true);
		  				 valider.addActionListener(new ActionListener(){
		  				      public void actionPerformed(ActionEvent event){
		  				    	
		  				    	 
		  				    	 name.dispose();
		  				    	 identite.this.supprimer(crit.get(choix.getSelectedIndex()).nom);
		  				    	 
		  				 		 
		  				      }
		  				    });
		  						
		  			}
		  			
		
		  			
		  			
		  		});
		
		//tes de l'action du bouton supprimer
		
		
		
		
		pan.setBounds(100,50,400,350);
		this.add(pan);
		
		
		prec.setBounds(25,200,50,50);
		this.add(prec);
		
		next.setBounds(525,200,50,50);
		this.add(next);
		
		nom.setBounds(25,425,75,50);
		this.add(nom);
		
		nomr.setBounds(100,425,75,50);
		this.add(nomr);
	
		
		prenom.setBounds(300,425,75,50);
		this.add(prenom);
		prenomr.setBounds(375,425,75,50);
		this.add(prenomr);
		
		date.setBounds(25,475,75,50);
		this.add(date);
		
		dater.setBounds(100,475,75,50);
		this.add(dater);
		
		
		sexe.setBounds(300,475,75,50);
		this.add(sexe);
		
		sexer.setBounds(375,475,75,50);
		this.add(sexer);
		
		descendants.setBounds(25,525,75,50);
		
		this.add(descendants);
		
		enfantr.setBounds(100,475,75,150);
		this.add(enfantr);
		
		Parents.setBounds(300,525,75,50);
		this.add(Parents);
		
		parentr.setBounds(375,475,75,150);
		this.add(parentr);
		
		//ajouter.setBounds(25, 700, 150, 50);
		add.add(ajouter);
		photo.setBounds( 215, 700, 150,50);
		add.add(photo);
		modifier.setBounds(400, 700, 150, 50);
		modif.add(modifier);
		
		//this.add(Psupprimer);
		//this.add(Csupprimer);
		
		mb.setSize(600,50);

		supr.add(Psupprimer);
		supr.add(Csupprimer);
		mb.add(supr);
		mb.add(add);
		mb.add(modif);
		this.setJMenuBar(mb);
	
		
		//Psupprimer.setBounds(5, 5, 150, 40);
		//Csupprimer.setBounds(170, 5, 150, 40);
		

		this.setVisible(true);
	}
	
	
	public  identite (String n , String p , String a, String s  ) {
		
		nomr.setText(n);
		prenomr.setText(p);
		dater.setText(a);
		sexer.setText(s);

		/*for (int x=0 ;x<enfant.size();x++)
		{
			enfantr.setText(enfantr.getText()+enfant.get(x).nomr.getText()+" "+enfant.get(x).prenomr.getText()+" , ");
		}*/
		
		pan.setPreferredSize(new Dimension(200,300));
		//autre.setPreferredSize(new Dimension(40,40));
		//photo.setPreferredSize(new Dimension(80,40));
		//modifier.setPreferredSize(new Dimension(80,40));
		pan.setPreferredSize(new Dimension(400,400));
		blanc.setBackground(Color.WHITE);
		this.setContentPane(blanc);
		this.setLayout(null);
		this.setSize(600,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		//action du bouton next 
		
		next.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        //Via cette instruction, on passe au prochain conteneur de la pile
		        pan.cl.next(pan);
		      }
		    });
		
		//action du bouton prec
		prec.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        //Via cette instruction, on passe au prochain conteneur de la pile
		        pan.cl.previous(pan);
		      }
		    });
		
		//action du bouton photo
		
		photo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				//choix du nom de l'image
				JButton valider = new JButton ("valider");
				 final JDialog name = new JDialog ();
				 final JTextField choix = new JTextField ();
				 name.setLocationRelativeTo(null);		 
				 name.setLayout(new GridLayout(3,1));
				 name.setSize(300,150);
				 name.setTitle("Nom de la Photo");
				 name.add(new JLabel ("entrez le nom de la photo : "));
				 choix.setPreferredSize(new Dimension (200,50));
				 name.add(choix);
				 name.add(valider); 
				 name.setVisible(true);
				 
					valider.addActionListener(new ActionListener(){
					      public void actionPerformed(ActionEvent event){
					    	  mot = choix.getText();
					    	  name.dispose();
					    	  
								pan.liste.add(mot);
								
								//choix de l'image
								addimage a = new addimage();
								if (!(a.fichier.equals("")))
									pan.ajouter(a.fichier);
									profil = a.fichier;
									
									//modification de la liste (verification)
									System.out.println(pan.liste);
									
					      }
					    });

		
				

						
			}
			
			
		});
		
		//action du bouton ajouter 
		
		ajouter.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		       
		    	final JFrame fen = new JFrame ();
		    	JLabel titre = new JLabel ("intitulé");
			    JLabel reponse = new JLabel ("réponse");
			    final JTextField a = new JTextField ();
			    final JTextField b = new JTextField ();
			    JButton valider = new JButton ("valider");
		       
		       fen.setSize(500,250);
		       fen.setLocationRelativeTo(null);
		       fen.setTitle("Ajout de critere");
		       fen.setLayout(null);
		       fen.add(a);
		       fen.add(b);
		       fen.add(titre);
		       fen.add(reponse);
		       fen.setResizable(false);
		       
		        titre.setBounds(10, 20, 100, 50);
		        a.setBounds(90,30,150,30);
		        reponse.setBounds(10, 90, 100, 50);
		        b.setBounds(90,100,325,30);
		        fen.add(valider);
		        valider.setBounds(350,160,130,30);
		        
		        valider.addActionListener(new ActionListener(){
				      public void actionPerformed(ActionEvent event){
				    	  fen.dispose();
				    	  identite.this.ajouter(new duo (a.getText(),b.getText()));
				    	  identite.this.revalidate();
				    	  identite.this.repaint();
					        
					      }
					    });
		        fen.setVisible(true);
		       
		       
		       
		      }
		    });
		
		//fonction du bouton modifier 
		
		modifier.addActionListener(new ActionListener(){
				 
				public void actionPerformed(ActionEvent event){
		    	  final JFrame test = new JFrame ();
		    	  final JTextField rnom = new JTextField (nomr.getText());
		    	  final JTextField rprenom = new JTextField (prenomr.getText());
		    	  final JTextField rdate = new JTextField (dater.getText());
		    	  final JTextField rsexe = new JTextField (sexer.getText());
		    	  JLabel n = new JLabel("Nom :");
		    	  JLabel p = new JLabel ("Prenom :");
		    	  JLabel d = new JLabel ("Age : ");
		    	  JLabel s = new JLabel ("Sexe : ");
		    	  final List<JTextField> crite = new ArrayList<JTextField>();
		    	  JButton val = new JButton ("valider");
		    	  
		    	  
		    	  
		    	 
		    	  //propriété de test 
		    	  test.setSize(400,300+crit.size()*50);
		    	  test.setTitle("modification ");
		    	  test.setLayout(null);
		    	  test.setLocationRelativeTo(null);
		    	  //
		    	  
		    	  //disposition des différents Fields
		    	  
		
		    	  test.add(n);
		    	  test.add(rnom);
		    	  n.setBounds(25,20,70,30);
		    	  rnom.setBounds(100,20,200,30);
		    	  
		    	  
		    
		    	  test.add(p);
		    	  test.add(rprenom);
		    	  p.setBounds(25,60,60,30);
		    	  rprenom.setBounds(100,60,200,30);
		    	  
	
		    	
		    	  test.add(d);
		    	  test.add(rdate);
		    	  d.setBounds(25,100,70,30);
		    	  rdate.setBounds(100,100,200,30);
		    	  
		    	  test.add(s);
		    	  test.add(rsexe);
		    	  s.setBounds(25,140,70,30);
		    	  rsexe.setBounds(100,140,200,30);
		    	  
		    	  for (int k = 0 ; k <crit.size();k++) 
		    	  {
		    		JLabel a = new JLabel (crit.get(k).nom);
		    		JTextField b = new JTextField (crit.get(k).prenom);
		    		crite.add(b);
		    		test.add(a);
		    		test.add(crite.get(k));
		    		a.setBounds(25,180+k*(40),70,30);
		    		crite.get(k).setBounds(100,180+k*(40),200,30);  
		    	  }
		    	  
		    	  val.setBounds(05,200+(crit.size())*50,95,50);
		    	  test.add(val);
		    	  
		    	  val.addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent event){ 
						  
						 
						  test.dispose();
						  nomr.setText(rnom.getText());
						  prenomr.setText(rprenom.getText());
						  dater.setText(rdate.getText());
						  sexer.setText(rsexe.getText());
						  for (int w = 0 ; w <crit.size();w++)
						  {
							  String save = crit.get(w).nom;
							  identite.this.supprimer(save);
							  identite.this.ajouter(new duo (save,crite.get(w).getText()));
						  }
						  identite.this.repaint();
						  identite.this.revalidate();
						  

					  }
				    });

		    	  test.setVisible(true);
		    	  
				      }
				    });
		    	  
		    	  
		    	  
			  
		
		
		//action du bouton supprimer photo
		
		 Psupprimer.addActionListener(new ActionListener() {
	  			public void actionPerformed(ActionEvent event) {
	  			pan.supprimer();
	  			

	  						
	  			}
	  			
	
	  			
	  			
	  		});
	    	  
	    	  
		 
		 //action du bouton supprimer Crietere 
		 
	    	  Csupprimer.addActionListener(new ActionListener() {
		  			public void actionPerformed(ActionEvent event) {
		  			
		  				 JButton valider = new JButton ("valider");
		  				 final JDialog name = new JDialog ();
		  				 DefaultListModel<String> imagelist = new DefaultListModel<>();
		  				 for (int r=0 ; r<crit.size();r++) {
		  					 imagelist.addElement(crit.get(r).nom);
		  				 }
		  				 
		  				 //reglage de la JLISTE
		  				 
		  				
		  				 final JList choix = new JList<>(imagelist);
		  				 choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		  				 choix.setPreferredSize(new Dimension (150,150));
		  				 
		  				 //positionnement dans le name 
		  				 name.setLocationRelativeTo(null);
		  				 name.setSize(400,200);
		  				 name.setTitle("suppression de critere");
		  				 
		  				 name.add(new JLabel ("choisissez la: "),BorderLayout.NORTH);

		  				 name.add(choix);
		  				 name.add(new JScrollPane(choix));
		  				 
		  				 name.add(valider,BorderLayout.SOUTH); 
		  				 name.setVisible(true);
		  				 valider.addActionListener(new ActionListener(){
		  				      public void actionPerformed(ActionEvent event){
		  				    	
		  				    	 
		  				    	 name.dispose();
		  				    	 identite.this.supprimer(crit.get(choix.getSelectedIndex()).nom);
		  				    	 
		  				 		 
		  				      }
		  				    });
		  						
		  			}
		  			
		
		  			
		  			
		  		});
		
		//tes de l'action du bouton supprimer
		
		
		
		
		pan.setBounds(100,50,400,350);
		this.add(pan);
		
		
		prec.setBounds(25,200,50,50);
		this.add(prec);
		
		next.setBounds(525,200,50,50);
		this.add(next);
		
		nom.setBounds(25,425,75,50);
		this.add(nom);
		
		nomr.setBounds(100,425,75,50);
		this.add(nomr);
	
		
		prenom.setBounds(300,425,75,50);
		this.add(prenom);
		prenomr.setBounds(375,425,75,50);
		this.add(prenomr);
		
		date.setBounds(25,475,75,50);
		this.add(date);
		
		dater.setBounds(100,475,75,50);
		this.add(dater);
		
		
		sexe.setBounds(300,475,75,50);
		this.add(sexe);
		
		sexer.setBounds(375,475,75,50);
		this.add(sexer);
		
		descendants.setBounds(25,525,75,50);
		
		this.add(descendants);
		
		enfantr.setBounds(100,475,75,150);
		this.add(enfantr);
		
		Parents.setBounds(300,525,75,50);
		this.add(Parents);
		
		parentr.setBounds(375,475,75,150);
		this.add(parentr);
		
		//ajouter.setBounds(25, 700, 150, 50);
		add.add(ajouter);
		photo.setBounds( 215, 700, 150,50);
		add.add(photo);
		modifier.setBounds(400, 700, 150, 50);
		modif.add(modifier);
		
		//this.add(Psupprimer);
		//this.add(Csupprimer);
		
		mb.setSize(600,50);

		supr.add(Psupprimer);
		supr.add(Csupprimer);
		mb.add(supr);
		mb.add(add);
		mb.add(modif);
		this.setJMenuBar(mb);
	
		
		//Psupprimer.setBounds(5, 5, 150, 40);
		//Csupprimer.setBounds(170, 5, 150, 40);
		

		this.setVisible(true);
	}; 
	
	
	
	//ajouter de critere 
		
	
		public void ajouter (duo critere) {
			JLabel a = new JLabel (critere.nom + " : "+ critere.prenom);
			
			if (i<3) {
					crit.add(critere);
					icrit.add(a);
				if (j==0) { 
					a.setBounds(25,575+(i*50),150, 50);
					this.add(a);
					j++;
				}
				else {a.setBounds(300,575+(i*50),150, 50);
					  j=0;
					  i++;
					  this.add(a);
					  }
						}
		
			else {JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null, "trop de critere veuillez en supprimer avant de pouvoir ajouter", "attention !", JOptionPane.ERROR_MESSAGE);}
			
			
		}
		
		
		//suppression de critere 
		
		public void supprimer (String titre) {
			int r=0;
			int v = crit.size();
			while (!(crit.get(r).nom.equals(titre))&& r<v){
				r++;
			
		}
			
		if (r==v) {System.out.println("le critere n'existe pas ! ");}
		else {
			for (int k = 0; k<icrit.size();k++)
			{
		this.remove(icrit.get(k));
		this.revalidate();
		this.repaint();}
			
		crit.remove(r);
		icrit.remove(r);
		i=0;
		j=0;
		for (int z=0 ; z<crit.size();z++) {
			duo place = crit.get(0);
			JLabel iplace = icrit.get(0);
			icrit.remove(0);
			crit.remove(0);
			this.ajouter(place);
		
			}
		}
		
			}
		
		//verifie si un individu appartient a l'arbre 
		
		public boolean est_descendant (String h , String d) 
		{
		boolean reponse = false;
			for(int m=0;m<this.descendance.size();m++) {if (this.descendance.get(m).nomr.getText().equals(h)&& this.descendance.get(m).prenomr.getText().equals(d))
					{reponse = true;}
			}
			
			
			
			return reponse;
		}
		
		// si le descendant existe , donner sa position dans la liste descendance   
		
		public int nombre_descendant (String h , String d) 
		{
		int reponse = 0;
			for(int m=0;m<this.descendance.size();m++) {if (this.descendance.get(m).nomr.getText().equals(h)&& this.descendance.get(m).prenomr.getText().equals(d))
					{reponse = m;}
			}
			
			
			
			return reponse;
		}
		
		// ajouter un individus dans l'arbre 
		
		
		
		public void ajout (List<identite> p ,identite fils) {
			if (p.size()==1) {

				fils.parent = this;
				fils.hauteur = fils.parent.hauteur +1 ; 
				fils.parentr.setText(this.nomr.getText()+" "+this.prenomr.getText());			
				this.enfant.add(fils);
				this.enfantr.setText(this.enfantr.getText()+" "+fils.nomr.getText()+" "+fils.prenomr.getText());
				this.descendance.addAll(fils.descendance);
			}

		else {	

					  this.descendance.addAll(fils.descendance);
					  p.remove(0);
					
					  p.get(0).ajout(p,fils);
			
				}
		}
			
		
		//rechercher un individu dans l'arbre 
		
		public List<List<identite>> rechercher_liste (String nom , String prenom ) {//testé fonctionnel
			
			List<List<identite>> réponse = new ArrayList<List<identite>>();
			if (nom.equals(this.nomr.getText())&& prenom.equals(this.prenomr.getText())) {
				List<identite> juste = new ArrayList<identite>();
				juste.add(this);
				réponse.add(juste);}
			
			if(this.est_descendant(nom,prenom)&&(this.enfant.size()!=0)) {
	
			for (int j = 0;j<this.enfant.size();j++)
				
				{if (this.enfant.get(j).est_descendant(nom, prenom))
				
				{List<List<identite>> tempo = this.enfant.get(j).rechercher_liste(nom,prenom);
				for (int o = 0 ; o<tempo.size();o++) {tempo.get(o).add(0, this);
														réponse.addAll(tempo);}
				
	
						}
					}
				
			}
			return réponse;}  

			
		
		
		//rechercher les descendant au degré n d'un individu 
		
		public List<identite> descendant_degré (int n) {//testé fonctionnel.
			List<identite> réponse = new ArrayList<identite>();
			if (n==0) 	{réponse.add(this);}
			else {
				for (int i =0 ; i<(this.enfant.size());i++) {
					 réponse.addAll(this.enfant.get(i).descendant_degré(n-1));}
			}

				return réponse;
			}
		
			//rechercher les cousins au nieme degré
		
		public List<identite> Recherche_cousin(int n ,List<identite> L) { 
			List<identite> réponse = new ArrayList<identite>();
			 String nom = L.get(L.size()-1).nomr.getText();
			 String prenom = L.get(L.size()-1).prenomr.getText();
					 if (n==0) {}
			else {//List<identite> L = this.recherche(nom,prenom);
				  if (n>=L.size()) {System.out.println("vous êtes remontées trop loin dans l'arbre généalogique !");}
				  else { identite ancêtre_commun = L.get(L.size()-1-n);
				  		 System.out.println(ancêtre_commun.prenomr.getText());
				  		 System.out.println(ancêtre_commun.enfant.size());
				  		  for (int i = 0 ; i <ancêtre_commun.enfant.size();i++) {

				  		      if (ancêtre_commun.enfant.get(i).descendance.contains(L.get(L.size()-1))) {}
				  		      else {réponse.addAll((ancêtre_commun.enfant.get(i).descendant_degré(n-1)));
				  		      
				  		      System.out.println("phase commencée : ");
				  		    for (int y = 0 ; y <ancêtre_commun.enfant.get(i).descendant_degré(n-1).size();y++) 
			  				{ 
			  					System.out.println("liste:"+ancêtre_commun.enfant.get(i).descendant_degré(n-1).get(y).prenomr.getText());
			  				}};
				  		  }
				  		 
				  		 
				  }
			}
			return réponse; }

		//suppression d'un individus et de toute sa déscendance 
			
			public void supprimer (identite sup) {//testé fonctionnel.
				
				
				if (this.equals(sup))
							{}
				if(this.descendance.contains(sup) )
					
					{	int i = 0 ;
						
						while (i<this.enfant.size() && !(this.enfant.get(i).equals(sup)))
						{i++;}
						{if (i<this.enfant.size()) 
								{					
								this.descendance.removeAll(sup.descendance);
								this.enfant.remove(i);
								} 
						
						else {  int j = 0;
								while(!this.enfant.get(j).descendance.contains(sup)&& j <this.enfant.size()) {j++;}
								this.descendance.removeAll(sup.descendance);
								this.enfant.get(j).supprimer(sup);
								}
						}
						
					
					}
				
				}
			
			//Fonction de remplacement d'un profil par un autre dans l'arbre
			
			public void modifier(identite ancien , identite nouveau) {//pas bon doit aussi modifier la descendance ... 
				
				if (this.equals(ancien))
				{nouveau.enfant.addAll(ancien.enfant);
				ancien.descendance.remove(ancien);
				nouveau.descendance.addAll(ancien.descendance);
				nouveau.hauteur = ancien.hauteur;
				nouveau.posX = ancien.posX;
				for (int p=0 ; p<this.enfant.size();p++)
				{nouveau.enfantr.setText(nouveau.enfantr.getText()+" "+this.enfant.get(p).nomr.getText()+" "+this.enfant.get(p).prenomr.getText());
				this.enfant.get(p).parent = nouveau;}
				}
				
				if (this.enfant.contains(ancien)) {
					nouveau.enfant.addAll(ancien.enfant);
					nouveau.parent = this ;
					nouveau.parentr.setText(ancien.parentr.getText());
					ancien.descendance.remove(ancien);
					nouveau.descendance.addAll(ancien.descendance);
					nouveau.hauteur = ancien.hauteur;
					nouveau.posX = ancien.posX;
				
					for (int p=0 ; p<this.enfant.size();p++)
					{nouveau.enfantr.setText(nouveau.enfantr.getText()+" "+this.enfant.get(p).nomr.getText()+" "+this.enfant.get(p).prenomr.getText());
					this.enfant.get(p).parent = nouveau;}
					
					int z = this.enfant.lastIndexOf(ancien);
					this.enfant.remove(ancien);
					this.enfant.add(z,nouveau);
					
					int k =this.descendance.lastIndexOf(ancien);
					this.descendance.remove(ancien);
					this.descendance.add(k,nouveau);
				
				}
				else { if(this.descendance.contains(ancien)) {
				int k =this.descendance.lastIndexOf(ancien);
				this.descendance.remove(ancien);
				this.add(nouveau,k);
				int j = 0;
				while(!this.enfant.get(j).descendance.contains(ancien)) {j++;}
				this.enfant.get(j).modifier(ancien,nouveau);}
				}
			}
			
			public identite enfanter(identite a) 
			{
				identite reponse = a;
				reponse.enfant.add(this);
				reponse.descendance.addAll(this.descendance);
				return reponse ;
				
			}
			
			// créer pour chaque sous - arbre le contour correspondant 
			
			
		public void most() {
				this.mostleft.clear();
				this.mostleft.add(this);
				this.mostright.clear();
				this.mostright.add(this);
				for (int p = 0 ; p<this.enfant.size();p++) {
					this.enfant.get(p).most();
				}
				if (this.enfant.size() != 0)
				{this.mostleft.addAll(this.enfant.get(0).mostleft);
				this.mostright.addAll(this.enfant.get(this.enfant.size()-1).mostright);
		}
		}
		
		
		public void decalage(int jump) {
			this.posX += jump;
			for (int z = 0 ;z<this.enfant.size();z++) 
			{this.enfant.get(z).decalage(jump);}
		}
		
		public void hdecalage(int saut) {
			this.hauteur += saut;
			for (int z = 0 ;z<this.enfant.size();z++) 
			{this.enfant.get(z).hdecalage(saut);}
		}
	//fonction s'occupant de positionner relativement l'arbre , penser a faire un most() avant et positionner le point le plus bas gauche 	
		
	//1- positionner les feuilles de maniere arbitraire initailement 
		public int feuille() {
			if (this.enfant.size() == 0)
			{return 1;}
			else {int reponse = 0 ;
			for (int m = 0 ; m<this.enfant.size() ; m++)
			{reponse +=this.enfant.get(m).feuille();
			}
			return reponse;
			}
		
		}
		
		public void dessin_init_bis(int pas) {
			
			if (this.enfant.size()==0)
			{
				this.posX = 25 + saut*pas ;
				saut++;
			}
			
			else {
			for (int r =0 ;r<this.enfant.size(); r++)
				{
					this.enfant.get(r).dessin_init_bis(pas);
				}
			}
		}
		public void dessin_init(int pas) {
			this.saut = 0 ;
			this.dessin_init_bis(pas);
			}
			
		
	//la deuxieme phase étant de dessiner à partir des feuille l'arbre en entier 
		public void dessin_second () {
			
			if (this.enfant.size() != 0) 
			{ int k =0;
				
			for (int z=0 ; z<this.enfant.size();z++) 
			{	
				this.enfant.get(z).dessin_second();
				k += this.enfant.get(z).posX;
			}
			
				this.posX = k/this.enfant.size();
			}
			}
	//la phase trois correspond la correction de l'erreur 
			
			public void dessin_troisiem () {
			if (this.enfant.size() != 0) 
			{
				for (int g = 1;g<this.enfant.size();g++) 
				{	this.enfant.get(g-1).dessin_troisiem();
				
					List<identite > droite = this.enfant.get(g-1).mostright;
					List<identite > gauche = this.enfant.get(g).mostleft;
					System.out.println("ça tourne ! 1");
					int saut = gauche.get(0).posX - droite.get(0).posX;;
					for (int w = 1 ; w<Math.min(droite.size(),gauche.size());w++)
					{ int ecart = gauche.get(w).posX - droite.get(w).posX;
					 	System.out.println("ça tourne ! 2");
						if (ecart < saut) 
						{ saut = ecart;}

					}
					//le saut representait mesurer l'écart , il faut donc décaller dans le sens inverse
					saut *= -1;
					// il faut prendre en compte la taille de la case (100) et l'écart minimal que l'on impose à 20 
					saut += 120;
					this.enfant.get(g).decalage(saut);
					
				}
				this.enfant.get(this.enfant.size()-1).dessin_troisiem();
			}
			}

			public void afficher(JPanel paneau) {
		 		/*this.noeud = new bouton(this);
				this.noeud.setBounds(this.posX,this.hauteur*100+150,100,50);
		 		fon.add(noeud);
		 		for (int h = 0 ; h<this.enfant.size(); h++) 
		 		{
		 			this.enfant.get(h).afficher(fon);
		 		}*/
				
				//this.noeud.setText(this.prenomr.getText());
		 		
				
				this.noeud.setBackground(Color.white);
		 		
				/*noeud = new Bouton(this.prenomr.getText(),profil);*/
				
				noeud.titre = this.prenomr.getText();
		 		noeud.img = new ImageIcon(profil).getImage();
		 		noeud.revalidate();
		 		noeud.repaint();
		 		
		 		this.noeud.addActionListener(new ActionListener() {
		  			public void actionPerformed(ActionEvent event) {
		  				identite.this.setVisible(true);
		  			}
		  			});
		 		
		 		
		 		this.noeud.setBounds(this.posX,this.hauteur*130+100,100,90);

		 		
 		 		paneau.add(noeud);
		 		for (int h = 0 ; h<this.enfant.size(); h++) 
		 		{
		 			this.enfant.get(h).afficher(paneau);
		 			paneau.getGraphics().drawLine(this.posX+50,this.hauteur*130+100+this.noeud.getHeight(),this.enfant.get(h).posX+50,this.enfant.get(h).hauteur*130+100);
		 		}
		 	
			}
			
			

			public void vider(JPanel paneau) {
		 		/*this.noeud = new bouton(this);
				this.noeud.setBounds(this.posX,this.hauteur*100+150,100,50);
		 		fon.add(noeud);
		 		for (int h = 0 ; h<this.enfant.size(); h++) 
		 		{
		 			this.enfant.get(h).afficher(fon);
		 		}*/
				

		 		paneau.remove(this.noeud);
		 		for (int h = 0 ; h<this.enfant.size(); h++) 
		 		{	
		 			this.enfant.get(h).vider(paneau);
		 			
		 		}
		 	}
	public static void main(String args[]) {
		/*pan.ajouter("D:\\Cours Mines-Paristech\\Informatique\\java\\Projet\\image de test\\defaut.jpg");
		pan.ajouter("D:\\Cours Mines-Paristech\\Informatique\\java\\Projet\\image de test\\logo.png");*/
		identite test = new identite("mahiou","meriem","20 ans","femme");

		
	}
	
	
}
