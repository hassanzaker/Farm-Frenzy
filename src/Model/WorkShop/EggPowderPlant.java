package Model.WorkShop;

import Model.Items.EggPowder;
import Model.Ground;

public class EggPowderPlant extends WorkShop {
    public EggPowderPlant() {
        super(1);
        inputs.add("Egg");
        outputs.add("EggPowder");
        this.name = "EggPowderPlant";
    }



}
