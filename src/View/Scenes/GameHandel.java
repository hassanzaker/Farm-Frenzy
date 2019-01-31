package View.Scenes;

import Controller.Controller;
import Controller.Level;
import Model.Animals.*;
import View.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import Controller.*;
import Model.Ground;
import Model.Time;
import Model.Well;
//import View.Buttons.WellButton;
import Model.WorkShop.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class GameHandel {
    private Stage stage;
    private Group mainRoot;
    Scene gameScene;

    Image image;

    {
        try {
            image = new Image(new FileInputStream("C:\\Users\\Zabba\\Desktop\\Textures\\back.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ImageView imageView = new ImageView(image);

    Image BuyDog;
    ImageView BuyDogView;

    {
        try {
            BuyDog = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Game\\UI\\Buttons\\buy_dog_1.png"));
            BuyDogView = new ImageView(BuyDog);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BuyHen;
    ImageView BuyHenView;

    {
        try {
            BuyHen = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Game\\UI\\Buttons\\buy_ostrich.png"));
            BuyHenView = new ImageView(BuyHen);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BuySheep;
    ImageView BuySheepView;

    {
        try {
            BuySheep = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Game\\UI\\Buttons\\buy_sheep.png"));
            BuySheepView = new ImageView(BuySheep);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BuyCat1;
    ImageView BuyCat1View;

    {
        try {
            BuyCat1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Game\\UI\\Buttons\\buy_cat_1.png"));
            BuyCat1View = new ImageView(BuyCat1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BuyCat2;
    ImageView BuyCat2View;

    {
        try {
            BuyCat2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Game\\UI\\Buttons\\buy_cat_2.png"));
            BuyCat2View = new ImageView(BuyCat2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BuyCow;
    ImageView BuyCowView;

    {
        try {
            BuyCow = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Game\\UI\\Buttons\\buy_cow.png"));
            BuyCowView = new ImageView(BuyCow);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public GameHandel(Group mainRoot, Scene gameScene, Stage stage) {
        this.mainRoot = mainRoot;
        this.stage = stage;
        this.gameScene = gameScene;
        this.stage.setScene(gameScene);
        build();
    }

    public void build() {
        ArrayList<Level> levels = new ArrayList<>();
        String[] types = new String[3];
        int[] need = new int[3];
        types[0] = "money";
        need[0] = 1000;
        types[1] = "egg";
        need[1] = 10;
        types[2] = "hen";
        need[2] = 5;
        levels.add(new Level(1, types, need, 4000));

        imageView.setFitHeight(750);
        imageView.setFitWidth(1000);
        mainRoot.getChildren().add(imageView);
        Controller controller = new Controller(levels, mainRoot);
        // WorkShop cook = new CakeBakery(mainRoot);
        controller.startWorkShop("CakeBakery");
        controller.startWorkShop("CookieBakery");
        controller.startWorkShop("EggPowderPlant");
        controller.startWorkShop("Spinnery");
        controller.startWorkShop("WevingFactory");
        controller.startWorkShop("SewingFactory");

//
//        for (int i=0 ; i<39 ; i++) {
//            for (int j=0 ; j<39 ; j++) {
//                Button button = new Button();
//                button.setVisible(true);
//                button.setLayoutX(250 + 13 * i);
//                button.setLayoutY(210 + 10 * j);
//                button.setScaleX(0.86);
//                button.setScaleY(0.4);
//                mainRoot.getChildren().add(button);
//            }
//        }




        buyButtons(controller);

        stage.setScene(gameScene);
        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame gamehandling = new KeyFrame(Duration.millis(500),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        controller.cyclePass();

                    }
                });
        tl.play();
    }

    public void buyButtons(Controller controller) {
        setButtons(BuyHenView, 60, 248 / 4, 30, 30, "Hen", controller);
        setButtons(BuySheepView, 60, 248 / 4, 90, 30, "Sheep", controller);
        setButtons(BuyCowView, 60, 248 / 4, 150, 30, "Cow", controller);
        setButtons(BuyDogView, 60, 248 / 4, 210, 30, "Dog", controller);
        setButtons(BuyCat1View, 60, 248 / 4, 270, 30, "Cat1", controller);
        setButtons(BuyCat2View, 60, 248 / 4, 330, 30, "Cat2", controller);
    }

    public void setButtons(ImageView imageView, int width, int height, double x, double y, String type, Controller controller) {
        imageView.setViewport(new Rectangle2D(0, 0, width, height));
        imageView.setX(x);
        imageView.setY(y);
        this.mainRoot.getChildren().add(imageView);
        imageView.setOnMouseClicked(event -> {
            final Animation animation =
                    new SpriteAnimation(imageView, Duration.millis(0), 4, 1, 0, 0, width, height);
            animation.setCycleCount(1);
            animation.play();
            //    this.upgrade();
            Random random = new Random();
            if (type.equals("Dog")) {

                Animal animal = new Dog(random.nextInt(40), random.nextInt(40), "1", mainRoot);
                try {
                    controller.getGrounds().get(controller.getLevel() - 1).buyAnimal(animal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("Cat1")) {

                Animal animal = new Cat(random.nextInt(40), random.nextInt(40), "1", mainRoot);
                try {
                    controller.getGrounds().get(controller.getLevel() - 1).buyAnimal(animal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("Hen")) {

                Animal animal = new Hen(random.nextInt(40), random.nextInt(40), "1", mainRoot);
                try {
                    controller.getGrounds().get(controller.getLevel() - 1).buyAnimal(animal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("Cow")) {

                Animal animal = new Cow(random.nextInt(40), random.nextInt(40), "1", mainRoot);
                try {
                    controller.getGrounds().get(controller.getLevel() - 1).buyAnimal(animal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("Sheep")) {

                Animal animal = new Sheep(random.nextInt(40), random.nextInt(40), "1", mainRoot);
                try {
                    controller.getGrounds().get(controller.getLevel() - 1).buyAnimal(animal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (type.equals("Cat2")) {

                Animal animal = new Cat(random.nextInt(40), random.nextInt(40), "1", mainRoot);
                ((Cat) animal).setLevel(2);
                try {
                    controller.getGrounds().get(controller.getLevel() - 1).buyAnimal(animal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Group getMainRoot() {
        return mainRoot;
    }

    public void setMainRoot(Group mainRoot) {
        this.mainRoot = mainRoot;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Image getBuyDog() {
        return BuyDog;
    }

    public void setBuyDog(Image buyDog) {
        BuyDog = buyDog;
    }

    public ImageView getBuyDogView() {
        return BuyDogView;
    }

    public void setBuyDogView(ImageView buyDogView) {
        BuyDogView = buyDogView;
    }

    public Image getBuyHen() {
        return BuyHen;
    }

    public void setBuyHen(Image buyHen) {
        BuyHen = buyHen;
    }

    public ImageView getBuyHenView() {
        return BuyHenView;
    }

    public void setBuyHenView(ImageView buyHenView) {
        BuyHenView = buyHenView;
    }

    public Image getBuySheep() {
        return BuySheep;
    }

    public void setBuySheep(Image buySheep) {
        BuySheep = buySheep;
    }

    public ImageView getBuySheepView() {
        return BuySheepView;
    }

    public void setBuySheepView(ImageView buySheepView) {
        BuySheepView = buySheepView;
    }

    public Image getBuyCat1() {
        return BuyCat1;
    }

    public void setBuyCat1(Image buyCat1) {
        BuyCat1 = buyCat1;
    }

    public ImageView getBuyCat1View() {
        return BuyCat1View;
    }

    public void setBuyCat1View(ImageView buyCat1View) {
        BuyCat1View = buyCat1View;
    }

    public Image getBuyCat2() {
        return BuyCat2;
    }

    public void setBuyCat2(Image buyCat2) {
        BuyCat2 = buyCat2;
    }

    public ImageView getBuyCat2View() {
        return BuyCat2View;
    }

    public void setBuyCat2View(ImageView buyCat2View) {
        BuyCat2View = buyCat2View;
    }

    public Image getBuyCow() {
        return BuyCow;
    }

    public void setBuyCow(Image buyCow) {
        BuyCow = buyCow;
    }

    public ImageView getBuyCowView() {
        return BuyCowView;
    }

    public void setBuyCowView(ImageView buyCowView) {
        BuyCowView = buyCowView;
    }
}
