package Model.WorkShop;

public class SewingFactory extends WorkShop{
    public SewingFactory() {
        super(6);
        inputs.add("Fabric");
        inputs.add("ColoredPlume");
        outputs.add("CarnivalDress");
        this.name = "SewingFactory";
    }

}
