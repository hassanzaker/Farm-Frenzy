package Model.Items;

public class CarnivalDress extends Item {

    private final int buyCost = 1400;
    private final int saleCost = 1300;

    public CarnivalDress(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(8);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
