package Model.Items;

public class Adornment extends Item {

    private final int buyCost = 400;
    private final int saleCost = 300;

    public Adornment(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(4);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
