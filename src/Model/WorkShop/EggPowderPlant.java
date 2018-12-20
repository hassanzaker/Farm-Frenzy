package Model.WorkShop;

import Model.Items.EggPowder;
import Model.Ground;

public class EggPowderPlant extends WorkShop {
    public EggPowderPlant(int maxLevel) {
        super(maxLevel);
        inputs.add("Egg");
        outputs.add("EggPowder");
    }



}
