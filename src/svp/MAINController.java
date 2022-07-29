package svp;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MAINController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView inostran;

    @FXML
    private ImageView networks;

    @FXML
    private ImageView marketing;

    @FXML
    private ImageView programLangs;

    @FXML
    private ImageView design;

    @FXML
    private ImageView sciences;
    
    @FXML
    private Button LK_button;
    

    @FXML
    void initialize() {
        inostran.setPickOnBounds(true);
        networks.setPickOnBounds(true);
        marketing.setPickOnBounds(true);
        programLangs.setPickOnBounds(true);
        design.setPickOnBounds(true);
        sciences.setPickOnBounds(true);
        
        LK_button.setOnAction(event ->{
           LK_button.getScene().getWindow().hide();
           openScene("KABINET.fxml");
        });
        
        inostran.setOnMouseClicked((MouseEvent e) -> {
            inostran.getScene().getWindow().hide();
            String a = "LANGUAGE" + ".fxml";
            openScene(a);
        });
        
        networks.setOnMouseClicked((MouseEvent e) -> {
            networks.getScene().getWindow().hide();
            openScene("NETWORKS.fxml");
        });
        
        marketing.setOnMouseClicked((MouseEvent e) -> {
            marketing.getScene().getWindow().hide();
            openScene("MARKET.fxml");
        });
        
        programLangs.setOnMouseClicked((MouseEvent e) -> {
            programLangs.getScene().getWindow().hide();
            openScene("PROGRAML.fxml");
        });
        
        design.setOnMouseClicked((MouseEvent e) -> {
            design.getScene().getWindow().hide();
            openScene("DESIGN.fxml");
        });
        
        sciences.setOnMouseClicked((MouseEvent e) -> {
            sciences.getScene().getWindow().hide();
            openScene("SCIENCE.fxml");
        });
        
        /*checkBut.setOnAction(event ->{
            System.out.println(SvP.name);
            ENTERController enc = new ENTERController();
            System.out.println(enc.getNameLK());
        });*/
        
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
}