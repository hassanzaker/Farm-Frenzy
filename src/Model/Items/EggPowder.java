package Model.Items;

public class EggPowder extends Item {

    private final int buyCost = 100;
    private final int saleCost = 50;


    public EggPowder(int x, int y, String ID) {
        super(x, y, ID);
        this.setVolume(4);
        this.type="EggPowder";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
