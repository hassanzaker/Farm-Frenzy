package Model.Items;

public abstract class Item {
    private int volume;
  //  private int cost;
    protected int row;
    protected int column;
    protected String ID;
    protected boolean inGrounad;
    public String type;

    // protected static final int cost=0;
    protected String type;
   // protected static final int cost=0;
    public Item( int x, int y , String ID) {
        this.row = x;
        this.column = y;
        this.ID = ID;
        inGrounad = false;
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
