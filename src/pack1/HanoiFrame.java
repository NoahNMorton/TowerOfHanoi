package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class HanoiFrame extends JFrame implements KeyListener {

    private int windowWidth = 700, windowHeight = 500; //size of the window.

    //private BufferedImage buffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_4BYTE_ABGR);

    //stacks for poles
    Stack diskStack1;
    Stack diskStack2;
    Stack diskStack3;

    public HanoiFrame(int disksAmt) {
        super("Tower Of Hanoi");// creates the JFrame with the given name

        //setup disks, stacks, etc.

        diskStack1 = new Stack(disksAmt);
        diskStack2 = new Stack(0);
        diskStack3 = new Stack(0);

        //window handling
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Sets the close button to exit the program
        setResizable(false);// makes the window not able to be resized
        setSize(windowWidth, windowHeight);// sets the frame's size
        Logger.logCodeMessage("Size of Window is " + windowWidth + "x" + windowHeight + " pixels.");
        setVisible(true);// shows the frame

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

        //Displaying disks on poles




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
        if (!secondKey) { //if this is the first key pressed
            firstKeyChar = e.getKeyChar();
            secondKey = true; //next key will be the second key
        } else { //this is the second key
            secondKeyChar = e.getKeyChar();
            secondKey = false; //next typed key will be first key
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //unused
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //unused
    }

    /**
     * Moves a disk from one stack to another stack
     *
     * @param from The stack to move from
     * @param to   The stack to move to.
     */
    public static void transfer(Stack from, Stack to) {
        to.push(from.pop());
    }
}
