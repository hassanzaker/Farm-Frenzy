package Model.WorkShop;

import Model.Items.EggPowder;
import Model.Ground;
import View.Animations.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EggPowderPlant extends WorkShop {
    private Image EggPowderPlant1;
    ImageView eggPowderPlantView1;
    {
        try {
            EggPowderPlant1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\DriedEggs (Egg Powder Plant)\\01.png"));
             eggPowderPlantView1 = new ImageView(EggPowderPlant1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image EggPowderPlant2;
    ImageView eggPowderPlantView2;
    {
        try {
            EggPowderPlant2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\DriedEggs (Egg Powder Plant)\\02.png"));
             eggPowderPlantView2 = new ImageView(EggPowderPlant2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image EggPowderPlant3;
    ImageView eggPowderPlantView3;
    {
        try {
            EggPowderPlant3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\DriedEggs (Egg Powder Plant)\\03.png"));
             eggPowderPlantView3 = new ImageView(EggPowderPlant3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image EggPowderPlant4;
    ImageView eggPowderPlantView4;
    {
        try {
            EggPowderPlant4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\DriedEggs (Egg Powder Plant)\\04.png"));
             eggPowderPlantView4 = new ImageView(EggPowderPlant4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image EggPowderPlant5;
    ImageView eggPowderPlantView5;
    {
        try {
            EggPowderPlant5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\DriedEggs (Egg Powder Plant)\\05.png"));
            eggPowderPlantView5 = new ImageView(EggPowderPlant5);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
            this.workShopInput();
        });
    }
    public void show(){
        if(this.level == 1) {
            this.setWorkShop(eggPowderPlantView1,512/4,456/4, 100 ,150 );
        }else if(this.level == 2){
            this.setWorkShop(eggPowderPlantView2,576/4,528/4, 100 ,150 );
        }else if(this.level == 3){
            this.setWorkShop(eggPowderPlantView3,656/4,600/4, 100 ,150 );
        }else if(this.level == 4){
            this.setWorkShop(eggPowderPlantView4,744/4,632/4, 100 ,150 );
        }else {
            this.setWorkShop(eggPowderPlantView5,736/4,632/4, 100 ,150 );
        }
    }
    public void remove(){
        this.mainRoot.getChildren().remove(eggPowderPlantView1);
        this.mainRoot.getChildren().remove(eggPowderPlantView2);
        this.mainRoot.getChildren().remove(eggPowderPlantView3);
        this.mainRoot.getChildren().remove(eggPowderPlantView4);
        this.mainRoot.getChildren().remove(eggPowderPlantView5);
    }
    public EggPowderPlant(Group mainRoot , Ground ground) {
        super(1 , mainRoot, ground);
        inputs.add("Egg");
        outputs.add("EggPowder");
        this.name = "EggPowderPlant";
        this.show();
    }



}
