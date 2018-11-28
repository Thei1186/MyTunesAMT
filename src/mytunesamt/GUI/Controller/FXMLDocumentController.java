 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

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
    private Button btnEditSong;
    @FXML
    private Button btnDeleteSong;
    @FXML
    private Button btnNewPlay;
    @FXML
    private Button btnEditPlay;
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
    
}
