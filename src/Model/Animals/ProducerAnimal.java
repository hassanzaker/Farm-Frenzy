package Model.Animals;

import Model.Cell;
import Model.Ground;

public abstract class ProducerAnimal extends Animal {
    protected int maxEnergy;
    protected int energyLevel;
    protected int timeToProduce;
    protected int currentTime;

    public ProducerAnimal(int x, int y, String ID) {
        super(x, y, ID);
        this.timeToProduce = 15;
        maxEnergy = 20;
        this.energyLevel = 20;
    }


    public void checkTime(Ground ground) throws Exception {
        super.checkTime(ground);
        this.energyLevel--;
        this.currentTime++;
        if (this.energyLevel < 10 && this.energyLevel > 0) {
            eat(ground.getCells()[this.row-1][this.getColumn()-1]);
        } else if (this.energyLevel <= 0) {
            ground.deleteAnimal(this);
        }
        if (this.currentTime == this.timeToProduce) {
            produce(ground);
            this.currentTime = 0;
        }
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

    public void eat(Cell cell) {
        if (cell.getGrassAmount() == 0) {

        } else {
            cell.grassEaten();
            this.energyLevel++;
        }
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setDomesticAnimalAmount(cell.getDomesticAnimalAmount() + a);
    }

    public abstract void produce(Ground ground);

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}