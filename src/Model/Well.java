package Model;

import View.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Ground ground;
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

    public Well(Group mainRoot, Ground ground) {
        this.mainRoot = mainRoot;
        this.level = 1;
        this.timeToFill = 10;
        this.capacity = 5;
        this.currentAmount = this.capacity;
        this.ground = ground;
        cost = 19;
        this.show();

    }

    public void setWell(ImageView imageView, int width, int height, double x, double y) {
        imageView.setViewport(new Rectangle2D(0, 0, width, height));
        imageView.setX(x);
        imageView.setY(y);
        this.mainRoot.getChildren().add(imageView);
        imageView.setOnMouseClicked(event -> {
            final Animation animation =
                    new SpriteAnimation(imageView, Duration.millis(1000), 16, 4, 0, 0, width, height);
            animation.setCycleCount(timeToFill);
            animation.play();
            //    this.upgrade();
            try {
                this.fill();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    public void show() {
        if (this.level == 1) {
            this.setWell(wellView1, 600 / 4, 544 / 4, 440, 70);
        } else if (this.level == 2) {
            this.setWell(wellView2, 592 / 4, 600 / 4, 440, 70);
        } else if (this.level == 3) {
            this.setWell(wellView3, 576 / 4, 632 / 4, 440, 70);
        } else if (this.level == 4) {
            this.setWell(wellView4, 592 / 4, 536 / 4, 440, 70);
        }
    }

    public void remove() {
        this.mainRoot.getChildren().remove(wellView1);
        this.mainRoot.getChildren().remove(wellView2);
        this.mainRoot.getChildren().remove(wellView3);
        this.mainRoot.getChildren().remove(wellView4);

    }


    public void plant(Ground ground, int x, int y) throws Exception {
        if (this.currentAmount == 0) {
            throw new Exception("no water!");
        }
        if (x > 0 && y > 0 && x < ground.getNumberOfRows() - 1 && y < ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x + 1][y].setGrassAmount(ground.getCells()[x + 1][y].getGrassAmount() + 1);
            ground.getCells()[x - 1][y].setGrassAmount(ground.getCells()[x - 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y + 1].setGrassAmount(ground.getCells()[x][y + 1].getGrassAmount() + 1);
            ground.getCells()[x][y - 1].setGrassAmount(ground.getCells()[x][y - 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y + 1].setGrassAmount(ground.getCells()[x + 1][y + 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y - 1].setGrassAmount(ground.getCells()[x + 1][y - 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y + 1].setGrassAmount(ground.getCells()[x - 1][y + 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        } else if (x > 0 && y > 0 && x == ground.getNumberOfRows() - 1 && y < ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x - 1][y].setGrassAmount(ground.getCells()[x - 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y + 1].setGrassAmount(ground.getCells()[x][y + 1].getGrassAmount() + 1);
            ground.getCells()[x][y - 1].setGrassAmount(ground.getCells()[x][y - 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y + 1].setGrassAmount(ground.getCells()[x - 1][y + 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        } else if (x > 0 && y > 0 && x < ground.getNumberOfRows() - 1 && y == ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x + 1][y].setGrassAmount(ground.getCells()[x + 1][y].getGrassAmount() + 1);
            ground.getCells()[x - 1][y].setGrassAmount(ground.getCells()[x - 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y - 1].setGrassAmount(ground.getCells()[x][y - 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y - 1].setGrassAmount(ground.getCells()[x + 1][y - 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        } else if (x == 0 && y > 0 && x < ground.getNumberOfRows() - 1 && y < ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x + 1][y].setGrassAmount(ground.getCells()[x + 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y + 1].setGrassAmount(ground.getCells()[x][y + 1].getGrassAmount() + 1);
            ground.getCells()[x][y - 1].setGrassAmount(ground.getCells()[x][y - 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y + 1].setGrassAmount(ground.getCells()[x + 1][y + 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y - 1].setGrassAmount(ground.getCells()[x + 1][y - 1].getGrassAmount() + 1);
        } else if (x > 0 && y == 0 && x < ground.getNumberOfRows() - 1 && y < ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x + 1][y].setGrassAmount(ground.getCells()[x + 1][y].getGrassAmount() + 1);
            ground.getCells()[x - 1][y].setGrassAmount(ground.getCells()[x - 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y + 1].setGrassAmount(ground.getCells()[x][y + 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y + 1].setGrassAmount(ground.getCells()[x + 1][y + 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y + 1].setGrassAmount(ground.getCells()[x - 1][y + 1].getGrassAmount() + 1);
        } else if (x == 0 && y == 0 && x < ground.getNumberOfRows() - 1 && y < ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x + 1][y].setGrassAmount(ground.getCells()[x + 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y + 1].setGrassAmount(ground.getCells()[x][y + 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y + 1].setGrassAmount(ground.getCells()[x + 1][y + 1].getGrassAmount() + 1);
        } else if (x == 0 && y > 0 && x < ground.getNumberOfRows() - 1 && y == ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x + 1][y].setGrassAmount(ground.getCells()[x + 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y - 1].setGrassAmount(ground.getCells()[x][y - 1].getGrassAmount() + 1);
            ground.getCells()[x + 1][y - 1].setGrassAmount(ground.getCells()[x + 1][y - 1].getGrassAmount() + 1);
        } else if (x > 0 && y == 0 && x == ground.getNumberOfRows() - 1 && y < ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x - 1][y].setGrassAmount(ground.getCells()[x - 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y + 1].setGrassAmount(ground.getCells()[x][y + 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y + 1].setGrassAmount(ground.getCells()[x - 1][y + 1].getGrassAmount() + 1);
        } else if (x > 0 && y > 0 && x == ground.getNumberOfRows() - 1 && y == ground.getNumberOfColumns() - 1) {
            ground.getCells()[x][y].setGrassAmount(ground.getCells()[x][y].getGrassAmount() + 1);
            ground.getCells()[x - 1][y].setGrassAmount(ground.getCells()[x - 1][y].getGrassAmount() + 1);
            ground.getCells()[x][y - 1].setGrassAmount(ground.getCells()[x][y - 1].getGrassAmount() + 1);
            ground.getCells()[x - 1][y - 1].setGrassAmount(ground.getCells()[x - 1][y - 1].getGrassAmount() + 1);
        }


    }

    public void upgrade(int money) throws Exception {
        if (this.level == 4) {
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
        this.remove();
        this.show();
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

    public void fill() throws Exception {
        if (ground.getMoney() < cost) {
            throw new Exception("not enough money!");
        }
        if (this.currentAmount > 0) {
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
        String s = "";
        s += "well level : " + String.valueOf(this.level) + "\n" +
                "capacity : " + String.valueOf(this.capacity) + "\n" +
                "current amount : " + String.valueOf(this.currentAmount) + "\n" +
                "time to fill : " + String.valueOf(this.timeToFill) + "\n";
        return s;
    }

    public Group getMainRoot() {
        return mainRoot;
    }

    public void setMainRoot(Group mainRoot) {
        this.mainRoot = mainRoot;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Image getWellImage1() {
        return WellImage1;
    }

    public void setWellImage1(Image wellImage1) {
        WellImage1 = wellImage1;
    }

    public ImageView getWellView1() {
        return wellView1;
    }

    public void setWellView1(ImageView wellView1) {
        this.wellView1 = wellView1;
    }

    public Image getWellImage2() {
        return WellImage2;
    }

    public void setWellImage2(Image wellImage2) {
        WellImage2 = wellImage2;
    }

    public ImageView getWellView2() {
        return wellView2;
    }

    public void setWellView2(ImageView wellView2) {
        this.wellView2 = wellView2;
    }

    public Image getWellImage3() {
        return WellImage3;
    }

    public void setWellImage3(Image wellImage3) {
        WellImage3 = wellImage3;
    }

    public ImageView getWellView3() {
        return wellView3;
    }

    public void setWellView3(ImageView wellView3) {
        this.wellView3 = wellView3;
    }

    public Image getWellImage4() {
        return WellImage4;
    }

    public void setWellImage4(Image wellImage4) {
        WellImage4 = wellImage4;
    }

    public ImageView getWellView4() {
        return wellView4;
    }

    public void setWellView4(ImageView wellView4) {
        this.wellView4 = wellView4;
    }
}
