		import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


		public class addimage {
			static String fichier;
		  public addimage() {
		    JFileChooser fileopen = new JFileChooser();
		    FileFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
		    fileopen.addChoosableFileFilter(filter);
		    
		    int ret = fileopen.showDialog(null, "Open file");

		    if (ret == JFileChooser.APPROVE_OPTION) {
		      fichier = fileopen.getSelectedFile().getAbsolutePath();

		    }
		  }
		}

