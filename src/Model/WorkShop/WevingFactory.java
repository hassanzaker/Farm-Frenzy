package Model.WorkShop;

import Model.WorkShop.WorkShop;

public class WevingFactory extends WorkShop {
    public WevingFactory(int maxLevel) {
        super(maxLevel, 5);
        inputs.add("Sewing");
        outputs.add("Fabric");
    }
}
