package StructuralDesignPattern.Bridge;

/**
 * Implementor Interface (the "bridge" side)
 * */
public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}
