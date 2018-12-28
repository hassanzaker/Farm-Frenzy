package Controller;

public class Level {
    private int level;
    private String[] types;
    private int[] need;
    private int firstMoney;

    public Level(int level, String[] types, int[] need, int firstMoney) {
        this.level = level;
        this.types = types;
        this.need = need;
        this.firstMoney = firstMoney;
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

    public int getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(int firstMoney) {
        this.firstMoney = firstMoney;
    }
}
