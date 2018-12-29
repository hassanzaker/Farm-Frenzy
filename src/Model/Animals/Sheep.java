package Model.Animals;

import Model.Animals.ProducerAnimal;
import Model.Cell;
import Model.Ground;
import Model.Items.Egg;
import Model.Items.Wool;

public class Sheep extends ProducerAnimal {
    public Sheep(int x, int y, String ID) {
        super(x, y, ID);
        this.name = "sheep" ;
        this.cost = 1000;
    }


    @Override
    public void produce(Ground ground) {
        ground.getCells()[this.row - 1][this.column - 1].setItemAmount(ground.getCells()[this.row - 1][this.column - 1].getItemAmount() + 1);
        ground.addItem(new Wool(this.row, this.column, "0", true));
    }


}