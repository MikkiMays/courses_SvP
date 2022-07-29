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

public class LANGUAGEController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private ImageView langChi;

    @FXML
    private ImageView langEn;

    @FXML
    private ImageView langSpa;

    private int a;
    private int b;
    
    @FXML
    void initialize() {
        logoHome.setPickOnBounds(true);
        langChi.setPickOnBounds(true);
        langEn.setPickOnBounds(true);
        langSpa.setPickOnBounds(true);
        
        logoHome.setOnMouseClicked((MouseEvent e) -> {
            logoHome.getScene().getWindow().hide();
            openScene("MAIN.fxml");
        });
        langChi.setOnMouseClicked((MouseEvent e) -> {
            langChi.getScene().getWindow().hide();
            openScene("/language/CHIlang.fxml");
        });
        langEn.setOnMouseClicked((MouseEvent e) -> {
            langEn.getScene().getWindow().hide();
            openScene("/language/ENGlang.fxml");
        });
        langSpa.setOnMouseClicked((MouseEvent e) -> {
            langSpa.getScene().getWindow().hide();
            openScene("/language/SPAlang.fxml");
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
