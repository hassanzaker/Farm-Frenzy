package View.Scenes;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class MenuScene {
    private Stage stage;
    private Group mainRoot;
    private TextField textField;
    private Button resume;
    private Button map;
    private Button setting;
    private Button exit;

    Scene MenuScene;
    Scene gameScene;

    public MenuScene(Group mainRoot ,  Scene MenuScene , Stage stage ,Scene gameScene) throws FileNotFoundException {
        this.mainRoot = mainRoot;
        this.stage = stage;
        this.MenuScene = MenuScene;
        this.gameScene = gameScene;
        build();
    }

    public void build(){
        this.stage.setScene(this.MenuScene);
        resume = new Button();
        resume.setLayoutX(20);
        resume.setLayoutY(20);
        resume.setText("Resume");

        Label label = new Label("WELCOME hassan");
        mainRoot.getChildren().add(label);
        label.setLayoutY(20);
        label.setLayoutX(10);
        label.setFont(Font.font(16));
        resume = new Button("Resume");
        resume.setLayoutX(20);
        resume.setLayoutY(50);
        resume.setFont(Font.font(20));
        resume.setMinWidth(100);


        map = new Button("map");
        map.setFont(Font.font(20));
        map.setLayoutY(100);
        map.setLayoutX(20);
        map.setMinWidth(100);

        setting = new Button("setting");
        setting.setMinWidth(100);
        setting.setLayoutX(20);
        setting.setLayoutY(150);
        setting.setFont(Font.font(20));

        exit = new Button("exit");
        exit.setFont(Font.font(20));
        exit.setLayoutY(200);
        exit.setLayoutX(20);
        exit.setMinWidth(100);

        mainRoot.getChildren().add(resume);
        mainRoot.getChildren().add(map);
        mainRoot.getChildren().add(setting);
        mainRoot.getChildren().add(exit);

    }

}
