package pack1;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mainfile {

    public static void main(String[] args) {
        Logger logger = new Logger(); //unused, just to call constructor
        Logger.logOtherMessage("New Run","---------------\n");

        JOptionPane.showMessageDialog(null, "Welcome to Tower of Hanoi.\n To move, press the number to move, then the number to move to.");
        Logger.logCodeMessage("Welcome Pane shown.");
        int disksAmt;
        Logger.logCodeMessage("Asking user for amount of disks.");
        do {
            String disks = JOptionPane.showInputDialog(null, "How many disks do you want to play with?");
            disksAmt = Integer.parseInt(disks);
            if (disksAmt < 1 || disksAmt > 7) {
                JOptionPane.showMessageDialog(null, "Invalid amount of disks, try again. (2-7)");
            } else
                break;
        } while (true);
        Logger.logUserMessage("Amount of disks is " + disksAmt);

        HanoiFrame frame = new HanoiFrame();

        //create stacks for poles
        Stack diskStack1 = new Stack(disksAmt);
        Stack diskStack2 = new Stack(0);
        Stack diskStack3 = new Stack(0);


        Logger.logCodeMessage("Frame and stacks Created.");

    }

    /**
     * Moves a disk from one stack to another stack
     * @param from The stack to move from
     * @param to The stack to move to.
     */
    public static void transfer(Stack from, Stack to) {
        to.push(from.pop());
    }


}
