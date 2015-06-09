package qubiz.movinglightinterface;

/**
 * Created by Mathijs on 09/06/2015.
 */
public class Preset {
    private String name;
    private int color;

    public Preset(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

}
