package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal", "WeakerAccess"})
public class HanoiFrame extends JFrame implements KeyListener {

    private int windowWidth = 700, windowHeight = 500; //size of the window.

    private BufferedImage buffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_4BYTE_ABGR);
    private int diskHeight, diskWidth, moves = 0;
    //stacks for poles
    private Stack diskStack1, diskStack2, diskStack3;

    public HanoiFrame(int disksAmt) {
        super("Tower Of Hanoi");// creates the JFrame with the given name

        //setup disks, stacks, etc.
        diskStack1 = new Stack(disksAmt);
        diskStack2 = new Stack(0); //other two stacks start empty
        diskStack3 = new Stack(0);
        diskHeight = 300 / disksAmt;
        diskWidth = 170 / disksAmt;

        //window handling
        addKeyListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Sets the close button to exit the program
        setResizable(false);// makes the window not able to be resized
        setSize(windowWidth, windowHeight);// sets the frame's size
        Logger.logCodeMessage("Size of Window is " + windowWidth + "x" + windowHeight + " pixels.");
        setVisible(true);// shows the frame

    }

    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();

        int poleWidth = 15; //width of the disk poles.
        int pole1X = (windowWidth / 4) + poleWidth / 2; //x position of the left of pole 1.
        int pole2X = 2 * ((windowWidth / 4)) + poleWidth / 2; //x position of the left of pole 2.
        int pole3X = 3 * ((windowWidth / 4)) + poleWidth / 2; //...

        //background --------------------------
        bg.setColor(Color.white);
        bg.fillRect(0, 0, windowWidth, windowHeight);

        //base ------------------------------
        bg.setColor(Color.gray);
        bg.fillRect(20, windowHeight - 40, windowWidth - 20, 20);

        //disk poles ------------------------------
        for (int i = windowWidth / 4; i < windowWidth; i += windowWidth / 4) {
            bg.fillRect(i, 100, poleWidth, windowHeight - 130);
        }

        //Displaying disks on poles ---------------------------

        //pole 1 ---------------------------------

        if (!diskStack1.empty()) { //don't show anything if the pole is empty
            for (int i = diskStack1.size() - 1; i >= 0; i--) { //goes backwards (upwards) through the stack, drawing each rectangle.
                switch (diskStack1.get(i).getSize()) {
                    case 0: //smallest
                        bg.setColor(diskStack1.get(i).getColor(0));
                        fillCenteredRect(pole1X, ((i - diskStack1.size()) * diskHeight) + 460, diskWidth, diskHeight, bg);
                        break;
                    case 1:
                        bg.setColor(diskStack1.get(i).getColor(1));
                        fillCenteredRect(pole1X, ((i - diskStack1.size()) * diskHeight) + 460, 2 * diskWidth, diskHeight, bg);
                        break;
                    case 2:
                        bg.setColor(diskStack1.get(i).getColor(2));
                        fillCenteredRect(pole1X, ((i - diskStack1.size()) * diskHeight) + 460, 3 * diskWidth, diskHeight, bg);
                        break;
                    case 3:
                        bg.setColor(diskStack1.get(i).getColor(3));
                        fillCenteredRect(pole1X, ((i - diskStack1.size()) * diskHeight) + 460, 4 * diskWidth, diskHeight, bg);
                        break;
                    case 4:
                        bg.setColor(diskStack1.get(i).getColor(4));
                        fillCenteredRect(pole1X, ((i - diskStack1.size()) * diskHeight) + 460, 5 * diskWidth, diskHeight, bg);
                        break;
                    case 5:
                        bg.setColor(diskStack1.get(i).getColor(5));
                        fillCenteredRect(pole1X, ((i - diskStack1.size()) * diskHeight) + 460, 6 * diskWidth, diskHeight, bg);
                        break;
                    case 6: //largest
                        bg.setColor(diskStack1.get(i).getColor(6));
                        fillCenteredRect(pole1X, ((i - diskStack1.size()) * diskHeight) + 460, 7 * diskWidth, diskHeight, bg);
                        break;
                    default:
                        System.err.println("Invalid disk size found. Size is: " + diskStack1.get(i).getSize());
                        break;
                }
            }
        }

        //pole 2 ------------------------------

        if (!diskStack2.empty()) { //don't show anything if the pole is empty
            for (int i = diskStack2.size() - 1; i >= 0; i--) { //goes backwards (upwards) through the stack, drawing each rectangle.
                switch (diskStack2.get(i).getSize()) {
                    case 0: //smallest
                        bg.setColor(diskStack2.get(i).getColor(0));
                        fillCenteredRect(pole2X, ((i - diskStack2.size()) * diskHeight) + 460, diskWidth, diskHeight, bg);
                        break;
                    case 1:
                        bg.setColor(diskStack2.get(i).getColor(1));
                        fillCenteredRect(pole2X, ((i - diskStack2.size()) * diskHeight) + 460, 2 * diskWidth, diskHeight, bg);
                        break;
                    case 2:
                        bg.setColor(diskStack2.get(i).getColor(2));
                        fillCenteredRect(pole2X, ((i - diskStack2.size()) * diskHeight) + 460, 3 * diskWidth, diskHeight, bg);
                        break;
                    case 3:
                        bg.setColor(diskStack2.get(i).getColor(3));
                        fillCenteredRect(pole2X, ((i - diskStack2.size()) * diskHeight) + 460, 4 * diskWidth, diskHeight, bg);
                        break;
                    case 4:
                        bg.setColor(diskStack2.get(i).getColor(4));
                        fillCenteredRect(pole2X, ((i - diskStack2.size()) * diskHeight) + 460, 5 * diskWidth, diskHeight, bg);
                        break;
                    case 5:
                        bg.setColor(diskStack2.get(i).getColor(5));
                        fillCenteredRect(pole2X, ((i - diskStack2.size()) * diskHeight) + 460, 6 * diskWidth, diskHeight, bg);
                        break;
                    case 6: //largest
                        bg.setColor(diskStack2.get(i).getColor(6));
                        fillCenteredRect(pole2X, ((i - diskStack2.size()) * diskHeight) + 460, 7 * diskWidth, diskHeight, bg);
                        break;
                    default:
                        System.err.println("Invalid disk size found. Size is: " + diskStack2.get(i).getSize());
                        break;
                }
            }
        }

        //pole 3 ----------------------------------------

        if (!diskStack3.empty()) { //don't show anything if the pole is empty
            for (int i = diskStack3.size() - 1; i >= 0; i--) { //goes backwards (upwards) through the stack, drawing each rectangle.
                switch (diskStack3.get(i).getSize()) {
                    case 0: //smallest
                        bg.setColor(diskStack3.get(i).getColor(0));
                        fillCenteredRect(pole3X, ((i - diskStack3.size()) * diskHeight) + 460, diskWidth, diskHeight, bg);
                        break;
                    case 1:
                        bg.setColor(diskStack3.get(i).getColor(1));
                        fillCenteredRect(pole3X, ((i - diskStack3.size()) * diskHeight) + 460, 2 * diskWidth, diskHeight, bg);
                        break;
                    case 2:
                        bg.setColor(diskStack3.get(i).getColor(2));
                        fillCenteredRect(pole3X, ((i - diskStack3.size()) * diskHeight) + 460, 3 * diskWidth, diskHeight, bg);
                        break;
                    case 3:
                        bg.setColor(diskStack3.get(i).getColor(3));
                        fillCenteredRect(pole3X, ((i - diskStack3.size()) * diskHeight) + 460, 4 * diskWidth, diskHeight, bg);
                        break;
                    case 4:
                        bg.setColor(diskStack3.get(i).getColor(4));
                        fillCenteredRect(pole3X, ((i - diskStack3.size()) * diskHeight) + 460, 5 * diskWidth, diskHeight, bg);
                        break;
                    case 5:
                        bg.setColor(diskStack3.get(i).getColor(5));
                        fillCenteredRect(pole3X, ((i - diskStack3.size()) * diskHeight) + 460, 6 * diskWidth, diskHeight, bg);
                        break;
                    case 6: //largest
                        bg.setColor(diskStack3.get(i).getColor(6));
                        fillCenteredRect(pole3X, ((i - diskStack3.size()) * diskHeight) + 460, 7 * diskWidth, diskHeight, bg);
                        break;
                    default:
                        System.err.println("Invalid disk size found. Size is: " + diskStack3.get(i).getSize());
                        break;
                }
            }
        }

        bg.setColor(Color.black);
        bg.drawString("Current number of moves: " + moves, 10, 40); //move counter
        bg.drawString("Last move: " + firstKeyChar + " to " + secondKeyChar, 10, 55);

        //indicate the current key
        if (!secondKey) { //if waiting for first key
            bg.drawString("Waiting for first key...", 10, 70);
        } else { //waiting for second key
            bg.drawString("Waiting for second key...", 10, 70);
        }

        g.drawImage(buffer, 0, 0, null); //draw buffer to screen
    }

    //variables for keyTyped
    private static boolean secondKey = false;
    private static char firstKeyChar = ' ';
    private static char secondKeyChar = ' ';

    @Override
    public void keyTyped(KeyEvent e) {
        //determine what key press this was

        if (!secondKey) { //if this is the first key pressed
            firstKeyChar = e.getKeyChar();
            secondKey = true; //next key will be the second key
            repaint();
        } else { //this is the second key
            secondKeyChar = e.getKeyChar();
            secondKey = false; //next typed key will be first key
            //make the movement
            if (firstKeyChar == '1' && secondKeyChar == '2') { //1>2
                if (transfer(diskStack1, diskStack2)) {
                    Logger.logUserMessage("Moved disk from stack 1 to stack 2.");
                    moves++;
                }
            }
            if (firstKeyChar == '1' && secondKeyChar == '3') { //1>3
                if (transfer(diskStack1, diskStack3)) {
                    Logger.logUserMessage("Moved disk from stack 1 to stack 3.");
                    moves++;
                }
            }
            if (firstKeyChar == '2' && secondKeyChar == '1') { //2>1
                if (transfer(diskStack2, diskStack1)) {
                    Logger.logUserMessage("Moved disk from stack 2 to stack 1.");
                    moves++;
                }
            }
            if (firstKeyChar == '2' && secondKeyChar == '3') { //2>3
                if (transfer(diskStack2, diskStack3)) {
                    Logger.logUserMessage("Moved disk from stack 2 to stack 3.");
                    moves++;
                }
            }
            if (firstKeyChar == '3' && secondKeyChar == '2') { //3>2
                if (transfer(diskStack3, diskStack2)) {
                    Logger.logUserMessage("Moved disk from stack 3 to stack 2.");
                    moves++;
                }
            }
            if (firstKeyChar == '3' && secondKeyChar == '1') { //3>1
                if (transfer(diskStack3, diskStack1)) {
                    Logger.logUserMessage("Moved disk from stack 3 to stack 1.");
                    moves++;
                }
            }
            repaint(); //repaint to update graphics.
            if (checkForWin(diskStack1, diskStack2)) { //check if the user won the game with that move.
                JOptionPane.showMessageDialog(null, "You win! Congrats!\nNumber of moves = " + moves);
                Logger.logUserMessage("User won the game. Exiting.");
                Logger.logUserMessage("Number of moves was: " + moves);
                System.exit(0); //exit the game after win.
            }
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
     * @return True if successful in moving the disk.
     */
    private static boolean transfer(Stack from, Stack to) {
        if (!(from.empty()) && to.empty()) {
            to.push(from.pop());
            return true;
        }
        if (from.empty() || from.peek().getSize() > to.peek().getSize()) { //if bad move, from is empty, large onto small, etc.
            System.out.println("Invalid move made.");
            JOptionPane.showMessageDialog(null, "Invalid move. Rules: \nLarger disks cannot be placed onto smaller disks. \nEmpty poles cannot be moved from.",
                    "Movement error", JOptionPane.ERROR_MESSAGE); //warn the user about invalid move

            Logger.logUserMessage("User attempted an invalid move.");
            return false;
        } else {
            to.push(from.pop());
            return true;
        }
    }

    /**
     * Draws a rectangle where the center of the rectangle is the X, instead of the upper left corner.
     * Height works similar to drawRect.
     *
     * @param x        X value to draw from.
     * @param y        Y value to draw from
     * @param width    Width of the rectangle
     * @param height   height of the rectangle
     * @param graphics Graphics to use to draw.
     */
    private void fillCenteredRect(int x, int y, int width, int height, Graphics graphics) {
        int newX = x - width / 2;
        graphics.fillRect(newX, y, width, height);
    }

    /**
     * Checks to see if the game has been won. Game is won if all disks are on the 3rd pole.
     *
     * @param diskStack1 The first pole to check
     * @param diskStack2 The second pole to check
     * @return win status
     */
    private boolean checkForWin(Stack diskStack1, Stack diskStack2) {
        return diskStack1.empty() && diskStack2.empty();
    }
}
