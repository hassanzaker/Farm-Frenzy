package Model.Items;

public class Varnish extends Item {

    private final int buyCost = 25;
    private final int saleCost = 15;

    public Varnish(int x, int y, String ID) {
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
