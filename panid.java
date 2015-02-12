import java.awt.Color;    

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


public class panid extends JPanel{
		String image;
	

	public void paintComponent(Graphics g){
		  try {
			  g.setColor(Color.white);
		      Image img = ImageIO.read(new File(image));
			  g.drawImage(img,0, 0,this.getWidth(),this.getHeight(), this);
		  	
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  
	
	
		  }
	public panid(String i) {
		
		image=i;
	}
	
	public static void main (String args[]) 
	{
		JDialog fen = new JDialog ();
		fen.setContentPane(new panid ("D:\\Cours Mines-Paristech\\Informatique\\java\\Projet\\image de test\\defaut.jpg"));
		fen.setVisible(true);
	}

}
