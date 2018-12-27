package Model.WorkShop;

public class SewingFactory extends WorkShop{
    public SewingFactory() {
        super(6);
        inputs.add("Fabric");
        inputs.add("Plume");
        outputs.add("CarnivalFactory");
        this.name = "SewingFactory";
    }

}
