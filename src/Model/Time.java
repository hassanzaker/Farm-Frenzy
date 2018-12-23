package Model;

public class Time {
    private int currentTime;


    public Time() {
        this.currentTime = 0;
    }

    public void next(Ground ground) throws Exception {
        this.currentTime++;
        for (int i = 0 ; i<ground.getWildAnimals().size() ; i++){
            ground.getWildAnimals().get(i).move(ground.getWildAnimals().get(i).direction(), ground);
        }
        for (int i = 0 ; i<ground.getProducerAnimals().size() ; i++){
            ground.getProducerAnimals().get(i).move(ground.getProducerAnimals().get(i).direction(), ground);
        }
        for (int i = 0 ; i<ground.getDogs().size() ; i++){
            ground.getDogs().get(i).move(ground.getDogs().get(i).direction(), ground);
        }
        for (int i = 0 ; i<ground.getCats().size() ; i++){
            ground.getCats().get(i).move(ground.getCats().get(i).direction(), ground);
        }
        for (int i = 0 ; i<ground.getWorkShops().length ; i++){
            if (ground.getWorkShops()[i]!=null){
                ground.getWorkShops()[i].checkTime(ground);
            }
        }
        ground.getWell().cehckTime();
        ground.getHelicopter().checkTime(ground);
        ground.getTruck().checkTime(ground);


    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        String s = String.valueOf(this.currentTime /60);
        s += " : ";
        s += String.valueOf(this.currentTime % 60);
        return s;
    }
}
