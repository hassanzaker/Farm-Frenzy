package Model.Items;

import javafx.scene.Group;

public abstract class Item {
    protected int volume;
    protected Group mainRoot;
    protected int row;
    protected int column;
    protected String ID;
    protected boolean inGrounad;
    protected String type;
    protected int sellPrice;
    protected int  buyPrice;
    public  void show(){

    }
    public void remove(){

    }
    public Item(int x, int y , String ID , Boolean inGrounad , Group mainRoot ) {
        this.row = x;
        this.column = y;
        this.ID = ID;
        this.inGrounad = inGrounad;
        this.mainRoot= mainRoot;
        this.show();
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public boolean isInGrounad() {
        return inGrounad;
    }

    public void setInGrounad(boolean inGrounad) {
        this.inGrounad = inGrounad;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
