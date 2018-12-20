package Model.Items;

public class Fabric extends Item {

    private final int buyCost = 400;
    private final int saleCost = 300;

    public Fabric(int x, int y, String ID, Boolean inGrounad) {
        super(x, y, ID, inGrounad);
        this.setVolume(6);
        this.type="Fabric";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
