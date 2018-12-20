package Model.Items;

public class Cake extends Item {

    private final int buyCost = 400;
    private final int saleCost = 200;

    public Cake(int x, int y, String ID, Boolean inGrounad) {
        super(x, y, ID,inGrounad);
        this.setVolume(6);
        this.type="Cake";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}

