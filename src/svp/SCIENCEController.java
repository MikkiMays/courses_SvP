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

public class SCIENCEController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private ImageView sccBio;

    @FXML
    private ImageView sccGeo;

    @FXML
    private ImageView sccPhis;

    @FXML
    void initialize() {
        logoHome.setPickOnBounds(true);
        sccBio.setPickOnBounds(true);
        sccGeo.setPickOnBounds(true);
        sccPhis.setPickOnBounds(true);
        
        sccBio.setOnMouseClicked((MouseEvent e) -> {
            sccBio.getScene().getWindow().hide();
            openScene("/science/BIOscie.fxml");
        });
        sccGeo.setOnMouseClicked((MouseEvent e) -> {
            sccGeo.getScene().getWindow().hide();
            openScene("/science/GEOscie.fxml");
        });
        sccPhis.setOnMouseClicked((MouseEvent e) -> {
            sccPhis.getScene().getWindow().hide();
            openScene("/science/PHYSscie.fxml");
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
