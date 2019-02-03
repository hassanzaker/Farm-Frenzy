package Model;

import View.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
    private int width;
    private int height;
    private Image grass;
    ImageView grassView;

    {
        try {
            grass = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Grass\\grass3.png"));
            grassView = new ImageView(grass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Cell(int y, int x, Group mainRoot, Ground ground) {
        this.mainRoot = mainRoot;
        this.x = x;
        this.y = y;
        this.width=250 + 26 * x - 13;
        this.height = 210 + 20 * y - 10;
        setGrass(ground);


    }

    public void setGrass(Ground ground) {
     //   grassView.setFitHeight(40);
     //   grassView.setFitWidth(52);
        rectangle.setWidth(26);
        rectangle.setHeight(20);
        rectangle.setX(250 + 26 * x);
        rectangle.setY(210 + 20 * y);
        rectangle.setVisible(true);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        mainRoot.getChildren().add(rectangle);
        final Group gp = mainRoot;
        rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    ground.getWell().plant(ground, x, y);

                    grassView.setViewport(new Rectangle2D(0, 0, 192/4, 192/4));
                    grassView.setX(250 + 26 * x -13);
                    grassView.setY(210 + 20 * y -10);
                    final Animation animation =
                            new SpriteAnimation(grassView, Duration.millis(50), 16, 4, 0, 0, 192/4, 192/4);
                    animation.setCycleCount(1);
                    animation.play();
                    gp.getChildren().add(grassView);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });








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

    public void grassEaten() {
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

    public Group getMainRoot() {
        return mainRoot;
    }

    public void setMainRoot(Group mainRoot) {
        this.mainRoot = mainRoot;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getGrass() {
        return grass;
    }

    public void setGrass(Image grass) {
        this.grass = grass;
    }

    public ImageView getGrassView() {
        return grassView;
    }

    public void setGrassView(ImageView grassView) {
        this.grassView = grassView;
    }

    public String toString() {
        if (numberOfCats == 0 && numberOfDogs == 0 && itemAmount == 0 && domesticAnimalAmount == 0 && wildAnimalAmount == 0) {
            if (grassAmount == 0) {
                return "O";
            } else {
                return "*";
            }
        } else {
            return "@";
        }
    }
}
