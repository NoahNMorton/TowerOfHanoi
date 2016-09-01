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
            case 1:
                return Color.BLACK;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.RED;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.YELLOW;
            case 6:
                return Color.MAGENTA;
            case 7:
                return Color.green;
        }

        return null;
    }
}
