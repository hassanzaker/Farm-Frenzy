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

    public Wool(int x, int y , String ID , Boolean inGrounad) {
        super(x, y , ID, inGrounad);
        this.setVolume(5);
        this.type="Wool";
    }

}
