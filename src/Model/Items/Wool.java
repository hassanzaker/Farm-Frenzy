package Model.Items;

public class Wool extends Item {
    public Wool(int x, int y ,String ID) {
        super(x, y , ID);
    }
    private final int  cost=0;

    public int getCost() {
        return cost;
    }
}
