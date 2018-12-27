package Model;

public class Mission {
    private String type;
    private int amount;
    private int needAmount;
    private boolean isDone;

    public Mission(String type, int max) {
        this.type = type;
        this.amount = 0;
        this.needAmount = max;
        this.isDone = false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addItem() {
        this.amount++;
    }

    public void check(){
        if (this.amount == this.needAmount){
            isDone = true;
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getNeedAmount() {
        return needAmount;
    }

    public void setNeedAmount(int needAmount) {
        this.needAmount = needAmount;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return this.type + " : " + this.amount + "/" + this.needAmount + "\n";
    }
}
