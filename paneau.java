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

public class paneau extends JScrollPane{
	
	identite tete;
	
	public void dessin (Graphics g , identite i) 
	{
		 for (int k = 0 ; k<i.enfant.size();k++) 
		 {
			 
			 g.drawLine(i.posX+50, i.hauteur*100+150+i.noeud.getHeight(),i.enfant.get(k).posX+50,i.enfant.get(k).hauteur*100+150);
		  dessin(g,i.enfant.get(k));
		}
	}
	
	 public void paintComponent(Graphics g){
try {
		 for (int k = 0 ; k<tete.enfant.size();k++) 
		 {
			 
			dessin(g,tete);
		}
	 }
catch (NullPointerException e) {}
	 }
	 
	public paneau (identite a) 
	{
		tete = a;
	}
	

}
