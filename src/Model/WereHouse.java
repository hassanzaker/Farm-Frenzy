package Model;

import Model.Items.Item;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WereHouse {
    private Group mainRoot;
    private int capacity;
    private int level;
    private int currentCapacity;
   // private Scene scene = new Scene();
    private ArrayList<Item> items = new ArrayList<>();

    private Image WereHouse1;
    ImageView wereHouseView1;
    {
        try {
            WereHouse1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Depot\\01.png"));
             wereHouseView1 = new ImageView(WereHouse1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image WereHouse2;
    ImageView wereHouseView2;
    {
        try {
            WereHouse2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Depot\\02.png"));
             wereHouseView2= new ImageView(WereHouse2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image WereHouse3;
    ImageView wereHouseView3;
    {
        try {
            WereHouse3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Depot\\03.png"));
             wereHouseView3 = new ImageView(WereHouse3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image WereHouse4;
    ImageView wereHouseView4;
    {
        try {
            WereHouse4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Depot\\04.png"));
             wereHouseView4 = new ImageView(WereHouse4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void show(){
        if(this.level ==1) {
            wereHouseView1.setX(400);
            wereHouseView1.setY(500);
            this.mainRoot.getChildren().add(wereHouseView1);
            wereHouseView1.setOnMouseClicked(event -> {
     //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 2){
            wereHouseView2.setX(400);
            wereHouseView2.setY(500);
            this.mainRoot.getChildren().add(wereHouseView2);
            wereHouseView2.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 3){
            wereHouseView3.setX(400);
            wereHouseView3.setY(500);
            this.mainRoot.getChildren().add(wereHouseView3);
            wereHouseView3.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 4){
            wereHouseView4.setX(400);
            wereHouseView4.setY(500);
            this.mainRoot.getChildren().add(wereHouseView4);
            wereHouseView4.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }

    }
    public void showItemInWereHouse(){

    }
    public void showItemInScene(){

    }
    public void remove(){
        this.mainRoot.getChildren().remove(wereHouseView1);
        this.mainRoot.getChildren().remove(wereHouseView2);
        this.mainRoot.getChildren().remove(wereHouseView3);
        this.mainRoot.getChildren().remove(wereHouseView4);
    }
    public WereHouse(Group mainRoot) {
        this.mainRoot=mainRoot;
        currentCapacity = 0;
        this.capacity = 50;
        this.level = 1;
        this.show();
    }

    public void addItem(Item item) throws Exception {
        if (item.getVolume() + currentCapacity > capacity) {
            throw new Exception("no free space exists");
        } else {
            items.add(item);
            currentCapacity += item.getVolume();
        }
    }

    public void deleteItem(Item item) {
        items.remove(item);
        currentCapacity -= item.getVolume();
    }

    public void upgrade(int money) throws Exception {
        if (computeUpgradeCost() > money) {
            throw new Exception("not enough money!");
        }
        if (this.level == 4) {
            throw new Exception("wereHouse is max level!");
        }
        this.level++;
        this.capacity = this.capacity * 2;
    }

    public int computeUpgradeCost() {
        return this.level * 200;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        String s = "wereHouse level : " + String.valueOf(this.level) + "\n" +
                "capacity : " + String.valueOf(this.capacity) + "\n" +
                "current amount : " + String.valueOf(this.currentCapacity) + "\n" +
                "empty : " + String.valueOf(this.capacity - this.currentCapacity) + "\n" ;
        return s;
    }

    public Group getMainRoot() {
        return mainRoot;
    }

    public void setMainRoot(Group mainRoot) {
        this.mainRoot = mainRoot;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Image getWereHouse1() {
        return WereHouse1;
    }

    public void setWereHouse1(Image wereHouse1) {
        WereHouse1 = wereHouse1;
    }

    public ImageView getWereHouseView1() {
        return wereHouseView1;
    }

    public void setWereHouseView1(ImageView wereHouseView1) {
        this.wereHouseView1 = wereHouseView1;
    }

    public Image getWereHouse2() {
        return WereHouse2;
    }

    public void setWereHouse2(Image wereHouse2) {
        WereHouse2 = wereHouse2;
    }

    public ImageView getWereHouseView2() {
        return wereHouseView2;
    }

    public void setWereHouseView2(ImageView wereHouseView2) {
        this.wereHouseView2 = wereHouseView2;
    }

    public Image getWereHouse3() {
        return WereHouse3;
    }

    public void setWereHouse3(Image wereHouse3) {
        WereHouse3 = wereHouse3;
    }

    public ImageView getWereHouseView3() {
        return wereHouseView3;
    }

    public void setWereHouseView3(ImageView wereHouseView3) {
        this.wereHouseView3 = wereHouseView3;
    }

    public Image getWereHouse4() {
        return WereHouse4;
    }

    public void setWereHouse4(Image wereHouse4) {
        WereHouse4 = wereHouse4;
    }

    public ImageView getWereHouseView4() {
        return wereHouseView4;
    }

    public void setWereHouseView4(ImageView wereHouseView4) {
        this.wereHouseView4 = wereHouseView4;
    }
}
