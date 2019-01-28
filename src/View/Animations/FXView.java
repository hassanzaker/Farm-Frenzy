package View.Animations;

import Controller.*;
import Model.Time;
import Model.Well;
//import View.Buttons.WellButton;
import Model.WorkShop.CakeBakery;
import Model.WorkShop.CookieBakery;
import Model.WorkShop.EggPowderPlant;
import Model.WorkShop.WorkShop;
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
import java.util.ArrayList;

public class FXView extends Application {
    private Group mainRoot = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {

        ArrayList<Level> levels = new ArrayList<>();
        String[] types = new String[3];
        int[] need = new int[3];
        types[0] = "money" ;
        need[0] = 1000;
        types[1] = "egg" ;
        need[1] = 10;
        types[2] = "hen" ;
        need[2] = 5;
        levels.add(new Level(1, types, need, 4000));
        Image image = new Image(new FileInputStream("C:\\Users\\Zabba\\Desktop\\Textures\\back.png" ));

        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(750);
        imageView.setFitWidth(1000);
        mainRoot.getChildren().add(imageView);
        Controller controller = new Controller(levels, mainRoot);
        WorkShop cook = new CakeBakery(mainRoot);
        WorkShop cook1 = new EggPowderPlant(mainRoot);
        controller.startWorkShop(cook1);
        ((EggPowderPlant) cook1).show();

        Scene scene =  new Scene(mainRoot, 1000, 750, Color.rgb(180, 180, 180));
        primaryStage.setScene(scene);
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
        primaryStage.show();
      //  WellButton wellButton = new WellButton(scene , controller ,mainRoot);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
