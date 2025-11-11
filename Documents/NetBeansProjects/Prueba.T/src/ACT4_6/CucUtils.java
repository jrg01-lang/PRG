package ACT4_6;
import static ACT4_6.ACT4_6_A1.NFULLES;
import static ACT4_6.ACT4_6_A1.NTAULER;
import static ACT4_6.ACT4_6_A1.accio;
import static ACT4_6.ACT4_6_A1.cambiaPosicio;
import static ACT4_6.ACT4_6_A1.cuc;
import static ACT4_6.ACT4_6_A1.tauler;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;


public class CucUtils extends JFrame implements KeyListener {
    
    public CucUtils() {
        addKeyListener(this);
        setSize(400, 300);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char letra = e.getKeyChar();
        if (letra == 'a') ACT4_6_A1.accio = 4;
        if (letra == 'd') ACT4_6_A1.accio = 6;
        if (letra == 'w') ACT4_6_A1.accio = 8;
        if (letra == 's') ACT4_6_A1.accio = 2;
        if (cambiaPosicio(tauler, cuc, accio))
            if (cuc.size() == (NTAULER*NTAULER) - NFULLES) {
                System.out.println("YOU WIN !!!");
                accio = 0;
            }
            else {
                System.out.println("YOU LOSE !!!");
                accio = 0;
            }
    }
    @Override
    public void keyPressed(KeyEvent e) {
  
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

    public static void main(String[] args) {
        new CucUtils();
    }
}