package pack1;

import java.awt.*;
import java.security.PublicKey;

public class Disk {

    public int size; //will be between 1-7
    public Color color;

    public Disk(int size) {
        this.size = size;
        this.color = getColor(size);
    }

    public Color getColor(int size)
    {
        switch (size)
        {
            case 1:
                return Color.BLACK;
            case 2:
                return Color.BLUE;


        }


        return null;
    }
}
