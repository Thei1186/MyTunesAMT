 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private ListView<?> listAllSongs;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    


    private void DeleteSong(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage)btnDeleteSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/DeleteWindow.fxml"));
        Parent root = loader.load();
        
        //DeleteWindowController deleteWindowController = loader.getController();
        
        Stage stageDelete = new Stage();
        stageDelete.setScene(new Scene(root));
        
        //stageDelete.initModality(Modality.WINDOW_MODAL);
        //stageDelete.initOwner(primeStage);
        
        stageDelete.show();
    }

    @FXML
    private void clickNewEdit(ActionEvent event) throws IOException
    {
        Stage secondStage = (Stage)btnNewSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/NewEditSong.fxml"));
        Parent root = loader.load();
        
        Stage stageNewSong = new Stage();
        stageNewSong.setScene(new Scene(root));
        
        //stageNewSong.initModality(Modality.WINDOW_MODAL);
        //stageNewSong.initOwner(secondStage);
        
        stageNewSong.show();
    }

    @FXML
    private void deleteSong(ActionEvent event) throws IOException
    {
        Stage stage;
        
        Parent root;
        
        if (event.getSource() == btnNewSong)
        {
            stage = (Stage) btnNewSong.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/mytunesamt/GUI/View/NewEditSong.fxml"));
            
        }
        else
        {
            stage = (Stage) btnDeleteSong.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/mytunesamt/GUI/View/DeleteWindow.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void playSong(ActionEvent event)
    {
    }
    
}
