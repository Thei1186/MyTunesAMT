/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Controller;

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
import javafx.stage.Modality;
import javafx.stage.Stage;
import mytunesamt.BE.Song;
import mytunesamt.GUI.Model.AudioPlayer;
import mytunesamt.GUI.Model.TunesModel;

/**
 * FXML Controller class
 *
 * @author Asvør
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private Label label;
    @FXML
    private ListView<Song> listAllSongs;
    @FXML
    private ListView<?> listPlaylist;
    @FXML
    private ListView<?> listOnPlaylist;
    @FXML
    private Button btnNewSong;
    @FXML
    private Button btnDeleteSong;
    @FXML
    private Button btnNewPlay;
    @FXML
    private Button btnDeleteFromPlay;
    @FXML
    private Button btnDeletePlay;
    @FXML
    private Button btnAddToPlay;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label lblsong;
    @FXML
    private Button btnPlaySong;
    @FXML
    private Button btnPrevious;
    @FXML
    private Button btnPause;
    @FXML
    private Button btnStop;
    @FXML
    private Button btnNext;
    @FXML
    private Slider slideVolume;

    private TunesModel tModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            tModel = new TunesModel();
        } catch (IOException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            listAllSongs.setItems(tModel.getAllSongs());
        } catch (SQLException ex)
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteSong(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage) btnDeleteSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/DeleteWindow.fxml"));
        Parent root = loader.load();

        //DeleteWindowController deleteWindowController = loader.getController();
        Stage stageDelete = new Stage();
        stageDelete.setScene(new Scene(root));

        stageDelete.initModality(Modality.WINDOW_MODAL);
        stageDelete.initOwner(primeStage);

        stageDelete.show();
    }

    @FXML
    private void clickNewEdit(ActionEvent event) throws IOException
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
    private void playSong(ActionEvent event)
    {
        int isPlaying = 0;
        File file = new File(listAllSongs.getSelectionModel().getSelectedItem().getLocation());
        AudioPlayer ap = new AudioPlayer(file.toURI().toString());
        if (isPlaying == 0)
        {
            isPlaying++;
            ap.mediaPlayer.play();
        ap.mediaPlayer.getOnPlaying();
        }
        if (isPlaying == 1)
        {
            isPlaying--;
            ap.mediaPlayer.play();
            
        }
    }

    @FXML
    private void newEditPlaylist(ActionEvent event) throws IOException
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
    private void deletePlaylist(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage) btnDeletePlay.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/DeleteWindow.fxml"));
        Parent root = loader.load();

        Stage stageNewSong = new Stage();
        stageNewSong.setScene(new Scene(root));

        stageNewSong.initModality(Modality.WINDOW_MODAL);
        stageNewSong.initOwner(primeStage);
        stageNewSong.show();
    }

    @FXML
    private void addToPlaylist(ActionEvent event) throws IOException
    {

    }

    @FXML
    private void deleteFromPlaylist(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage) btnDeleteFromPlay.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/DeleteWindow.fxml"));
        Parent root = loader.load();

        Stage stageNewSong = new Stage();
        stageNewSong.setScene(new Scene(root));

        stageNewSong.initModality(Modality.WINDOW_MODAL);
        stageNewSong.initOwner(primeStage);
        stageNewSong.show();
    }

    @FXML
    private void searchSongs(ActionEvent event)
    {
        String inputTemp = String.valueOf(txtSearch.getText());
        System.out.println(" " + inputTemp);
    }

}
