package recomend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LANG1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton always;

    @FXML
    private ToggleGroup lango;

    @FXML
    private RadioButton often;

    @FXML
    private RadioButton somet;

    @FXML
    private RadioButton rarely;

    @FXML
    private RadioButton never;

    @FXML
    private Button next1;

    @FXML
    void initialize() {
        next1.setOnAction(event -> {
            RECOMENDController.lang += selected();
            next1.getScene().getWindow().hide();
            openScene("SCIE1.fxml");
        });
    }
    public int selected(){
        int a = 0;
        if (this.always.isSelected())
            a = 5;
        if (this.often.isSelected())
            a = 4;
        if (this.somet.isSelected())
            a = 3;
        if (this.rarely.isSelected())
            a = 2;
        if (this.never.isSelected())
            a = 1;
        return a;
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
