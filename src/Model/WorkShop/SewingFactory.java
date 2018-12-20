package Model.WorkShop;

public class SewingFactory extends WorkShop{
    public SewingFactory(int maxLevel) {
        super(maxLevel);
        inputs.add("Fabric");
        inputs.add("Plume");
        outputs.add("CarnivalFactory");
    }

}
