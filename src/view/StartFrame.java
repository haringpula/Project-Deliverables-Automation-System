package view;

/*
 * SplashDemo.java
 *
 */
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import model.Secrets;

// XXX: this shit is from oracle documentation, i dont understand this
public class StartFrame extends Frame implements ActionListener {
    private Secrets secrets = new Secrets();

    /**
     * @param g
     * @param frame
     */
    static void renderSplashFrame(Graphics2D g, int frame) {
        final String[] comps = { "foo", "bar", "baz" };
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(120, 140, 200, 40);
        g.setPaintMode();
        g.setColor(Color.BLACK);
        g.drawString("Loading " + comps[(frame / 5) % 3] + "...", 120, 150);
    }

    public StartFrame() {
        super("SplashScreen demo");
        try {
			UIManager.setLookAndFeel(new com.jtattoo.plaf.hifi.HiFiLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
        setSize(300, 200);
        setLayout(new BorderLayout());
        Menu m1 = new Menu("File");
        MenuItem mi1 = new MenuItem("Exit");
        m1.add(mi1);
        mi1.addActionListener(this);
        this.addWindowListener(closeWindow);

        MenuBar mb = new MenuBar();
        setMenuBar(mb);
        mb.add(m1);
        // NOTE: Initialize gif file as splash image
        secrets.getCredentials();
        if (!secrets.csvHashVerifier()) {
            JOptionPane.showMessageDialog(null, "Database File Hash Code error. Please verify your DB_CREDENTIALS.csv file", "Integrity Check Failed", 0);
            System.exit(2);
        }
        final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
        for (int i = 0; i < 100; i++) {
            renderSplashFrame(g, i);
            splash.update();
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
            }
        }
        splash.close();
        setVisible(true);
        toFront();
        
    }

    /**
     * @param ae
     */
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }

    private static WindowListener closeWindow = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();
        }
    };
}
