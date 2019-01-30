package View.Scenes;

import Controller.Controller;
import Controller.Level;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameHandel {
    private Group mainRoot;
    Scene scene = new Scene(mainRoot, 1000, 750, Color.rgb(180, 180, 180));
    Image image = new Image(new FileInputStream("C:\\Users\\Zabba\\Desktop\\Textures\\back.png"));

    ImageView imageView = new ImageView(image);
    public GameHandel(Group mainRoot){
        this.mainRoot=mainRoot;
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



        //primaryStage.setScene(scene);
        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.millis(500),
                new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        controller.cyclePass();

                    }
                });

        tl.getKeyFrames().add(moveBall);

        tl.play();
       // primaryStage.show();
        //  WellButton wellButton = new WellButton(scene , controller ,mainRoot);
    }
}
