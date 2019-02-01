package Model.WorkShop;

import Model.Ground;
import View.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Spinnery extends WorkShop {
    private Image Spinnery1;
    ImageView spinneryView1;
    {
        try {
            Spinnery1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\01.png"));
             spinneryView1 = new ImageView(Spinnery1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery2;
    ImageView spinneryView2;
    {
        try {
            Spinnery2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\02.png"));
             spinneryView2 = new ImageView(Spinnery2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery3;
    ImageView spinneryView3;
    {
        try {
            Spinnery3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\03.png"));
             spinneryView3 = new ImageView(Spinnery3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery4;
    ImageView spinneryView4;
    {
        try {
            Spinnery4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\04.png"));
             spinneryView4 = new ImageView(Spinnery4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery5;
    ImageView spinneryView5;
    {
        try {
            Spinnery5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\05.png"));
             spinneryView5 = new ImageView(Spinnery5);

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
            try {
                this.workShopInput();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public void show(){
        if(this.level == 1) {
            this.setWorkShop(spinneryView1,520/4,424/4, 770 ,170 );
        }else if(this.level == 2){
            this.setWorkShop(spinneryView2,552/4,600/4, 770 ,170 );
        }else if(this.level == 3){
            this.setWorkShop(spinneryView3,712/4,584/4, 770 ,170 );
        }else if(this.level == 4){
            this.setWorkShop(spinneryView4,704/4,728/4, 770 ,170 );
        }else {
            this.setWorkShop(spinneryView5,640/4,656/4, 770 ,170 );
        }
    }
    public void remove(){
        this.mainRoot.getChildren().remove(spinneryView1);
        this.mainRoot.getChildren().remove(spinneryView2);
        this.mainRoot.getChildren().remove(spinneryView3);
        this.mainRoot.getChildren().remove(spinneryView4);
        this.mainRoot.getChildren().remove(spinneryView5);
    }
    public Spinnery(Group mainRoot , Ground ground) {
        super(4 , mainRoot, ground);
        inputs.add("Wool");
        outputs.add("Sewing");
        this.name = "Spinnery";
        this.show();
    }

    public Image getSpinnery1() {
        return Spinnery1;
    }

    public void setSpinnery1(Image spinnery1) {
        Spinnery1 = spinnery1;
    }

    public ImageView getSpinneryView1() {
        return spinneryView1;
    }

    public void setSpinneryView1(ImageView spinneryView1) {
        this.spinneryView1 = spinneryView1;
    }

    public Image getSpinnery2() {
        return Spinnery2;
    }

    public void setSpinnery2(Image spinnery2) {
        Spinnery2 = spinnery2;
    }

    public ImageView getSpinneryView2() {
        return spinneryView2;
    }

    public void setSpinneryView2(ImageView spinneryView2) {
        this.spinneryView2 = spinneryView2;
    }

    public Image getSpinnery3() {
        return Spinnery3;
    }

    public void setSpinnery3(Image spinnery3) {
        Spinnery3 = spinnery3;
    }

    public ImageView getSpinneryView3() {
        return spinneryView3;
    }

    public void setSpinneryView3(ImageView spinneryView3) {
        this.spinneryView3 = spinneryView3;
    }

    public Image getSpinnery4() {
        return Spinnery4;
    }

    public void setSpinnery4(Image spinnery4) {
        Spinnery4 = spinnery4;
    }

    public ImageView getSpinneryView4() {
        return spinneryView4;
    }

    public void setSpinneryView4(ImageView spinneryView4) {
        this.spinneryView4 = spinneryView4;
    }

    public Image getSpinnery5() {
        return Spinnery5;
    }

    public void setSpinnery5(Image spinnery5) {
        Spinnery5 = spinnery5;
    }

    public ImageView getSpinneryView5() {
        return spinneryView5;
    }

    public void setSpinneryView5(ImageView spinneryView5) {
        this.spinneryView5 = spinneryView5;
    }
}
