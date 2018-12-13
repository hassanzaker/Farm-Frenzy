package Model.Animals;

import Model.Cell;

public class Cow extends ProducerAnimal {
    public Cow(int x, int y , String ID) {
        super(x, y, ID);
    }


    @Override
    public void produce(Cell[][] cells) {
        cells[row - 1][column - 1].setItemAmount(cells[row - 1][column - 1].getItemAmount() + 1);
    }




}
