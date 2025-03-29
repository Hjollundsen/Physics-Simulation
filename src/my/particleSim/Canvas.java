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

        //Finally packing frame and making it visible.
        frame.pack();
        frame.setVisible(true);
    }
}
