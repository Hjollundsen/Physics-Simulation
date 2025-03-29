package my.particleSim;

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas {
    private JFrame frame;
    public Canvas() {
        makeFrame();
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
            g.fillOval(400, 300, 10, 10);
        }
    }

    public static void main(String args[]) {
        new Particle(400, 300);
        new Canvas();
    }
}