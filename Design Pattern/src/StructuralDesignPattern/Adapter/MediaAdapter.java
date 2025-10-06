package StructuralDesignPattern.Adapter;

import StructuralDesignPattern.Adapter.classes.MP4Player;
import StructuralDesignPattern.Adapter.classes.VlcPlayer;
import StructuralDesignPattern.Adapter.interfaces.AdvancedMediaPlayer;
import StructuralDesignPattern.Adapter.interfaces.MediaPlayer;

/**
 * Create Adapter (bridge between interfaces)
 * */
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType){
        switch (audioType.toUpperCase()){
            case "VLC":
                advancedMediaPlayer=new VlcPlayer();
                break;
            case "MP4":
                advancedMediaPlayer=new MP4Player();
                break;
            default:
                advancedMediaPlayer=null;
                break;
        }

    }

    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toUpperCase()){
            case "VLC":
                advancedMediaPlayer.playVlc(fileName);
                break;
            case "MP4":
                advancedMediaPlayer.playMP4(fileName);
                break;
        }
    }
}
