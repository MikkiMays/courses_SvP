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

public class DESIGNController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private ImageView designInter;

    @FXML
    private ImageView designWeb;

    @FXML
    private ImageView designGraf;

    @FXML
    void initialize() {
        
        logoHome.setPickOnBounds(true);
        designInter.setPickOnBounds(true);
        designWeb.setPickOnBounds(true);
        designGraf.setPickOnBounds(true);
        
        designInter.setOnMouseClicked((MouseEvent e) -> {
            designInter.getScene().getWindow().hide();
            openScene("/design/INTERdesign.fxml");
        });
        designWeb.setOnMouseClicked((MouseEvent e) -> {
            designWeb.getScene().getWindow().hide();
            openScene("/design/WEBdesign.fxml");
        });
        designGraf.setOnMouseClicked((MouseEvent e) -> {
            designGraf.getScene().getWindow().hide();
            openScene("/design/GRAPHdesign.fxml");
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
