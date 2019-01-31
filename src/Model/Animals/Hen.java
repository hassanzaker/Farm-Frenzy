package Model.Animals;

import Model.Ground;
import Model.Items.Egg;
import javafx.scene.Group;

public class Hen extends ProducerAnimal {


    public Hen(int x, int y , String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.name = "hen";
        this.cost = 100;
    }

    @Override
    public void produce(Ground ground) {
        ground.getCells()[this.row-1][this.column-1].setItemAmount(ground.getCells()[this.row-1][this.column-1].getItemAmount()+1);
        ground.addItem(new Egg(this.row, this.column, "0",true , ground.getMainRoot()));
    }



}