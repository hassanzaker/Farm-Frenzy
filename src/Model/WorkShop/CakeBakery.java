package Model.WorkShop;

import Model.Ground;
import Model.Items.Cake;
import Model.Items.Cookie;
import Model.WorkShop.WorkShop;

public class CakeBakery extends WorkShop {
    public void workShopInput(Ground ground) throws Exception {
        if (ground.getWereHouse().getCookies().size() == 0) {
            throw new Exception("no cookie exist");
        }
        if (ground.getWereHouse().getFlours().size() == 0){
            throw new Exception("no flour exist");
        }
        int min = Math.min(ground.getWereHouse().getCookies().size(), ground.getWereHouse().getFlours().size());
        min = Math.min(min, this.level);
        for (int i=1 ; i<=min ; i++){
            ground.getWereHouse().addItem(ground.getWereHouse().getFlours().get(0));
            ground.getWereHouse().addItem(ground.getWereHouse().getCookies().get(0));
        }
    }

    public void workShopOutput(Ground ground) {
        int min = Math.min(ground.getWereHouse().getCookies().size(), ground.getWereHouse().getFlours().size());
        min = Math.min(min, this.level);
        for (int i=1 ; i<=min ; i++){
            ground.addItem(new Cake(this.rowForOutPut, this.columnForOutput, "0"));
        }
    }
}
