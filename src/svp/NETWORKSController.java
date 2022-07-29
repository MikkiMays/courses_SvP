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

public class NETWORKSController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private ImageView networksSMM;

    @FXML
    private ImageView networksVideo;

    @FXML
    void initialize() {
        logoHome.setPickOnBounds(true);
        networksSMM.setPickOnBounds(true);
        networksVideo.setPickOnBounds(true);
        
        networksSMM.setOnMouseClicked((MouseEvent e) -> {
            networksSMM.getScene().getWindow().hide();
            openScene("/network/SMMnetwork.fxml");
        });
        networksVideo.setOnMouseClicked((MouseEvent e) -> {
            networksVideo.getScene().getWindow().hide();
            openScene("/network/MONTAGEnetwork.fxml");
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

