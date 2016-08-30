package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class HanoiFrame extends JFrame {

    private BufferedImage buffer = new BufferedImage(700, 500, BufferedImage.TYPE_4BYTE_ABGR);

    public HanoiFrame() {
        // creates the JFrame with the given name
        super("Tower Of Hanoi");

        pack();
        // Sets the close button to exit the program
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // makes the window not able to be resized
        setResizable(false);

        // sets the frame's size
        setPreferredSize(new Dimension(700, 500));
        Logger.logCodeMessage("Size of Window is 700x500 pixels.");

        // creates the window
        pack();

        // shows the frame
        setVisible(true);
        setFocusable(true);

    }

    public void paint(Graphics g) {
        //todo paint graphics to screen
        Graphics bg = buffer.getGraphics();

        //background
        bg.setColor(Color.white);
        bg.drawRect(0, 0, getWidth(), getHeight());

        //base
        bg.setColor(Color.gray);
        bg.drawRect(0, getHeight() - 20, getWidth(), 20);


        g.drawImage(buffer, 0, 0, null); //draw buffer to screen
    }


}
