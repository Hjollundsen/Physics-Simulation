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
        frame = new JFrame("Particle Simulation");
        Container contentPane = frame.getContentPane();
        JLabel label = new JLabel("I am a label!");
        contentPane.add(label);
        //Finally packing frame and making it visible.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new Canvas();
    }
}