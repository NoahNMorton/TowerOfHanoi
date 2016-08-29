package pack1;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mainfile implements KeyListener {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to Tower of Hanoi.\n To move, press the number to move, then the number to move to.");
        Logger.logCodeMessage("Welcome Pane shown.");
        int disksAmt;
        Logger.logCodeMessage("Asking user for amount of disks.");
        do {
            String disks = JOptionPane.showInputDialog(null, "How many disks do you want to play with?");
            disksAmt = Integer.parseInt(disks);
            if (disksAmt < 1 || disksAmt > 7) {
                JOptionPane.showMessageDialog(null, "Invalid amount of disks, try again.");
            } else
                break;
        } while (true);
        Logger.logUserMessage("Amount of disks is " + disksAmt);

        HanoiFrame frame = new HanoiFrame();
        Stack<Disk> diskStack = new Stack<>(disksAmt);
        Logger.logCodeMessage("Frame and stack Created.");


    }

    public void keyPressed(KeyEvent e) {
        //unused
    }
    public void keyReleased(KeyEvent e) {
        //unused
    }

    public void keyTyped(KeyEvent e) {
        //todo movement keys
    }
}
