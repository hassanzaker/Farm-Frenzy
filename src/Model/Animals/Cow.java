package Model.Animals;

import Model.Cell;
import Model.Ground;
import Model.Items.Egg;
import Model.Items.Milk;

public class Cow extends ProducerAnimal {
    public Cow(int x, int y , String ID) {
        super(x, y, ID);
    }


    @Override
    public void produce(Ground ground) {
        ground.getCells()[this.row-1][this.column-1].setItemAmount(ground.getCells()[this.row-1][this.column-1].getItemAmount()+1);
        ground.addItem(new Milk(this.row, this.column, "0"));
    }




}
