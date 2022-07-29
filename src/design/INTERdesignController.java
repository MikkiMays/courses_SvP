package design;

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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import svp.Const;
import svp.DatabaseHandler;
import svp.SvP;

public class INTERdesignController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private Button backDesign;

    @FXML
    private Button signUpInterDesign;
    
    @FXML
    private Label alreadySignUp;
    
    @FXML
    private Button unsubscribe;

    private int check, checkunsub;
    
    @FXML
    void initialize() {
        logoHome.setPickOnBounds(true);
        
        logoHome.setOnMouseClicked((MouseEvent e) -> {
            logoHome.getScene().getWindow().hide();
            openScene("/svp/MAIN.fxml");
        });
        backDesign.setOnAction(event ->{
            backDesign.getScene().getWindow().hide();
            openScene("/svp/DESIGN.fxml");
        });
        signUpInterDesign.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            ResultSet result = dbHandler.checkCourse(Const.COURSE_DESIGNINTER, SvP.id);
            try {
                if (result.next())
                    this.check = result.getInt(Const.COURSE_DESIGNINTER);
                    } catch (SQLException ex) {
                Logger.getLogger(GRAPHdesignController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check == 0){
                try {
                    dbHandler.signUpCourse(Const.COURSE_DESIGNINTER, SvP.id);
                } catch (SQLException ex) {
                    Logger.getLogger(GRAPHdesignController.class.getName()).log(Level.SEVERE, null, ex);
                }
                alreadySignUp.setText("Вы успешно записаны");
            }
            else
                alreadySignUp.setText("Вы уже записаны");
        });
        unsubscribe.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            ResultSet result = dbHandler.checkCourse(Const.COURSE_DESIGNINTER, SvP.id);
            try {
                if (result.next())
                    checkunsub = result.getInt(Const.COURSE_DESIGNINTER);
                    } catch (SQLException ex) {
                Logger.getLogger(GRAPHdesignController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (checkunsub == 1){
                try {
                    dbHandler.unSubCourse(Const.COURSE_DESIGNINTER, SvP.id);
                } catch (SQLException ex) {
                    Logger.getLogger(GRAPHdesignController.class.getName()).log(Level.SEVERE, null, ex);
                }
                alreadySignUp.setText("Вы отписались от курса");
            }
            else{
                alreadySignUp.setText("Вы ещё не записаны");
            }
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
