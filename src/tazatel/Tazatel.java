/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel;

import tazatel.gui.VyberOkno;
import tazatel.dataStructure.OtazkyData;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author vojta3310
 */
public class Tazatel {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      
      // Look and feel
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Tazatel.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }else if ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel".equals(info.getClassName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Tazatel.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
      
      try {
          DataLoader dl = new DataLoader("/res/ulohy.xml");
          OtazkyData data = dl.read();
          VyberOkno okno = new VyberOkno(data);
          okno.setLocationRelativeTo(null);
          okno.setVisible(true);
      } catch (IOException ex) {
          System.out.println("Chyba při otevírání souboru");
      } catch (ParserConfigurationException | SAXException ex) {
          System.out.println("Chyba při parsování XML");
      }
  }
  
}
