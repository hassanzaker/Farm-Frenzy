package View;

import Controller.*;
import Model.Ground;
import Model.Time;
import Model.Well;
//import View.Buttons.WellButton;
import Model.WorkShop.*;
import View.Scenes.GameHandel;
import View.Scenes.Menu;
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
    private Group menuRoot = new Group();
    private Group missionRoot = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {
       Scene gameScene = new Scene(mainRoot , 1000 , 750 );
        Scene MenuScene =  new Scene(menuRoot , 1000 , 750 );
        Scene missionScene = new Scene(missionRoot , 1000 , 750 );
        GameHandel gameHandel = new GameHandel(mainRoot , gameScene,primaryStage);
     //   Menu menu = new Menu(menuRoot , MenuScene  , primaryStage);
        View.Scenes.Menu menu1 = new Menu(menuRoot , MenuScene  , primaryStage , gameScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
