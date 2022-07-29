package recomend;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import java.util.Arrays;
import java.util.Collections;
import svp.DatabaseHandler;
import svp.SvP;

public class RECOMENDController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button start;  
    
    public static int lang = 0,
            design = 0,
            market = 0,
            network = 0,
            prog = 0,
            scie = 0;

    @FXML
    void initialize() throws SQLException {
        start.setOnAction(event -> {
            start.getScene().getWindow().hide();
            openScene("LANG1.fxml");
        }); 
    }

    public void openScene(String window){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            
            try{
                loader.load();
            }
            catch(IOException p){
                p.printStackTrace();
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    private void setRec(String a, String b, String c) throws SQLException{
        DatabaseHandler dbHandler = new DatabaseHandler();
        if (!c.equals("")) {
            dbHandler.setRecomends(a, SvP.id);
            dbHandler.setRecomends(b, SvP.id);
            dbHandler.setRecomends(c, SvP.id);
        }
        else{
            dbHandler.setRecomends(a, SvP.id);
            dbHandler.setRecomends(b, SvP.id);
        }
    }
}