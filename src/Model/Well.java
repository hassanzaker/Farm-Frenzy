package Model;

public class Well {
    private int capacity;
    private int timeToFill;
    private int currentTime;
    private int currentAmount;
    private int level;
    private int cost;

    public Well() {
        this.level = 1;
        this.timeToFill = 10;
        this.capacity = 5;
        this.currentAmount = this.capacity;
        cost=19;
    }

    public void plant(Ground ground, int x, int y) throws Exception{
        if (this.currentAmount==0){
            throw new Exception("no water!");
        }
        ground.getCells()[x - 1][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x - 2][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x - 1][y - 2].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x - 2][y - 2].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x ][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x - 1][y].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x ][y ].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x - 2][y ].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        ground.getCells()[x ][y - 2].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        this.currentAmount--;

    }

    public void upgrade(int money) throws Exception {
        if (this.level == 3) {
            throw new Exception("well is max level!");
        }
        if (money < computeUpgradeCost()) {
            throw new Exception("not enough money!");
        }
        this.level++;
        this.timeToFill -= 2;
        this.capacity += 2;
        this.currentAmount = this.capacity;
        this.cost -= 2;

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

    public void fill(int money) throws Exception{
        if (money < cost){
            throw new Exception("not enough money!");
        }
        this.currentAmount = this.capacity;
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

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
