package View.Scenes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Enter {
    private Group mainRoot;
    private Stage stage;
    private String user;

    Scene MenuScene;
    Scene gameScene;
    public Enter(Group mainRoot , Scene MenuScene , Stage stage , Scene gameScene) throws FileNotFoundException {
        this.mainRoot = mainRoot;
        this.stage = stage;
        this.MenuScene = MenuScene;
        this.gameScene = gameScene;
        build();
    }

    public void build(){
        this.stage.setScene(this.MenuScene);
        Label label = new Label("enter your name");
        mainRoot.getChildren().add(label);
        label.setLayoutY(20);
        label.setLayoutX(20);
        label.setFont(Font.font(16));
        TextField textField = new TextField();
        textField.setLayoutX(20);
        textField.setLayoutY(50);
        textField.setVisible(true);
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                user = textField.getText();
                textField.clear();
            }
        });
        mainRoot.getChildren().add(textField);

        Button button = new Button("let's Go!");
        button.setLayoutX(50);
        button.setLayoutY(80);
        button.setFont(Font.font(20));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                user = textField.getText();
                textField.clear();
            }
        });
        mainRoot.getChildren().add(button);

    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
