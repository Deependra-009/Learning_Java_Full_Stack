package StructuralDesignPattern.Bridge;

public class BasicRemote extends RemoteControl{

    public BasicRemote(Device device){
        super(device);
    }

    @Override
    public void turnOn() {
        this.device.turnOn();
    }

    @Override
    public void turnOff() {
        this.device.turnOff();
    }

    @Override
    public void setVolume(int volume) {
        this.device.setVolume(volume);
    }
}
