package Model.Items;

public class Milk extends Item {
    public Milk(int x, int y ,String ID) {
        super(x, y , ID);
    }
    private final int  cost=0;

    public int getCost() {
        return cost;
    }
}
