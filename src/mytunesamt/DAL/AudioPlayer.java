package mytunesamt.DAL;

import java.io.File;
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
    public MediaPlayer mediaPlayer;
    int currentSong;
    ObservableList<Song> playSongs;
    private String filePath;

    public AudioPlayer()
    {
        currentSong = 0;
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
        String songLabel = "" + song.getTitle() + " : " + song.getArtist();
        mediaPlayer.play();

    }

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
    plays the previous song on the list
     */
    public void previous()
    {
//        if (currentSong > 0)
//        {
//            stop();
//            currentSong--;
//            play(currentSong, playSongs);
//        }
    }

    /*
    plays the next song on the list
     */
    public void next()
        {
//        if (currentSong < playSongs.size() - 1)
//        {
//            stop();
//            currentSong++;
//            play(currentSong, playSongs);
//        }
     }

    /*
    resumes a paused song
     */
    public void resume()
    {
        mediaPlayer.play();
    }

    /*
    sets the volume of the song played
     */
    public void setVolume(double volume)
    {
        mediaPlayer.setVolume(volume);
    }
    
    public void playPlaylist (Playlist playlist)
    {
        
    }
}
