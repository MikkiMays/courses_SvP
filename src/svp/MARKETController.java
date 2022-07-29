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

public class MARKETController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private ImageView marketAds;

    @FXML
    private ImageView marketPR;

    @FXML
    private ImageView marketWeb;

    @FXML
    void initialize() {
        logoHome.setPickOnBounds(true);
        marketAds.setPickOnBounds(true);
        marketPR.setPickOnBounds(true);
        marketWeb.setPickOnBounds(true);
        
        marketAds.setOnMouseClicked((MouseEvent e) -> {
            marketAds.getScene().getWindow().hide();
            openScene("/market/ADSmarket.fxml");
        });
        marketPR.setOnMouseClicked((MouseEvent e) -> {
            marketPR.getScene().getWindow().hide();
            openScene("/market/PRmarket.fxml");
        });
        marketWeb.setOnMouseClicked((MouseEvent e) -> {
            marketWeb.getScene().getWindow().hide();
            openScene("/market/WEBmarket.fxml");
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
