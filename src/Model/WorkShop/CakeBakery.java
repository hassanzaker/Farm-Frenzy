package Model.WorkShop;

import Model.Ground;
import Model.Items.Cake;
import Model.Items.Cookie;
import Model.WorkShop.WorkShop;
import View.Animations.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CakeBakery extends WorkShop {

    private Image CakeBakery1;
    ImageView cakeBakeryView1;
    {
        try {
            CakeBakery1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\FlouryCake (Cake Bakery)\\01.png"));
            cakeBakeryView1 = new ImageView(CakeBakery1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image CakeBakery2;
    ImageView cakeBakeryView2;
    {
        try {
            CakeBakery2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\FlouryCake (Cake Bakery)\\02.png"));
             cakeBakeryView2 = new ImageView(CakeBakery2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image CakeBakery3;
    ImageView cakeBakeryView3;
    {
        try {
            CakeBakery3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\FlouryCake (Cake Bakery)\\03.png"));
             cakeBakeryView3 = new ImageView(CakeBakery3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image CakeBakery4;
    ImageView cakeBakeryView4;
    {
        try {
            CakeBakery4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\FlouryCake (Cake Bakery)\\04.png"));
             cakeBakeryView4 = new ImageView(CakeBakery4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image CakeBakery5;
    ImageView cakeBakeryView5;
    {
        try {
            CakeBakery5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\FlouryCake (Cake Bakery)\\05.png"));
             cakeBakeryView5 = new ImageView(CakeBakery5);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void show(){
        if(this.level == 1) {
            this.setWorkShop(cakeBakeryView1,736/4,688/4, 100 ,250 );
        }else if(this.level == 2){
            this.setWorkShop(cakeBakeryView2,632/4,592/4, 100 ,250 );
        }else if(this.level == 3){
            this.setWorkShop(cakeBakeryView3,680/4,672/4, 100 ,250 );
        }else if(this.level == 4){
            this.setWorkShop(cakeBakeryView4,704/4,680/4, 100 ,250 );
        }else {
            this.setWorkShop(cakeBakeryView5,720/4,680/4, 100 ,250 );
        }
    }
    public void remove(){
        this.mainRoot.getChildren().remove(cakeBakeryView1);
        this.mainRoot.getChildren().remove(cakeBakeryView2);
        this.mainRoot.getChildren().remove(cakeBakeryView3);
        this.mainRoot.getChildren().remove(cakeBakeryView4);
        this.mainRoot.getChildren().remove(cakeBakeryView5);
    }
    public CakeBakery(Group mainRoot , Ground ground) {
      //  this.mainRoot=mainRoot;
        super(3 , mainRoot , ground);
        inputs.add("Flour");
        inputs.add("Cookie");
        outputs.add("Cake");
        this.name = "CakeBakery";
        this.show();
    }

    public Image getCakeBakery1() {
        return CakeBakery1;
    }

    public void setCakeBakery1(Image cakeBakery1) {
        CakeBakery1 = cakeBakery1;
    }

    public ImageView getCakeBakeryView1() {
        return cakeBakeryView1;
    }

    public void setCakeBakeryView1(ImageView cakeBakeryView1) {
        this.cakeBakeryView1 = cakeBakeryView1;
    }

    public Image getCakeBakery2() {
        return CakeBakery2;
    }

    public void setCakeBakery2(Image cakeBakery2) {
        CakeBakery2 = cakeBakery2;
    }

    public ImageView getCakeBakeryView2() {
        return cakeBakeryView2;
    }

    public void setCakeBakeryView2(ImageView cakeBakeryView2) {
        this.cakeBakeryView2 = cakeBakeryView2;
    }

    public Image getCakeBakery3() {
        return CakeBakery3;
    }

    public void setCakeBakery3(Image cakeBakery3) {
        CakeBakery3 = cakeBakery3;
    }

    public ImageView getCakeBakeryView3() {
        return cakeBakeryView3;
    }

    public void setCakeBakeryView3(ImageView cakeBakeryView3) {
        this.cakeBakeryView3 = cakeBakeryView3;
    }

    public Image getCakeBakery4() {
        return CakeBakery4;
    }

    public void setCakeBakery4(Image cakeBakery4) {
        CakeBakery4 = cakeBakery4;
    }

    public ImageView getCakeBakeryView4() {
        return cakeBakeryView4;
    }

    public void setCakeBakeryView4(ImageView cakeBakeryView4) {
        this.cakeBakeryView4 = cakeBakeryView4;
    }

    public Image getCakeBakery5() {
        return CakeBakery5;
    }

    public void setCakeBakery5(Image cakeBakery5) {
        CakeBakery5 = cakeBakery5;
    }

    public ImageView getCakeBakeryView5() {
        return cakeBakeryView5;
    }

    public void setCakeBakeryView5(ImageView cakeBakeryView5) {
        this.cakeBakeryView5 = cakeBakeryView5;
    }
}
