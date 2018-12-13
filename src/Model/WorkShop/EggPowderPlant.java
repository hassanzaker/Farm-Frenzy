package Model.WorkShop;

import Model.WorkShop.WorkShop;
import Model.Ground;

import java.util.ArrayList;

public class EggPowderPlant extends WorkShop {
    public void workShopInput(Ground ground) throws Exception{
        if (ground.getEggs().size()==0)
            throw new Exception("no egg");
        for (int i=0 ; i<this.level ; i++){
            ground.deleteItem(ground.getEggs().get(0));
        }
    }

    public void workShopOutput(Ground ground){

    }

}
