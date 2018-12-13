package Model.WorkShop;

import Model.Ground;
import Model.Items.Cookie;
import Model.Items.EggPowder;
import Model.WorkShop.WorkShop;

public class CookieBakery extends WorkShop {
    public void workShopInput(Ground ground) throws Exception {
        if (ground.getWereHouse().getEggPowders().size() == 0) {
            throw new Exception("no eggpowder exist");
        }
        if (ground.getWereHouse().getEggPowders().size() >= this.level) {
            for (int i = 1; i <= this.level; i++) {
                ground.getWereHouse().deleteItem(ground.getWereHouse().getEggPowders().get(0));
            }
        } else {
            for (int i = 1; i <= ground.getWereHouse().getEggPowders().size(); i++) {
                ground.getWereHouse().deleteItem(ground.getWereHouse().getEggPowders().get(0));
            }
        }

    }

    public void workShopOutput(Ground ground) {
        if (ground.getWereHouse().getEggs().size() >= this.level) {
            for (int i = 1; i <= this.level; i++) {
                ground.addItem(new Cookie(this.rowForOutPut + i, this.columnForOutput, "0"));
            }
        } else {
            for (int i = 1; i <= ground.getWereHouse().getEggs().size(); i++) {
                ground.addItem(new Cookie(this.rowForOutPut + i, this.columnForOutput, "0"));
            }
        }
    }

}
