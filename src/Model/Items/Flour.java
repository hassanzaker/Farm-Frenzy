package Model.Items;

public class Flour extends Item {
    private final int buyCost = 20;
    private final int saleCost = 10;


    public Flour(int x, int y, String ID, Boolean inGrounad) {
        super(x, y, ID, inGrounad);
        this.setVolume(1);
        this.type="Flour";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
