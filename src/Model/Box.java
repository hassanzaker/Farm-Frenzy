package Model;

import Model.Items.*;

import java.util.ArrayList;

public class Box {

    private int capacity;
    private int curruntCapacity;
    private int sellPrice;
    private int buyPrice;
    private ArrayList<Item> items = new ArrayList<>();

    public Box() {
        this.capacity = 10;
        sellPrice=0;
        buyPrice=0;
    }
    public void addItem(Item item) throws  Exception{
        if(item.getVolume()+curruntCapacity > capacity){
            throw new Exception("no free space exists");
        }else{
            if(items.size() != 0 && !items.get(0).getType().equals(item.getType())){
                throw new Exception("not of one kind");
            }
            else {
                items.add(item);
                curruntCapacity += item.getVolume();
                sellPrice += item.getSellPrice();
                buyPrice += item.getBuyPrice();
            }
        }
    }
    public void clearBox(){
        for (int i = 0; i <items.size() ; i++) {
            items.remove(i);
        }
    }
    public void deleteItem(Item item){
        items.remove(item);
        curruntCapacity -= item.getVolume();
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

    public int getCurruntCapacity() {
        return curruntCapacity;
    }

    public void setCurruntCapacity(int curruntCapacity) {
        this.curruntCapacity = curruntCapacity;
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
