package Model;

import Model.Animals.Animal;
import Model.Animals.Bear;
import Model.Animals.WildAnimal;
import Model.Items.CagedBear;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Cage {
    private Image Cage1;

    {
        try {
            Cage1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Cages\\break01.png"));
            ImageView wellView = new ImageView(Cage1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Cage2;

    {
        try {
            Cage2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Cages\\break02.png"));
            ImageView wellView = new ImageView(Cage2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Cage3;

    {
        try {
            Cage3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Cages\\break03.png"));
            ImageView wellView = new ImageView(Cage3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Cage4;

    {
        try {
            Cage4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Cages\\break04.png"));
            ImageView wellView = new ImageView(Cage4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // this function is static and call without initialization
    public static void action(Ground ground, int x, int y) throws Exception {

        if (ground.getCells()[x-1][y-1].getWildAnimalAmount()==0){
            throw new Exception("there is no wild animal!");
        }
        else{
            for (int i=0 ; i<ground.getWildAnimals().size() ; i++){
                if (ground.getWildAnimals().get(i).getRow() == x-1 && ground.getWildAnimals().get(i).getColumn() == y-1){
                    if (ground.getWildAnimals().get(i) instanceof Bear)
                    ground.getWereHouse().addItem(new CagedBear(-100, -100, "0",false));
                    ArrayList<WildAnimal> wildAnimals = ground.getWildAnimals();
                    wildAnimals.remove(ground.getWildAnimals().get(i));    /////////// ????????
                    ground.setWildAnimals(wildAnimals);
                }
            }
        }
    }
}
