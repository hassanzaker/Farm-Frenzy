package View.Scenes;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Menu {
    private Stage stage;
    private Group mainRoot;
    Scene MenuScene;
    Scene gameScene;
    private Image MenuPicture = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\MenuPicture.jpg"));;
    ImageView MenuPictureView= new ImageView(MenuPicture);
    private Image PlayPicture = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\PlayButton.png"));;
    ImageView PlayPictureView= new ImageView(PlayPicture);

   // Scene Gamescene = new Scene(mainRoot , 1000 , 750 );
    public Menu(Group mainRoot ,  Scene MenuScene , Stage stage ,Scene gameScene) throws FileNotFoundException {
        this.mainRoot = mainRoot;
        this.stage = stage;
        this.MenuScene = MenuScene;
        this.gameScene = gameScene;
        build();

    }
    public void build(){
        this.stage.setScene(this.MenuScene);
        MenuPictureView.setFitWidth(1000);
        MenuPictureView.setFitHeight(750);
        mainRoot.getChildren().add(MenuPictureView);
        PlayBotton();
       // mainRoot.getChildren().add(PlayPictureView);

    }
    public void PlayBotton(){
   //     PlayPictureView.relocate(500 , 400);
        PlayPictureView.setX(400);
        PlayPictureView.setY(500);
        this.mainRoot.getChildren().add(PlayPictureView);
        PlayPictureView.setOnMouseClicked(event -> {
           stage.setScene(gameScene);
        });
    }
}
