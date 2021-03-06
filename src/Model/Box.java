package Model;

import Model.Items.*;

import java.util.ArrayList;

public class Box {

    private int capacity;
    private int currentCapacity;
    private int sellPrice;
    private int buyPrice;
    private ArrayList<Item> items = new ArrayList<>();

    public Box() {
        this.capacity = 10;
        sellPrice=0;
        buyPrice=0;
    }
    public void addItem(Item item) throws  Exception{
        if(item.getVolume()+ currentCapacity > capacity){
            throw new Exception("no free space exists");
        }else{
            if(items.size() != 0 && !items.get(0).getType().equals(item.getType())){
                throw new Exception("not of one kind");
            }
            else {
                items.add(item);
                currentCapacity += item.getVolume();
                sellPrice += item.getSellPrice();
                buyPrice += item.getBuyPrice();
            }
        }
    }
    public Boolean checkFull() {
        if (items.size() == 0) {
            return true;
        } else {
            if (currentCapacity + items.get(0).getVolume() > capacity) {
                return true;
            } else {
                return false;
            }
        }
    }
    public String typeOfBox(){
        if(items.size() == 0){
            return "none";
        }else {
            return items.get(0).getType();
        }
    }
    public void clearBox(){
        for (int i = 0; i <items.size() ; i++) {
            items.remove(i);
        }
    }
    public void deleteItem(Item item){
        items.remove(item);
        currentCapacity -= item.getVolume();
        sellPrice -= item.getSellPrice();
        buyPrice -= item.getBuyPrice();
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }
}
