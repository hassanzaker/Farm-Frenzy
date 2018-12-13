package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;
import Model.Ground;

public abstract class WildAnimal extends Animal {
    protected int volume;

    public WildAnimal(int x, int y , String ID) {
        super(x, y , ID);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setWildAnimalAmount(cell.getWildAnimalAmount()+ a);
    }

    public abstract void eat();
    public void crash(Ground ground)
    {
      for(int i=0 ; i < ground.getProducerAnimals().size() ; i++) {
          if(ground.getProducerAnimals().get(i).getRow() == this.row &&
                  ground.getProducerAnimals().get(i).getColumn()== this.column) {
              ground.deleteAnimal(ground.getProducerAnimals().get(i));
          }
      }
      for(int i=0 ; i < ground.getCats().size() ; i++) {
          if(ground.getCats().get(i).getRow() == this.row &&
                  ground.getCats().get(i).getColumn() == this.column) {
                ground.deleteAnimal(ground.getCats().get(i));
            }
      }
      for(int i=0 ; i < ground.getDogs().size() ; i++) {
          if(ground.getDogs().get(i).getRow() == this.row &&
                  ground.getDogs().get(i).getColumn() == this.column) {
              ground.deleteAnimal(ground.getDogs().get(i));
          }
      }
      for(int i=0 ; i < ground.getEggs().size() ; i++) {
          if(ground.getEggs().get(i).getRow() == this.row &&
                  ground.getEggs().get(i).getColumn() == this.column) {
              ground.deleteItem(ground.getEggs().get(i));
          }
      }

      for(int i=0 ; i < ground.getEggPowders().size() ; i++) {
          if(ground.getEggPowders().get(i).getRow() == this.row &&
                  ground.getEggPowders().get(i).getColumn() == this.column) {
              ground.deleteItem(ground.getEggPowders().get(i));
          }
      }

        for(int i=0 ; i < ground.getMilks().size() ; i++) {
            if(ground.getMilks().get(i).getRow() == this.row &&
                    ground.getMilks().get(i).getColumn() == this.column) {
                ground.deleteItem(ground.getMilks().get(i));
            }
        }

        for(int i=0 ; i < ground.getWools().size() ; i++) {
            if(ground.getWools().get(i).getRow() == this.row &&
                    ground.getWools().get(i).getColumn() == this.column) {
                ground.deleteItem(ground.getWools().get(i));
            }
        }

        for(int i=0 ; i < ground.getCookies().size() ; i++) {
            if(ground.getCookies().get(i).getRow() == this.row &&
                    ground.getCookies().get(i).getColumn() == this.column) {
                ground.deleteItem(ground.getCookies().get(i));
            }
        }

        for(int i=0 ; i < ground.getCakes().size() ; i++) {
            if(ground.getCakes().get(i).getRow() == this.row &&
                    ground.getCakes().get(i).getColumn() == this.column) {
                ground.deleteItem(ground.getCakes().get(i));
            }
        }

    }
}
