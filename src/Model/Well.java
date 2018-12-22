package Model;

public class Well {
    private int capacity;
    private int timeToFill;
    private int currentTime;
    private int currentAmount;
    private int level;

    public Well() {
        this.level = 1;
        this.timeToFill = 10;
        this.capacity = 5;
        this.currentAmount = this.capacity;
    }

    public void plant(Ground ground, int x, int y) {
        ground.getCells()[x - 1][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);

    }

    public void upgrade() throws Exception {
        if (this.level == 3) {
            throw new Exception("well is max level!");
        } else {
            this.level++;
            this.timeToFill -= 2;
            this.capacity += 2;
            this.currentAmount = this.capacity;
        }
    }

    public boolean cehckTime() {
        this.currentTime++;
        if (this.currentTime == this.timeToFill) {
            this.currentTime = 0;
            return true;  // to fill well
        } else
            return false;
    }

    public int computeUpgradeCost() {
        return this.level * this.level * 100;  // ye formol az khodam dar avordam
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void fill(int amount) {

    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTimeToFill() {
        return timeToFill;
    }

    public void setTimeToFill(int timeToFill) {
        this.timeToFill = timeToFill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
