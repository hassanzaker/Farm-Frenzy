package Controller;

public class Level {
    private int level;
    private String[] types = new String[3];
    private int[] need = new int[3];

    public Level(int level, String[] types, int[] need) {
        this.level = level;
        this.types = types;
        this.need = need;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public int[] getNeed() {
        return need;
    }

    public void setNeed(int[] need) {
        this.need = need;
    }
}
