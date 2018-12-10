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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mytunesamt.BE.Song;
import mytunesamt.GUI.Model.TunesModel;
import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.ID3Tag;
import org.blinkenlights.jid3.v1.ID3V1Tag;
import org.blinkenlights.jid3.v1.ID3V1_0Tag;
import org.blinkenlights.jid3.v1.ID3V1_1Tag;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;

/**
 * FXML Controller class
 *
 * @author Asvør
 */
public class NewEditSongController implements Initializable
{

    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtArtist;
    @FXML
    private TextField txtFile;
    @FXML
    private ComboBox<?> comboCategory;
    @FXML
    private Button btnChoose;
    @FXML
    private Button btnCancelNewSong;
    @FXML
    private Button btnSaveSong;
    @FXML
    private AnchorPane rootPane2;
    private TunesModel tModel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    public NewEditSongController() throws IOException, SQLException
    {
        
    }

    @FXML
    private void cancelNewSong(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage) btnCancelNewSong.getScene().getWindow();
        primeStage.close();
    }

    @FXML
    private void saveSongClick(ActionEvent event) throws IOException, SQLException
    {
        Stage primeStage = (Stage) btnSaveSong.getScene().getWindow();

        String title = this.txtTitle.getText();
        String artist = this.txtArtist.getText();
        String location = this.txtFile.getText();

        Song newSong = new Song(title, artist, location, 0);
        tModel.addSong(newSong);

        primeStage.close();

    }

    @FXML
    private void chooseFile(ActionEvent event) throws ID3Exception, IOException
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (mp3)", "*.mp3", "*.mp4", "*.wav");
        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setTitle("Open Music File");
        Stage stage = (Stage) rootPane2.getScene().getWindow();
        File mediafile = fileChooser.showOpenDialog(stage);
        String title = null;
        String artist = null;
        String location = null;

        MP3File mp3 = new MP3File(mediafile);
        try
        {
            for (ID3Tag tag : mp3.getTags())
            {
                if (tag instanceof ID3V1_0Tag || tag instanceof ID3V1_1Tag)
                {
                    ID3V1Tag id3Tag = (ID3V1Tag) tag;
                    title = id3Tag.getTitle();
                    artist = id3Tag.getArtist();
                    location = mediafile.getPath();
                } else if (tag instanceof ID3V2_3_0Tag )
                {
                    ID3V2_3_0Tag id3Tag = (ID3V2_3_0Tag) tag;
                    title = id3Tag.getTitle();
                    artist = id3Tag.getArtist();
                    location = mediafile.getPath();

                }
            }
            this.txtTitle.setText(title);
            this.txtArtist.setText(artist);
            this.txtFile.setText(location);
        } catch (ID3Exception e)
        {
            e.printStackTrace();
        }

    }
    
    public void setModel(TunesModel tModel)
    {
        this.tModel = tModel;
    }

}
