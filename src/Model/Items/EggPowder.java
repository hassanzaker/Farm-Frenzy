package Model.Items;

import Model.Items.Item;

public class EggPowder extends Item {
    public EggPowder(int x, int y ,String ID) {
        super(x, y , ID);
    }
    private final int  cost=0;

    public int getCost() {
        return cost;
    }
}
