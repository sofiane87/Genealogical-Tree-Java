import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


public class diapo extends JPanel {
	 CardLayout cl = new CardLayout();
	 List<String> liste = new ArrayList<String>();
	 int i = 0;
	 static int j = 0;
	 static int chiffre;
	 List<panid> pliste =new ArrayList<panid> ();
	 
	 public diapo () {
		 
		this.setLayout(cl);
	 }
	 
	 public void ajouter (String image) {
		 
		/* JButton valider = new JButton ("valider");
		 final JDialog name = new JDialog ();
		 final JTextField choix = new JTextField ();
		 name.setLocationRelativeTo(null);		 
		 name.setLayout(new GridLayout(3,1));
		 name.setSize(200,150);
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
			      }
			    });
			liste.add(mot);*/
			panid a = new panid (image);
			pliste.add(a);
			this.add(a,liste.get(j));
			j++;
	
	 }
	 
	 public void supprimer () {
		
		 JButton valider = new JButton ("valider");
		 final JDialog name = new JDialog ();
		 DefaultListModel<String> imagelist = new DefaultListModel<>();
		 for (int r=0 ; r<liste.size();r++) {
			 imagelist.addElement(liste.get(r));
		 }
		 //regalge de la JLISTE
		 
		
		 final JList choix = new JList<>(imagelist);
		 choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 choix.setPreferredSize(new Dimension (150,150));
		 
		 //positionnement dans le name 
		 name.setLocationRelativeTo(null);
		 name.setSize(400,200);
		 name.setTitle("suppression de Photo");
		 
		 name.add(new JLabel ("choisissez la photo : "),BorderLayout.NORTH);

		 name.add(choix);
		 name.add(new JScrollPane(choix));
		 
		 name.add(valider,BorderLayout.SOUTH); 
		 
		 valider.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		    	
		    	 chiffre = choix.getSelectedIndex();
		    	 name.dispose();
		    	 pliste.remove(chiffre);
		 		 liste.remove(chiffre);
		 		 j--;
		 		 diapo.this.remove(chiffre);
		      }
		    });

		 
		 //data has type Object[]
		 /*choix.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 choix.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		 choix.setVisibleRowCount(-1);
		 
		 JScrollPane listScroller = new JScrollPane(choix);
		 listScroller.setPreferredSize(new Dimension(250, 80));
		 
		 //ajout des éléments a choix 
		 
		 for (int r =0;r<liste.size();r++) 
		 {choix.add(liste.get(r),this.getComponent(r));}
		 
		 
		 
		 */
		 
		 name.setVisible(true);
		 
		 
	 }
	 
	 
}
