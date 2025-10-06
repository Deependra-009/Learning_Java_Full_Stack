package StructuralDesignPattern.Adapter.classes;

import StructuralDesignPattern.Adapter.interfaces.AdvancedMediaPlayer;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+fileName);
    }

    @Override
    public void playMP4(String fileName) {
        // do nothing
    }
}
