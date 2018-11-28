/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author michaellemmiche
 */
public class NewEditSongController implements Initializable {

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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
