package pack1;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mainfile implements KeyListener {

    public static void main(String[] args)
    {
        HanoiFrame frame = new HanoiFrame();
        JOptionPane.showMessageDialog(null,"Welcome to Tower of Hanoi.\n To move, press the number to move, then the number to move to.");
        String disks = JOptionPane.showInputDialog(null,"How many disks do you want to play with?");
        int disksAmt = Integer.parseInt(disks);
        


    }
    public void keyPressed(KeyEvent e)
    {
        //unused
    }
    public void keyReleased(KeyEvent e)
    {
        //unused
    }
    public void keyTyped(KeyEvent e)
    {
        //todo movement keys
    }
}
