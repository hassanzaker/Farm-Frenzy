package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;
import Model.Ground;

public abstract class ProducerAnimal extends Animal {
    protected int maxEnergy;
    protected int energyLevel;
    protected int timeToProduce;

    public ProducerAnimal(int x, int y, String ID) {
        super(x, y, ID);
    }

    public int getTimeToProduce() {
        return timeToProduce;
    }

    public void setTimeToProduce(int timeToProduce) {
        this.timeToProduce = timeToProduce;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void eat(Cell cell) throws Exception {
        if (cell.getGrassAmount() == 0)
            throw new Exception("there is no food!");
        else {
            cell.grassEaten();
            this.energyLevel++;
        }
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setDomesticAnimalAmount(cell.getDomesticAnimalAmount() + a);
    }

    public abstract void produce(Cell[][] cells);

}
