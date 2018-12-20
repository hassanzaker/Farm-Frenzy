package Model.Items;

public class Milk extends Item {

    private final int buyCost = 2000;
    private final int saleCost = 1000;

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }

    public Milk(int x, int y , String ID, Boolean inGrounad) {
        super(x, y , ID, inGrounad);
        this.setVolume(10);
        this.type="Milk";
    }

}
