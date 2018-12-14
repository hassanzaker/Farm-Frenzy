package Model.Items;

public class Curd extends Item {

    private final int buyCost = 4000;
    private final int saleCost = 2000;
    public Curd(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(6);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
