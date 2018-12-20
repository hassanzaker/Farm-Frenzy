package Model.WorkShop;

import Model.Ground;
import Model.Items.Cookie;
import Model.Items.EggPowder;
import Model.WorkShop.WorkShop;

public class CookieBakery extends WorkShop {
    public CookieBakery(int maxLevel) {
        super(maxLevel);
        inputs.add("EggPowder");
        outputs.add("Cookie");
    }
}
