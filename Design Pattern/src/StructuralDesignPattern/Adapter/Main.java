package StructuralDesignPattern.Adapter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Adaptor Design Pattern
 * */
public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer=new AudioPlayer();

        audioPlayer.play("mp3","song.mp3");
        audioPlayer.play("mp4","song.mp4");
        audioPlayer.play("vlc","song.vlc");
        audioPlayer.play("avi","song.avi");

    }
}
