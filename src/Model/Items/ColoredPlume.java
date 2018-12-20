package Model.Items;

public class ColoredPlume extends Item {

    private final int buyCost = 300;
    private final int saleCost = 150;

    public ColoredPlume(int x, int y, String ID,Boolean inGrounad) {
        super(x, y, ID, inGrounad);
        this.setVolume(2);
        this.type="ColoredPlume";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
