package Model.Items;

public class Egg extends Item {

    private final int buyCost = 20;
    private final int saleCost = 10;

    public Egg(int x, int y, String ID, Boolean inGrounad) {
        super(x, y, ID, inGrounad);
        this.setVolume(1);
        this.type="Egg";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
