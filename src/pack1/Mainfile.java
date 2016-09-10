package pack1;

import javax.swing.*;

@SuppressWarnings("WeakerAccess")
public class Mainfile {

    public static void main(String[] args) {
        new Logger(); //setup logger

        JOptionPane.showMessageDialog(null, "Welcome to Tower of Hanoi.\n To move, press the number to move, then the number to move to.");
        Logger.logCodeMessage("Welcome Pane shown.");
        int disksAmt;
        Logger.logCodeMessage("Asking user for amount of disks.");
        do {
            String disks = JOptionPane.showInputDialog(null, "How many disks do you want to play with? (2-6)");
            try {
                disksAmt = Integer.parseInt(disks);
                if (disksAmt < 1 || disksAmt > 7) {
                    JOptionPane.showMessageDialog(null, "Invalid amount of disks, try again.");
                } else
                    break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "I don't understand what you provided. Try again.", "Disk amount error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
        Logger.logUserMessage("Amount of disks is " + disksAmt);

        new HanoiFrame(disksAmt);
        Logger.logCodeMessage("Frame and stacks Created.");

    }


}
