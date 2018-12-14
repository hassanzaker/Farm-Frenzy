package Model.Items;

public class Souvenir extends Item {

    private final int buyCost = 5000;
    private final int saleCost = 2500;

    public Souvenir(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(3);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
