package StructuralDesignPattern.Bridge;

public class Tv implements Device{
    @Override
    public void turnOn() {
        System.out.println("Turning on the TV");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the TV");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Set TV volume: "+volume);
    }
}
