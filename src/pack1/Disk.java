package pack1;

import java.awt.*;

@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal"})
public class Disk {

    private int size; //will be between 1-7
    private Color color;

    public Disk(int size) {
        this.size = size;
        this.color = getColor(size);
    }

    public int getSize() {
        return size;
    }

    public Color getColor(int size) {
        switch (size) {
            case 0:
                return Color.BLACK;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.RED;
            case 3:
                return Color.ORANGE;
            case 4:
                return Color.YELLOW;
            case 5:
                return Color.MAGENTA;
            case 6:
                return Color.green;
        }

        return null;
    }
}
