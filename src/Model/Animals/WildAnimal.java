package Model.Animals;

import Model.Cell;
import Model.Ground;
import javafx.scene.Group;

public abstract class WildAnimal extends Animal {
    protected int volume;

    public WildAnimal(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void checkTime(Ground ground) throws Exception {
        super.checkTime(ground);
        crash(ground);
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setWildAnimalAmount(cell.getWildAnimalAmount() + a);
    }

    public abstract void eat();

//    @Override
//    public int direction(Ground ground) {
//        Random random = new Random();
//        return random.nextInt(4) + 1;
//    }

    public void crash(Ground ground) {
        for (int i = 0; i < ground.getProducerAnimals().size(); i++) {
            if (ground.getProducerAnimals().get(i).getRow() == this.row &&
                    ground.getProducerAnimals().get(i).getColumn() == this.column) {
                ground.deleteAnimal(ground.getProducerAnimals().get(i));
            }
        }
        for (int i = 0; i < ground.getCats().size(); i++) {
            if (ground.getCats().get(i).getRow() == this.row &&
                    ground.getCats().get(i).getColumn() == this.column) {
                ground.deleteAnimal(ground.getCats().get(i));
            }
        }
        for (int i = 0; i < ground.getDogs().size(); i++) {
            if (ground.getDogs().get(i).getRow() == this.row &&
                    ground.getDogs().get(i).getColumn() == this.column) {
                ground.deleteAnimal(ground.getDogs().get(i));
                ground.deleteAnimal(this);
            }
        }
        for (int i = 0; i < ground.getItems().size(); i++) {
            if (ground.getItems().get(i).getRow() == this.row &&
                    ground.getItems().get(i).getColumn() == this.column) {
                ground.deleteItem(ground.getItems().get(i));
            }
        }

    }
}