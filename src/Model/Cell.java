package Model;

public class Cell {
    private int grassAmount;
    private int wildAnimalAmount;
    private int domesticAnimalAmount;
    private int itemAmount;
    private int numberOfDogs;
    private int numberOfCats;

    public int getNumberOfDogs() {
        return numberOfDogs;
    }

    public void setNumberOfDogs(int numberOfDogs) {
        this.numberOfDogs = numberOfDogs;
    }

    public int getNumberOfCats() {
        return numberOfCats;
    }

    public void setNumberOfCats(int numberOfCats) {
        this.numberOfCats = numberOfCats;
    }

    public void grassEaten(){
        this.grassAmount--;
    }

    public int getGrassAmount() {
        return grassAmount;
    }

    public void setGrassAmount(int grassAmount) {
        this.grassAmount = grassAmount;
    }

    public int getWildAnimalAmount() {
        return wildAnimalAmount;
    }

    public void setWildAnimalAmount(int wildAnimalAmount) {
        this.wildAnimalAmount = wildAnimalAmount;
    }

    public int getDomesticAnimalAmount() {
        return domesticAnimalAmount;
    }

    public void setDomesticAnimalAmount(int domesticAnimalAmount) {
        this.domesticAnimalAmount = domesticAnimalAmount;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }


    public String toString() {
        if (numberOfCats == 0 && numberOfDogs==0  && itemAmount==0 && domesticAnimalAmount==0 && wildAnimalAmount==0 ){
            if (grassAmount==0){
                return "O";
            }
            else {
                return "*";
            }
        }
        else {
            return "@";
        }
    }
}
