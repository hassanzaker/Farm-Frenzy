package Model.Items;

public class CheeseFerment extends Item {

    private final int buyCost = 25;
    private final int saleCost = 15;

    public CheeseFerment(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(2);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
