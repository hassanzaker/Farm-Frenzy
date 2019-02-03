package View.Scenes;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.zip.CheckedInputStream;

public class Menu {
    private Stage stage;
    private Group mainRoot;
    private Circle circle;
    //private Pane pane;
    private Label label;
    private TextField textField;

    Scene MenuScene;
    Scene enterScene;
    private Image MenuPicture = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\MenuPicture.jpg"));;
    ImageView MenuPictureView= new ImageView(MenuPicture);
    private Image PlayPicture = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\PlayButton.png"));;
    ImageView PlayPictureView= new ImageView(PlayPicture);

   // Scene Gamescene = new Scene(mainRoot , 1000 , 750 );
    public Menu(Group mainRoot ,  Scene MenuScene , Stage stage ,Scene enterScene) throws FileNotFoundException {
        this.mainRoot = mainRoot;
        this.stage = stage;
        this.MenuScene = MenuScene;
        this.enterScene = enterScene;
        build();
    }
    public void build(){
        this.stage.setScene(this.MenuScene);
        MenuPictureView.setFitWidth(1000);
        MenuPictureView.setFitHeight(750);
        circle = new Circle(550 , 150 , 40 , Color.BLACK);
        mainRoot.getChildren().add(MenuPictureView);
        PlayBotton();
       // mainRoot.getChildren().add(PlayPictureView);

    }
    public void PlayBotton(){
   //     PlayPictureView.relocate(500 , 400);
     //   PlayPictureView.setX(400);
       // PlayPictureView.setY(500);
      //  this.mainRoot.getChildren().add(PlayPictureView);
        mainRoot.getChildren().add(circle);
        circle.setOnMouseClicked(event -> {
           stage.setScene(enterScene);
        });

        label = new Label("menu");
        label.setLayoutX(945);
        label.setLayoutY(17);
        label.setVisible(true);
        label.setTextFill(Color.RED);
        label.setGraphicTextGap(3);
        label.setFont(Font.font(20));
        mainRoot.getChildren().add(label);



        label.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("asf");
            }
        });
        label.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(1);
            }
        });



    }
}
