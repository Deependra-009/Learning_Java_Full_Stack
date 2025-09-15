package StructuralDesignPattern.Bridge;

/**
 * Bridge Design Pattern
 * */
public class Main {

    public static void main(String[] args) {

        // TV
        Tv tv=new Tv();
        BasicRemote basicRemote = new BasicRemote(tv);
        basicRemote.turnOn();
        basicRemote.turnOff();
        basicRemote.setVolume(50);

        // TV
        Radio radio=new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.turnOn();
        advancedRemote.turnOff();
        advancedRemote.setVolume(100);







    }
}
