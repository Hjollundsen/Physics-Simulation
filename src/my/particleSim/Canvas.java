package my.particleSim;

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas {
    private JFrame frame;
    private Timer timer;
    private ParticleSim particleSim;

    public Canvas(ParticleSim p) {
        this.particleSim = p;
        makeFrame();
        timer.start();
    }

    private void makeFrame() {
        //Set up the frame
        frame = new JFrame("Temporary title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        DrawPanel panel = new DrawPanel();
        frame.add(panel, BorderLayout.CENTER); //Add the panel to the frame

        frame.pack(); //Packing the frame, just in case
        frame.setLocationRelativeTo(null); //Centers the frame
        frame.setVisible(true); //Make the frame visible

        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                particleSim.updateParticles();
                particleSim.handleCollisions();
                frame.repaint();
            }
        });

    }

        class DrawPanel extends JPanel {
            public DrawPanel() {
                setBackground(Color.WHITE);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                for(Particle p : particleSim.getParticles()) {
                    g.fillOval(p.getXCoordinate(), p.getYCoordinate(), p.getSize(), p.getSize());
                }
            }
        }

    public static void main(String args[]) {
        ParticleSim pSim = new ParticleSim(100, 10.0, 10.0, 20, 10, 10);
        new Canvas(pSim);
    }
}