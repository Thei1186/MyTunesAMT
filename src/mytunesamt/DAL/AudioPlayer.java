package mytunesamt.DAL;

import java.io.File;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PAUSED;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import mytunesamt.BE.Playlist;
import mytunesamt.BE.Song;

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
    private MediaPlayer mediaPlayer;
//    int currentSong;
    ObservableList<Song> playSongs;
    private String filePath;
    private int currentSong;

    public AudioPlayer()
    {
//        currentSong = 0;
    }

    /*
    Plays the chosen song and on the end chooses the next song on the list
     */
    public void play(Song song)
    {

        String location = song.getLocation();
        File file = new File(location);
        filePath = file.toURI().toString();
        media = new Media(filePath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

    public void playAll(List<Song> songs, int i)
    {
        if(mediaPlayer != null)
        {
            stop();
        }
            this.currentSong = i;
        
        String location = songs.get(currentSong).getLocation();
        File file = new File(location);
        filePath = file.toURI().toString();
        media = new Media(filePath);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        /*mediaPlayer.onEndOfMediaProperty().addListener(new ChangeListener<Runnable>()
        {
            @Override
            public void changed(ObservableValue<? extends Runnable> observable, Runnable oldValue, Runnable newValue)
            {*/
                mediaPlayer.setOnEndOfMedia(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (currentSong == songs.size() - 1)
                        {
                            currentSong = 0;

                        } else
                        {
                            currentSong++;
                        }
                        playAll(songs, currentSong);
                    }
                });
            }
        //});

    

    /*
    stops the song
     */
    public void stop()
    {
        mediaPlayer.stop();
    }

    /*
    pauses the song
     */
    public void pause()
    {
        if (mediaPlayer.getStatus() == PLAYING)
        {

            mediaPlayer.pause();

        }
        if (mediaPlayer.getStatus() == PAUSED)
        {

            mediaPlayer.play();
        }
        mediaPlayer.pause();
    }

    /*
    sets the volume of the song played
     */
    public void setVolume(double volume)
    {
        mediaPlayer.setVolume(volume);
    }
}
