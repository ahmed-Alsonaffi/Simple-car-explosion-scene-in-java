
package carexplosion;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CarExplosion extends JFrame{

    public CarExplosion() throws MalformedURLException{
        CarexPlosion2 bb=new CarexPlosion2();
        add(bb);
        bb.init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(680, 400));
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                new CarExplosion();
            } catch (MalformedURLException ex) {
                Logger.getLogger(CarExplosion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
    }
    
}
