package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class HanoiFrame extends JFrame {

    private int windowWidth = 700, windowHeight = 500; //size of the window.

    private BufferedImage buffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_4BYTE_ABGR);

    public HanoiFrame() {
        // creates the JFrame with the given name
        super("Tower Of Hanoi");


        // Sets the close button to exit the program
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // makes the window not able to be resized
        setResizable(false);

        // sets the frame's size
        setPreferredSize(new Dimension(windowWidth, windowHeight));
        Logger.logCodeMessage("Size of Window is " + windowWidth + "x" + windowHeight + " pixels.");

        // creates the window
        pack();

        // shows the frame
        setVisible(true);


    }

    public void paint(Graphics bg) {
        //todo paint graphics to screen
        //Graphics bg = buffer.getGraphics();

        //background
        bg.setColor(Color.white);
        bg.fillRect(0, 0, windowWidth, windowHeight);

        //base
        bg.setColor(Color.gray);
        bg.fillRect(20, windowHeight - 40, windowWidth - 20, 20);

        //disk spikes
        bg.fillRect(windowWidth / 3, 40, 30, windowHeight - 20);

        //find window border

        bg.setColor(Color.BLUE);
        bg.drawRect(0, 0, windowWidth, windowHeight);
        bg.drawRect(1, 1, windowWidth - 1, windowHeight - 1);
        bg.drawRect(2, 2, windowWidth - 2, windowHeight - 2);

        //g.drawImage(buffer, 0, 0, null); //draw buffer to screen
    }


}
