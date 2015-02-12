
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
 
public class Bouton extends JButton { // !!! on doit étendre le composant dans lequel on veut insérer une image de fond
     
	Image img;
    String imageName;
    String titre;
     
    //Un constructeur pour choisir plus simplement l'image
    public Bouton(String titr ,String imageName) {
        img = new ImageIcon(imageName).getImage();
        titre = titr;
    }
     
    //On doit redéfinir la méthode paintComponent() pour les composant swing !!! et paint() pour awt
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img == null) return;
        g.drawImage(img, 0, 0, getWidth(), getHeight()*2/3, this);
        g.drawString(titre,15, getHeight()*2/3+10 );
        //ici on adapte l'image à la taille du composant(getWidth(), getHeight())...
//cf : la documentation java à http://javasearch.developpez.com/j2se/1.6.0/docs/api/java/awt/Graphics.html#drawImage(java.awt.Image,%20int,%20int,%20int,%20int,%20java.awt.image.ImageObserver)
     
    }
}
