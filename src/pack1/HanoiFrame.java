package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class HanoiFrame extends JFrame implements KeyListener {

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
        setSize(windowWidth, windowHeight);
        Logger.logCodeMessage("Size of Window is " + windowWidth + "x" + windowHeight + " pixels.");

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
        for (int i = windowWidth/4; i<windowWidth; i+=windowWidth/4) {
            bg.fillRect(i, 100, 30, windowHeight-130);
        }


        //g.drawImage(buffer, 0, 0, null); //draw buffer to screen
    }

    //variables for keyTyped
    private boolean secondKey = false;
    private char firstKeyChar = ' ';
    private char secondKeyChar = ' ';


    @Override
    public void keyTyped(KeyEvent e) {
        //todo movement key handling

        //determine what key press this was
        if (!secondKey) { //if this is the second key pressed
            firstKeyChar = e.getKeyChar();
            secondKey = true;
        } else {
            secondKeyChar = e.getKeyChar();
            secondKey = false; //next key will be first key
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
