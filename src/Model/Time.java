package Model;

public class Time {
    private int currentTime;


    public Time() {
        this.currentTime = 0;
    }

    public void next() {
        this.currentTime++;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        String s = String.valueOf(this.currentTime / 60);
        s += " : " ;
        s += String.valueOf(this.currentTime % 60);
        return s;
    }
}
