package Model.WorkShop;

import java.util.ArrayList;

public class CustomeWorkShop extends WorkShop {
    public CustomeWorkShop(int maxLevel , ArrayList<String> inputs , ArrayList<String> outputs) {
        super(maxLevel, 7);
        this.inputs=inputs;
        this.outputs=outputs;
    }
}
