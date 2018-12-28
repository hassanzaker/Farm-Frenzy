package Model;

import Model.Animals.Animal;
import Model.Animals.Bear;
import Model.Animals.WildAnimal;
import Model.Items.CagedBear;

import java.util.ArrayList;

public class Cage {

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
