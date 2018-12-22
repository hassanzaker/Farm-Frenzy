package Model.WorkShop;

import Model.Ground;
import Model.Items.Cake;
import Model.Items.Cookie;
import Model.WorkShop.WorkShop;

public class CakeBakery extends WorkShop {
    public CakeBakery(int maxLevel) {
        super(maxLevel, 3);
        inputs.add("Flour");
        inputs.add("Cookie");
        outputs.add("Cake");
    }

}
