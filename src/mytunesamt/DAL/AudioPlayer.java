package mytunesamt.DAL;

import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

    public AudioPlayer()
    {
        currentSong = 0;
    }

    /*
    Plays the chosen song and on the end chooses the next song on the list
     */
    public void play(int playSongNr, ObservableList<Song> songsToPlay)
    {
        if (currentSong == songsToPlay.size() || currentSong == -1)
        {
            return;
        }
        String location = songsToPlay.get(playSongNr).getLocation();
        media = new Media(location);
        mediaPlayer = new MediaPlayer(media);
        String songLabel = "" + songsToPlay.get(playSongNr).getTitle() + " : " + songsToPlay.get(playSongNr).getArtist();

        mediaPlayer.play();

        //This tells the mediaplayer to play the next song on the list
        mediaPlayer.setOnEndOfMedia(new Runnable()
        {
            @Override
            public void run()
            {
                currentSong++;
                play(currentSong, playSongs);
            }
        });

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
        mediaPlayer.pause();
    }

    /*
    plays the previous song on the list
     */
    public void previous()
    {
        if (currentSong > 0)
        {
            stop();
            currentSong--;
            play(currentSong, playSongs);
        }
    }

    /*
    plays the next song on the list
     */
    public void next()
    {
        if (currentSong < playSongs.size() - 1)
        {
            stop();
            currentSong++;
            play(currentSong, playSongs);
        }
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
}
