/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asvør
 */
public class DeleteWindowController implements Initializable
{

    @FXML
    private Button btnDeleteFinal;

    @FXML
    private void secondDeleteClick(ActionEvent event) throws IOException
    {
        Stage primeStage = (Stage)btnDeleteFinal.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mytunesamt/GUI/View/Document.fxml"));
        Parent root = loader.load();
        
        primeStage.close();
    }  
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }

}
