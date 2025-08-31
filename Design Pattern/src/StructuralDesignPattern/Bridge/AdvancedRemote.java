package StructuralDesignPattern.Bridge;

public class AdvancedRemote extends RemoteControl{

    public AdvancedRemote(Device device){
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
