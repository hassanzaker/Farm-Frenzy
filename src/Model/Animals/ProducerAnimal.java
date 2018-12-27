package Model.Animals;

import Model.Cell;
import Model.Ground;

import java.util.Random;

public abstract class ProducerAnimal extends Animal {
    protected int maxEnergy;
    protected int energyLevel;
    protected int timeToProduce;
    protected int currentTime;

    public ProducerAnimal(int x, int y, String ID) {
        super(x, y, ID);
    }

    @Override
    public int direction(Ground ground) {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }

    public void checkTime(Ground ground){
        this.currentTime++;
        if (this.currentTime == this.timeToProduce){
            produce(ground);
            this.currentTime=0;
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

    public abstract void produce(Ground ground);

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}
