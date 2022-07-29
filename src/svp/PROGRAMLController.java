package svp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PROGRAMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private ImageView progC;

    @FXML
    private ImageView progJava;

    @FXML
    private ImageView progPyt;

    @FXML
    void initialize() {
        logoHome.setPickOnBounds(true);
        progC.setPickOnBounds(true);
        progJava.setPickOnBounds(true);
        progPyt.setPickOnBounds(true);
        
        progC.setOnMouseClicked((MouseEvent e) -> {
            progC.getScene().getWindow().hide();
            openScene("/prog/Cprog.fxml");
        });
        progJava.setOnMouseClicked((MouseEvent e) -> {
            progJava.getScene().getWindow().hide();
            openScene("/prog/JAVAprog.fxml");
        });
        progPyt.setOnMouseClicked((MouseEvent e) -> {
            progPyt.getScene().getWindow().hide();
            openScene("/prog/PYTHONprog.fxml");
        });
        logoHome.setOnMouseClicked((MouseEvent e) -> {
            logoHome.getScene().getWindow().hide();
            openScene("MAIN.fxml");
        });
    }
    private void openScene(String window){
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
