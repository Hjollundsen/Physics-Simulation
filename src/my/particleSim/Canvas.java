package my.particleSim;

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas {
    private JFrame frame;
    private Timer timer;
    private ParticleSim particleSim;

    /**
     * Constructor for the Canvas. Creates a JFrame and sets up the drawing panel.
     */
    public Canvas(ParticleSim p) {
        this.particleSim = p;
        makeFrame();
        timer.start();
    }

    private void makeFrame() {
        //Sets up the frame
        frame = new JFrame("Particle Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sets default close button
        frame.setResizable(false); //Fixes the frame size

        JPanel drawPanel = new DrawPanel();
        frame.add(drawPanel, BorderLayout.CENTER); //Add the panel

        //Finally packing frame and making it visible.
        frame.pack();
        frame.setLocationRelativeTo(null); //Center window on screen
        frame.setVisible(true);

        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                particleSim.updateParticles();  // Move particles
                frame.repaint();    // Redraw the panel with new positions
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
        ParticleSim pSim = new ParticleSim(6, 20, 400, 25, 2, 3);
        new Canvas(pSim);
    }
}