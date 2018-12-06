/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Controller;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PAUSED;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import mytunesamt.BE.Playlist;
import mytunesamt.BE.Song;
import mytunesamt.GUI.Model.TunesModel;

/**
 * FXML Controller class
 *
 * @author Asvør
 */
public class MediaplayerViewController implements Initializable
{

    @FXML
    private Label label;
    @FXML
    private ListView<Song> listAllSongs;
    @FXML
    private ListView<Playlist> listPlaylist;
    @FXML
    private ListView<Song> songsOnPlaylist;
    @FXML
    private Button btnNewSong;
    @FXML
    private Button btnNewPlay;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblsong;
    @FXML
    private Slider slideVolume;
    @FXML
    private Button btnPause;

    private TunesModel tModel;
    private MediaPlayer mediaPlayer;

    private String filePath;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {
            listAllSongs.setItems(tModel.getAllSongs());
            listPlaylist.setItems(tModel.getAllPlaylists());
        } catch (SQLException ex)
        {
            Logger.getLogger(MediaplayerViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MediaplayerViewController() throws IOException, SQLException
    {
        tModel = new TunesModel();

    }

    @FXML
    private void deleteSong(ActionEvent event) throws IOException
    {

        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete this song?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0)
        {
            tModel.deleteSong(listAllSongs.getSelectionModel().getSelectedItem());
        }

    }

    @FXML
    private void playSong(ActionEvent event)
    {
        File file = new File(listAllSongs.getSelectionModel().getSelectedItem().getLocation());
        filePath = file.toURI().toString();

        if (mediaPlayer == null)
        {
            Media media = new Media(filePath);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        }
    }

    @FXML
    private void deletePlaylist(ActionEvent event) throws IOException
    {
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete this playlist?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0)
        {
            tModel.deletePlaylist(listPlaylist.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void deleteFromPlaylist(ActionEvent event) throws IOException
    {
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete this song?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0)
        {
            // tModel.deletePlaylist(songsOnPlaylist.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void searchSongs(ActionEvent event) throws IOException, SQLServerException, SQLException
    {
        String input = txtSearch.getText();
        listAllSongs.setItems(tModel.searchSongs(input));
        
        
    }

    @FXML
    private void stopMusic(ActionEvent event)
    {
        if (mediaPlayer.getStatus() == PLAYING || mediaPlayer.getStatus() == PAUSED)
        {
            mediaPlayer.stop();
        }

    }

    @FXML
    private void addToPlaylist(ActionEvent event)
    {
//       songsOnPlaylist.setItems();
    }

    @FXML
    private void pauseSong(ActionEvent event)
    {

        if (mediaPlayer.getStatus() == PLAYING)
        {
            btnPause.setText("Resume");
            mediaPlayer.pause();

        }
        if (mediaPlayer.getStatus() == PAUSED)
        {
            btnPause.setText("Pause");
            mediaPlayer.play();
        }
    }

    @FXML
    private void clickNewSong(ActionEvent event) throws IOException
    {
        Stage secondStage = (Stage) btnNewSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/NewEditSong.fxml"));
        Parent root = loader.load();

        Stage stageNewSong = new Stage();
        stageNewSong.setScene(new Scene(root));

        stageNewSong.initModality(Modality.WINDOW_MODAL);
        stageNewSong.initOwner(secondStage);
        stageNewSong.show();
    }

    @FXML
    private void newPlaylist(ActionEvent event) throws IOException
    {
        Stage secondStage = (Stage) btnNewPlay.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/NewEditPlay.fxml"));
        Parent root = loader.load();

        Stage stageNewSong = new Stage();
        stageNewSong.setScene(new Scene(root));

        stageNewSong.initModality(Modality.WINDOW_MODAL);
        stageNewSong.initOwner(secondStage);
        stageNewSong.show();
    }

    @FXML
    private void editSong(ActionEvent event)
    {
    }

    @FXML
    private void editPlaylist(ActionEvent event)
    {
    }

}
