package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal", "WeakerAccess"})
public class HanoiFrame extends JFrame implements KeyListener {

    private int windowWidth = 700, windowHeight = 500; //size of the window.

    //private BufferedImage buffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_4BYTE_ABGR);
    private int diskHeight;
    //stacks for poles
    private Stack diskStack1;
    private Stack diskStack2;
    private Stack diskStack3;

    public HanoiFrame(int disksAmt) {
        super("Tower Of Hanoi");// creates the JFrame with the given name

        //setup disks, stacks, etc.
        diskStack1 = new Stack(disksAmt);
        diskStack2 = new Stack(0); //other two stacks start empty
        diskStack3 = new Stack(0);
        diskHeight = 300 / disksAmt;

        //window handling
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// Sets the close button to exit the program
        setResizable(false);// makes the window not able to be resized
        setSize(windowWidth, windowHeight);// sets the frame's size
        Logger.logCodeMessage("Size of Window is " + windowWidth + "x" + windowHeight + " pixels.");
        setVisible(true);// shows the frame

    }

    public void paint(Graphics bg) {
        //todo paint graphics to screen, reinstate buffered graphics
        //Graphics bg = buffer.getGraphics();

        //background
        bg.setColor(Color.white);
        bg.fillRect(0, 0, windowWidth, windowHeight);

        //base
        bg.setColor(Color.gray);
        bg.fillRect(20, windowHeight - 40, windowWidth - 20, 20);

        //disk poles
        for (int i = windowWidth / 4; i < windowWidth; i += windowWidth / 4) {
            bg.fillRect(i, 100, 30, windowHeight - 130);
        }

        //Displaying disks on poles

        //pole 1
        int pole1X = (windowWidth / 4)+15; //x position of the center of pole 1.

        if (!diskStack1.empty()) { //don't show anything if the pole is empty
            for (int i = diskStack1.size() - 1; i >= 0; i--) {
                switch (diskStack1.get(i).getSize()) {
                    case 0: //smallest

                        break;
                    case 1:
                        bg.setColor(diskStack1.get(i).getColor(1));
                        break;
                    case 2:
                        break;
                    case 3:
                        bg.setColor(diskStack1.get(i).getColor(2));
                        break;
                    case 4:
                        bg.setColor(diskStack1.get(i).getColor(3));
                        break;
                    case 5:
                        bg.setColor(diskStack1.get(i).getColor(4));
                        break;
                    case 6:
                        bg.setColor(diskStack1.get(i).getColor(5));
                        break;
                    default:
                        System.err.println("Invalid disk size found. Size is: " + diskStack1.get(i).getSize());
                        break;
                }
            }
        }

        //pole 2


        //pole 3

        //g.drawImage(buffer, 0, 0, null); //draw buffer to screen
    }

    //variables for keyTyped
    private boolean secondKey = false;
    private char firstKeyChar = ' ';
    private char secondKeyChar = ' ';


    @Override
    public void keyTyped(KeyEvent e) {
        //determine what key press this was

        if (!secondKey) { //if this is the first key pressed
            firstKeyChar = e.getKeyChar();
            secondKey = true; //next key will be the second key
        } else { //this is the second key
            secondKeyChar = e.getKeyChar();
            secondKey = false; //next typed key will be first key
            //make the movement
            if (firstKeyChar == '1' && secondKeyChar == '2') { //1>2
                transfer(diskStack1, diskStack2);
                Logger.logUserMessage("Moved disk from stack 1 to stack 2.");
            }
            if (firstKeyChar == '1' && secondKeyChar == '3') { //1>3
                transfer(diskStack1, diskStack3);
                Logger.logUserMessage("Moved disk from stack 1 to stack 3.");
            }
            if (firstKeyChar == '2' && secondKeyChar == '1') { //2>1
                transfer(diskStack2, diskStack1);
                Logger.logUserMessage("Moved disk from stack 2 to stack 1.");
            }
            if (firstKeyChar == '2' && secondKeyChar == '3') { //2>3
                transfer(diskStack2, diskStack3);
                Logger.logUserMessage("Moved disk from stack 2 to stack 3.");
            }
            if (firstKeyChar == '3' && secondKeyChar == '2') { //3>2
                transfer(diskStack3, diskStack2);
                Logger.logUserMessage("Moved disk from stack 3 to stack 2.");
            }
            if (firstKeyChar == '3' && secondKeyChar == '1') { //3>1
                transfer(diskStack3, diskStack1);
                Logger.logUserMessage("Moved disk from stack 3 to stack 1.");
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
     */
    private static void transfer(Stack from, Stack to) {
        if (from.peek().getSize() > to.peek().getSize()) { //if small disk onto larger disk
            System.out.println("Cannot move small disk onto larger disk.");
            JOptionPane.showMessageDialog(null, "Cannot move smaller disk onto larger disk. \nTry another move."); //warn the user about invalid move
            Logger.logUserMessage("User attempted invalid move.");
        } else
            to.push(from.pop());
    }
}
