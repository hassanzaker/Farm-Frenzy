package Model.Items;

public class Wool extends Item {

    private final int buyCost = 200;
    private final int saleCost = 100;

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }

    public Wool(int x, int y , String ID) {
        super(x, y , ID);
        this.setVolume(5);
    }

}
