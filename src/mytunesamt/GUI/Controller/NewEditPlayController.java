/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Controller;

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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mytunesamt.BE.Playlist;
import mytunesamt.GUI.Model.TunesModel;

/**
 * FXML Controller class
 *
 * @author Asvør
 */
public class NewEditPlayController implements Initializable
{
    private TunesModel tModel;
    
    @FXML
    private TextField txtPlaylistName;
    @FXML
    private Button btnSavePlaylist;
    @FXML
    private Button btnCancelPlaylist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    public NewEditPlayController() throws IOException, SQLException
    {
        tModel = new TunesModel();
    }
    
    

    @FXML
    private void cancelPlaylistClick(ActionEvent event) throws IOException, SQLException
    {
        Stage primeStage = (Stage)btnCancelPlaylist.getScene().getWindow();
        primeStage.close();
    }

    @FXML
    private void savePlaylistClick(ActionEvent event) throws IOException, SQLException
    {
        Stage primeStage = (Stage)btnSavePlaylist.getScene().getWindow();
        
        
        String name = this.txtPlaylistName.getText();
        Playlist newPlayList = new Playlist(0, name);
        tModel.newPlaylist(newPlayList);
        primeStage.close();
        
        String inputTemp = String.valueOf(txtPlaylistName.getText());
        System.out.println(" " + inputTemp);
    }
    
    public void setModel (TunesModel tModel)
    {
        this.tModel = tModel;
    }
    
}
