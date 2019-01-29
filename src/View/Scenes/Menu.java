package View.Scenes;

import javafx.scene.Group;
import javafx.scene.Scene;

public class Menu {
    Group mainRoot;
    Scene scene = new Scene(mainRoot , 1000 , 750 );
    public Menu(Group mainRoot){
        this.mainRoot=mainRoot;

    }
}
