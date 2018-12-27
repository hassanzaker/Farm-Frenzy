package Model.WorkShop;

import Model.WorkShop.WorkShop;

public class WevingFactory extends WorkShop {
    public WevingFactory() {
        super(5);
        inputs.add("Sewing");
        outputs.add("Fabric");
        this.name = "WevingFactory";
    }
}
