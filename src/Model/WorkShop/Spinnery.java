package Model.WorkShop;

import Model.WorkShop.WorkShop;

public class Spinnery extends WorkShop {
    public Spinnery(int maxLevel) {
        super(maxLevel);
        inputs.add("Wool");
        outputs.add("Sewing");
    }
}
