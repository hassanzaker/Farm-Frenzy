package Model.WorkShop;

import Model.WorkShop.WorkShop;

public class Spinnery extends WorkShop {
    public Spinnery(int maxLevel) {
        super(maxLevel, 4);
        inputs.add("Wool");
        outputs.add("Sewing");
    }
}
