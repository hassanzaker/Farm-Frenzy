package Model.Items;

public class Cake extends Item {
    public Cake(int x, int y ,String ID) {
        super(x, y , ID);
    }
    private final int  cost=0;

    public int getCost() {
        return cost;
    }
}
