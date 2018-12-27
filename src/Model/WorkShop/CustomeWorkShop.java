package Model.WorkShop;

import java.util.ArrayList;

public class CustomeWorkShop extends WorkShop {
    public CustomeWorkShop(String name, ArrayList<String> inputs , ArrayList<String> outputs) {
        super(7);
        this.inputs=inputs;
        this.outputs=outputs;
        this.name = name;
    }
}
