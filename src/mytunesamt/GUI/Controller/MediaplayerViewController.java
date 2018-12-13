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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

    //The fields used within the controller
    private TunesModel tModel;
    private String filePath;
    private Boolean isPaused;
    private Boolean searchDone;
    private Playlist currentPlaylist;
    private Song currentSong;
    private int currentIndex;

    /*
    Initializes the various lists as well as the model.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        try
        {
            tModel = new TunesModel();
            listAllSongs.setItems(tModel.getAllSongs());
            listPlaylist.setItems(tModel.getAllPlaylists());


        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    public MediaplayerViewController() throws IOException, SQLException
    {
        searchDone = false;
        isPaused = false;
        currentIndex = 0;
    }

    /*
    deletes the selected song. Selection is done by clicking the song to delete.
     */
    @FXML
    private void deleteSong(ActionEvent event) throws IOException
    {

        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete this song?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0)
        {
            tModel.deleteSong(listAllSongs.getSelectionModel().getSelectedItem());

        }

    }

    /*
    deletes the selected playlist. Selection is done by clicking the playlist to delete.
     */
    @FXML
    private void deletePlaylist(ActionEvent event) throws IOException
    {
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete this playlist?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0)
        {
            Playlist pList = listPlaylist.getSelectionModel().getSelectedItem();

            if (songsOnPlaylist != null)
            {
                tModel.deletePlaylist(pList);
                songsOnPlaylist.getItems().clear();
            }
        }
    }

    /*
    deletes the selected song from the selected playlist. Selection is done by clicking the playlist and then the song to delete.
     */
    @FXML
    private void deleteFromPlaylist(ActionEvent event) throws IOException
    {
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete this song?", "Delete", JOptionPane.YES_NO_OPTION);
        if (p == 0)
        {
            tModel.deleteSongsOnPlaylist(songsOnPlaylist.getSelectionModel().getSelectedItem());
        }
    }

    /*
    searches for either artist or title and then clears the query when clicked again.
     */
    @FXML
    private void searchSongs(ActionEvent event) throws IOException, SQLServerException, SQLException
    {
        if (searchDone == false)
        {
            searchDone = true;
            String input = txtSearch.getText();
            listAllSongs.setItems(tModel.searchSongs(input));
            btnSearch.setText("Clear");
        } else if (searchDone == true)
        {
            searchDone = false;
            btnSearch.setText("Search");
            listAllSongs.setItems(tModel.getAllSongs());
            txtSearch.clear();
        }
    }

    /*
    adds the selected song to the selected playlist. This is done by first selecting a song and a playlist before clicking the add to playlist button.
     */
    @FXML
    private void addToPlaylist(ActionEvent event)
    {
        Song selectedSong = listAllSongs.getSelectionModel().getSelectedItem();
        Playlist selectedPlaylist = listPlaylist.getSelectionModel().getSelectedItem();
        tModel.addToPlaylist(selectedSong, selectedPlaylist);
    }

    /*
    opens a new stage wherein a new song can be added to the list of songs.
     */
    @FXML
    private void clickNewSong(ActionEvent event) throws IOException
    {
        Stage secondStage = (Stage) btnNewSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/NewEditSong.fxml"));
        Parent root = loader.load();

        NewEditSongController newEditController = loader.getController();
        newEditController.setModel(tModel);

        Stage stageNewSong = new Stage();
        stageNewSong.setScene(new Scene(root));

        stageNewSong.initModality(Modality.WINDOW_MODAL);
        stageNewSong.initOwner(secondStage);
        stageNewSong.show();
    }

    /*
    opens a new stage wherein a new playlist can be added to the list of playlists.
     */
    @FXML
    private void newPlaylist(ActionEvent event) throws IOException
    {
        Stage secondStage = (Stage) btnNewPlay.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/NewEditPlay.fxml"));
        Parent root = loader.load();

        NewEditPlayController newEditPlayController = loader.getController();
        newEditPlayController.setModel(tModel);

        Stage stageNewSong = new Stage();
        stageNewSong.setScene(new Scene(root));

        stageNewSong.initModality(Modality.WINDOW_MODAL);
        stageNewSong.initOwner(secondStage);
        stageNewSong.show();
    }

    /*
    edits a song and gives it a new title according to the input from the user.
     */
    @FXML
    private void editSong(ActionEvent event) throws SQLException
    {
        String newTitle = JOptionPane.showInputDialog(null, "song to edit", "Edit", JOptionPane.OK_OPTION);
        tModel.editSong(listAllSongs.getSelectionModel().getSelectedItem(), newTitle);

        listAllSongs.getItems().clear();
        listAllSongs.setItems(tModel.getAllSongs());
        if (!songsOnPlaylist.getItems().isEmpty())
        {
            songsOnPlaylist.getItems().clear();
            songsOnPlaylist.setItems(tModel.getSongsOnPlaylist(currentPlaylist));
        }
    }

    /*
    edits a playlist and gives it a new name according to the input from the user.
     */
    @FXML
    private void editPlaylist(ActionEvent event) throws SQLException
    {
        String newName = JOptionPane.showInputDialog(null, "playlist to edit", "Edit", JOptionPane.OK_OPTION);
        tModel.editPlaylist(listPlaylist.getSelectionModel().getSelectedItem(), newName);

        listPlaylist.getItems().clear();
        listPlaylist.setItems(tModel.getAllPlaylists());
    }

    //below is the music functionality
    /*
    Plays the selected song
     */
    @FXML
    private void playSong(ActionEvent event) throws SQLException
    {
        
        if (listAllSongs.getSelectionModel().getSelectedItem() != null)
        {
            currentIndex = listAllSongs.getSelectionModel().getSelectedIndex();
            File file = new File(listAllSongs.getItems().get(currentIndex).getLocation());
            filePath = file.toURI().toString();
            Song song = listAllSongs.getSelectionModel().getSelectedItem();
            tModel.playAll(listAllSongs.getItems() ,currentIndex);
            String viewSong = "" + listAllSongs.getItems().get(currentIndex).getTitle() +" : " + listAllSongs.getItems().get(currentIndex).getArtist();
            
            this.lblsong.setText(viewSong);
            
        } 
        else if (songsOnPlaylist.getSelectionModel().getSelectedItem() != null)
        {
            File file = new File(songsOnPlaylist.getSelectionModel().getSelectedItem().getLocation());
            filePath = file.toURI().toString();

            Song song = songsOnPlaylist.getSelectionModel().getSelectedItem();
            tModel.play(song);
            String viewSong = "" + song.getTitle() + " : " + song.getArtist();
            this.lblsong.setText(viewSong);
        }

    }
    

    /*
    Stops the current song
     */
    @FXML
    private void stopMusic(ActionEvent event)
    {
//        if (mediaPlayer.getStatus() == PLAYING || mediaPlayer.getStatus() == PAUSED)
//        {
//            mediaPlayer.stop();
//        }

        tModel.stop();
    }

    /*
    pauses the current song and resumes it if pressed while paused
     */
    @FXML
    private void pauseSong(ActionEvent event)
    {
        if (isPaused == false)

        {
            isPaused = true;
            btnPause.setText("Resume");
            tModel.pause();
        } else
        {
            isPaused = false;
            btnPause.setText("Pause");
            tModel.pause();
        }
    }

    /*
    plays the previous song on the list
     */
    @FXML
    private void previousSong(ActionEvent event)
    {
        tModel.previous();
//        if (listAllSongs.getSelectionModel().getSelectedIndex() != -1)
//        {
//            
//        }
    }

    /*
    plays the next song on the list
     */
    @FXML
    private void nextSong(ActionEvent event)
    {
//        tModel.next();
//        if (listAllSongs.getSelectionModel().getSelectedIndex() != -1)
//        {
//            
//        }
    }

    /*
 * Chooses the active Song 
 * @param event: 2 clicks clears the selection
     */
    @FXML
    private void chooseSong(MouseEvent event)
    {
        currentSong = listAllSongs.getSelectionModel().getSelectedItem();
        if (event.getButton().equals(MouseButton.PRIMARY))
        {
            if (event.getClickCount() == 2)
            {
                listAllSongs.getSelectionModel().clearSelection();
                currentSong = null;
            }
        }
    }

    /*
 * Chooses the active song on the playlist
 * @param event: 2 clicks clears the selection
     */
    @FXML
    private void chooseSongOnPlaylist(MouseEvent event)
    {
        currentSong = songsOnPlaylist.getSelectionModel().getSelectedItem();
        if (event.getButton().equals(MouseButton.PRIMARY))
        {
            if (event.getClickCount() == 2)
            {
                songsOnPlaylist.getSelectionModel().clearSelection();
                currentSong = null;
            }
        }
    }

    /*
 * Chooses the active playlist and shows the songs contained within
 * @param event: 2 clicks clears the selection
     */
    @FXML
    private void choosePlaylist(MouseEvent event)
    {
        currentPlaylist = listPlaylist.getSelectionModel().getSelectedItem();
        songsOnPlaylist.setItems(tModel.getSongsOnPlaylist(currentPlaylist));
        if (event.getButton().equals(MouseButton.PRIMARY))
        {
            if (event.getClickCount() == 2)
            {
                songsOnPlaylist.getItems().clear();
                listPlaylist.getSelectionModel().clearSelection();
                currentPlaylist = null;
            }
        }
    }


}
