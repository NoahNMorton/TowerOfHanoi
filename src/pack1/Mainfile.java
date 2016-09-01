package pack1;

import javax.swing.*;

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

        new HanoiFrame(disksAmt);
        Logger.logCodeMessage("Frame and stacks Created.");

    }


}
