package Model;

import View.Animations.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Well {
    private Group mainRoot;
    private int capacity;
    private int timeToFill;
    private int currentTime;
    private int currentAmount;
    private int level;
    private int cost;
    private Image WellImage1;
    ImageView wellView1;
    {
        try {
            WellImage1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Well\\01.png"));
            wellView1 = new ImageView(WellImage1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image WellImage2;
    ImageView wellView2;
    {
        try {
            WellImage2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Well\\02.png"));
            wellView2 = new ImageView(WellImage2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image WellImage3;
    ImageView wellView3;
    {
        try {
            WellImage3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Well\\03.png"));
             wellView3 = new ImageView(WellImage3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image WellImage4;
    ImageView wellView4;
    {
        try {
            WellImage4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Well\\04.png"));
            wellView4 = new ImageView(WellImage4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Well(Group mainRoot) {
        this.mainRoot = mainRoot;
        this.level = 1;
        this.timeToFill = 10;
        this.capacity = 5;
        this.currentAmount = this.capacity;
        cost=19;
        this.show();

    }

    public void show(){
        wellView1.setViewport(new Rectangle2D(0, 0, 600/4, 544/4));
        wellView1.setX(450);
        wellView1.setY(80);
        this.mainRoot.getChildren().add(wellView1);
        wellView1.setOnMouseClicked(event -> {
            final Animation animation =
                    new SpriteAnimation(wellView1, Duration.millis(1000), 16, 4, 0, 0, 600/4, 544/4);
            animation.setCycleCount(timeToFill);
            animation.play();
        });
    }
    public void remove(){
        this.mainRoot.getChildren().remove(wellView1);
        this.mainRoot.getChildren().remove(wellView2);
        this.mainRoot.getChildren().remove(wellView3);
        this.mainRoot.getChildren().remove(wellView4);
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
        if (this.currentAmount > 0){
            throw new Exception("well is not empty!");
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

    @Override
    public String toString() {
        String s = "" ;
        s += "well level : " + String.valueOf(this.level) + "\n" +
                "capacity : " + String.valueOf(this.capacity) + "\n" +
                "current amount : " + String.valueOf(this.currentAmount) + "\n" +
                "time to fill : " + String.valueOf(this.timeToFill) + "\n";
        return s;
    }
}
