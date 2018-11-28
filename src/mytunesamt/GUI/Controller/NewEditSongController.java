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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private TextField TxtArtist;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void cancelNewSong(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage)btnCancelNewSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/Document.fxml"));
        Parent root = loader.load();
        
        //DeleteWindowController deleteWindowController = loader.getController();
        
        Stage stageDelete = new Stage();
        stageDelete.setScene(new Scene(root));
        
        stageDelete.initModality(Modality.WINDOW_MODAL);
        stageDelete.initOwner(primeStage);
        
        stageDelete.show();
    }

    @FXML
    private void saveSongClick(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage)btnSaveSong.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/Document.fxml"));
        Parent root = loader.load();
        
        //DeleteWindowController deleteWindowController = loader.getController();
        
        Stage stageDelete = new Stage();
        stageDelete.setScene(new Scene(root));
        
        stageDelete.initModality(Modality.WINDOW_MODAL);
        stageDelete.initOwner(primeStage);
        
        stageDelete.show();
    }
    
}
