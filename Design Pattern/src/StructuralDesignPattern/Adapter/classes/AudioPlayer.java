package StructuralDesignPattern.Adapter.classes;

import StructuralDesignPattern.Adapter.MediaAdapter;
import StructuralDesignPattern.Adapter.interfaces.MediaPlayer;

/**
 * Concrete Media Player using Adapter
 * */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toUpperCase()){
            case "VLC":
            case "MP4":
                mediaAdapter=new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
                break;
            case "MP3":
                System.out.println("Playing via MP3. Name: "+fileName);
                break;
            default:
                System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
