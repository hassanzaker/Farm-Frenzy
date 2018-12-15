package Model.WorkShop;

import Model.Items.EggPowder;
import Model.Ground;

public class EggPowderPlant extends WorkShop {
    public EggPowderPlant() {
        super();
        inputs.add("Egg");
        outputs.add("EggPowder");
    }

    public void workShopInput(Ground ground) throws Exception {
        if (ground.getWereHouse().getEggs().size() == 0) {
            throw new Exception("no egg exist");
        }
        if (ground.getWereHouse().getEggs().size() >= this.level) {
            for (int i = 1; i <= this.level; i++) {
                ground.getWereHouse().deleteItem(ground.getWereHouse().getEggs().get(0));
            }
        } else {
            for (int i = 1; i <= ground.getWereHouse().getEggs().size(); i++) {
                ground.getWereHouse().deleteItem(ground.getWereHouse().getEggs().get(0));
            }
        }

    }

    public void workShopOutput(Ground ground) {
        if (ground.getWereHouse().getEggs().size() >= this.level) {
            for (int i = 1; i <= this.level; i++) {
                ground.addItem(new EggPowder(this.rowForOutPut + i, this.columnForOutput, "0"));
            }
        } else {
            for (int i = 1; i <= ground.getWereHouse().getEggs().size(); i++) {
                ground.addItem(new EggPowder(this.rowForOutPut + i, this.columnForOutput, "0"));
            }
        }
    }

}
