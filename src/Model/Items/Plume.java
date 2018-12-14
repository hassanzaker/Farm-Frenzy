package Model.Items;

public class Plume extends Item{
    private final int buyCost = 200;
    private final int saleCost = 100;

    public Plume(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(2);
    }
}
