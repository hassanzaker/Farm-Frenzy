package View.Scenes;

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
    private Image MenuPicture;
    ImageView MenuPictureView;
    {
        try {
            MenuPicture = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\MenuPicture.png"));
            MenuPictureView = new ImageView(MenuPicture);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
   // Scene Gamescene = new Scene(mainRoot , 1000 , 750 );
    public Menu(Group mainRoot , Stage stage , Scene MenuScene ){
        this.mainRoot=mainRoot;
        this.stage=stage;
        this.MenuScene=MenuScene;
        build();

    }
    public void build(){
        MenuPictureView.setX(1000);
        MenuPictureView.setY(750);
        this.stage.setScene(this.M);

    }

}
