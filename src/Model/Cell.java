package Model;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Cell {
    private Group mainRoot;
    Rectangle rectangle = new Rectangle();
    private int grassAmount;
    private int wildAnimalAmount;
    private int domesticAnimalAmount;
    private int itemAmount;
    private int numberOfDogs;
    private int numberOfCats;
    private int x;
    private int y;


    public Cell(int x, int y , Group mainRoot, Ground ground) {
        this.mainRoot = mainRoot;
        this.x = x;
        this.y = y;
        rectangle.setWidth(13);
        rectangle.setHeight(10);
        rectangle.setX(250 + 13 * x);
        rectangle.setY(210 + 10 * y);
        rectangle.setVisible(true);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    ground.getWell().plant(ground, x, y);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mainRoot.getChildren().add(rectangle);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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
