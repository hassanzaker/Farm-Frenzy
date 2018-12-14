package Model.Items;

public class Egg extends Item {

    private final int buyCost = 20;
    private final int saleCost = 10;

    public Egg(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(1);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
