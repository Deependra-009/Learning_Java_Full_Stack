package StructuralDesignPattern.Bridge;

/**
 * Abstraction
 * */
public abstract class RemoteControl {

    Device device; // Bridge

    public RemoteControl(Device device){
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void setVolume(int volume);

}
