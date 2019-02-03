package View;

import Controller.*;
import Model.Ground;
import Model.Time;
import Model.Well;
//import View.Buttons.WellButton;
import Model.WorkShop.*;
import View.Scenes.Enter;
import View.Scenes.GameHandel;
import View.Scenes.Menu;
import View.Scenes.MenuScene;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FXView extends Application {
    private Group mainRoot = new Group();
    private Group menuRoot = new Group();
    private Group missionRoot = new Group();
    private Group enterRoot = new Group();
    private Group menu1Root = new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {

        String url = new File("C:\\Users\\zabba\\Desktop\\ap.mp3").toURI().toString();
        Media media = new Media(url);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(1);
        mediaPlayer.setAutoPlay(true);
        //        mediaPlayer.play();
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(-1);

       Scene gameScene = new Scene(mainRoot , 1000 , 750 );
        Scene MenuScene =  new Scene(menuRoot , 1000 , 750 );
        Scene missionScene = new Scene(missionRoot , 1000 , 750 );
        Scene enterSene = new Scene(enterRoot , 500 , 750);
        Scene Menu1 = new Scene(menu1Root , 500 , 500);
        GameHandel gameHandel = new GameHandel(mainRoot , gameScene,primaryStage);
     //   Menu menu = new Menu(menuRoot , MenuScene  , primaryStage);
        View.Scenes.Menu menu1 = new Menu(menuRoot , MenuScene  , primaryStage , enterSene);
        Enter enter = new Enter(enterRoot , enterSene ,primaryStage , Menu1);
        View.Scenes.MenuScene menuScene = new MenuScene(menu1Root , Menu1 , primaryStage , gameScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
