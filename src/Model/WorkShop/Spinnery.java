package Model.WorkShop;

import Model.WorkShop.WorkShop;

public class Spinnery extends WorkShop {
    public Spinnery() {
        super(4);
        inputs.add("Wool");
        outputs.add("Sewing");
        this.name = "Spinnery";
    }
}
