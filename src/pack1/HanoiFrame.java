package pack1;

import javax.swing.*;
import java.awt.*;


public class HanoiFrame extends JFrame {

    public HanoiFrame()
    {
        // creates the JFrame with the given name
        super("Tower Of Hanoi");

        // Sets the close button to exit the program
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // makes the window not able to be resized
        setResizable(false);

        // sets the frame's size
        setPreferredSize(new Dimension(700, 500));

        // creates the window
        pack();

        // shows the frame
        setVisible(true);

    }



}
