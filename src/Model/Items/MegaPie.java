package Model.Items;

public class MegaPie extends Item {

    private final int buyCost = 20000;
    private final int saleCost = 10000;

    public MegaPie(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(20);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
