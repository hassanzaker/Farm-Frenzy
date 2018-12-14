package Model.Items;

public class Horn extends Item {

    private final int buyCost = 2000;
    private final int saleCost = 1000;


    public Horn(int x, int y, String ID) {
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
