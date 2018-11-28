/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Asvør
 */
public class SongFiles
{
    
    
    public void init()
    {
        final URL resource = getClass().getResource("src\\AdventureTime Ending Theme.mp3");
        final Media media = new Media (resource.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
}
