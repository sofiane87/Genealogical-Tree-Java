import java.awt.Color;    
import javax.imageio.ImageIO;
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

public class pancueil extends JPanel{
		
	public void paintComponent(Graphics g){
		  try {
		      Image img = ImageIO.read(new File("src\\logo.png"));
		     /* g.drawImage(img, 0, 0,this.getWidth(),this.getHeight()*2/3, this);
		      g.setColor(Color.WHITE);
		      g.fillRect(0, this.getHeight()*2/3, this.getWidth(), this.getHeight());;   */
		      //Pour une image de fond
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }                
		  }
	
}
	  


