/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author kokus
 */
public class MyTunesAMT extends Application
{
    
    @Override
    public void start(Stage stage) throws Exception
    {
        File file = new File("Sange/AdventureTime Theme.mp3");
        AudioPlayer ap = new AudioPlayer(file.toURI().toString());
        ap.mediaPlayer.play();

    
        Parent root = FXMLLoader.load(getClass().getResource("GUI/View/Document.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    


    }

