package Model.WorkShop;

import Model.Ground;
import View.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class CustomeWorkShop extends WorkShop {
    public void show(){

    }
    public void remove(){

    }
    public void setWorkShop(ImageView imageView , int width , int height , double x , double y){
        imageView.setViewport(new Rectangle2D(0 , 0 , width , height));
        imageView.setX(x);
        imageView.setY(y);
        this.mainRoot.getChildren().add(imageView);
        imageView.setOnMouseClicked(event -> {
            final Animation animation =
                    new SpriteAnimation(imageView, Duration.millis(1000), 16, 4, 0, 0, width, height);
            animation.setCycleCount(timeToWork);
            animation.play();
            //    this.upgrade();
            try {
                this.workShopInput();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public CustomeWorkShop(String name, ArrayList<String> inputs , ArrayList<String> outputs , Group mainRoot , Ground ground) {
        super(7 , mainRoot ,ground);
        this.inputs=inputs;
        this.outputs=outputs;
        this.name = name;
        this.show();
    }
}
