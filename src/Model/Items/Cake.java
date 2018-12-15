package Model.Items;

public class Cake extends Item {

    private final int buyCost = 400;
    private final int saleCost = 200;

    public Cake(int x, int y, String ID) {
        super(x, y, ID);
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

