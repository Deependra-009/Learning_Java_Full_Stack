package StructuralDesignPattern.Adapter.interfaces;

/**
 * Target Interface (what client expects)
 * */
public interface MediaPlayer {
    void play(String audioType,String fileName);
}
