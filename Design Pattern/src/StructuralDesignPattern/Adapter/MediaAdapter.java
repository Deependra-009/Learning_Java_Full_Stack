package StructuralDesignPattern.Adapter;

/**
 * Create Adapter (bridge between interfaces)
 * */
public class MediaAdapter implements MediaPlayer{

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
