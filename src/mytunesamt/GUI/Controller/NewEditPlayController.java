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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asvør
 */
public class NewEditPlayController implements Initializable
{

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

    @FXML
    private void cancelPlaylistClick(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage)btnCancelPlaylist.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/Document.fxml"));
        Parent root = loader.load();
        
        primeStage.show();
    }

    @FXML
    private void savePlaylistClick(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage)btnSavePlaylist.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/NewEditPlay.fxml"));
        Parent root = loader.load();
        
        primeStage.show();
        
        String inputTemp = String.valueOf(txtPlaylistName.getText());
        System.out.println(" " + inputTemp);
    }
    
}
