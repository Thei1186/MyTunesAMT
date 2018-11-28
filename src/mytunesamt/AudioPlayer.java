package mytunesamt;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kokus
 */
public class AudioPlayer
{

    Media media;
    public MediaPlayer mediaPlayer;

    public AudioPlayer(String name)
    {
        media = new Media(name);
        mediaPlayer = new MediaPlayer(media);

    }

}
