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

    public Milk(int x, int y , String ID) {
        super(x, y , ID);
        this.setVolume(10);
        this.type="Milk";
    }

}
