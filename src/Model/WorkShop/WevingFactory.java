package Model.WorkShop;

import Model.WorkShop.WorkShop;

public class WevingFactory extends WorkShop {
    public WevingFactory(int maxLevel) {
        super(maxLevel);
        inputs.add("Sewing");
        outputs.add("Fabric");
    }
}
