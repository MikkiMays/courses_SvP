package prog;

import design.GRAPHdesignController;
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

public class PYTHONprogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView logoHome;

    @FXML
    private Button backProg;

    @FXML
    private Button signUpPython;

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
        backProg.setOnAction(event -> {
            backProg.getScene().getWindow().hide();
            openScene("/svp/PROGRAML.fxml");
        });
        signUpPython.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            ResultSet result = dbHandler.checkCourse(Const.COURSE_PROGPYTHON, SvP.id);
            try {
                if (result.next())
                    this.check = result.getInt(Const.COURSE_PROGPYTHON);
                    } catch (SQLException ex) {
                Logger.getLogger(GRAPHdesignController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (check == 0){
                try {
                    dbHandler.signUpCourse(Const.COURSE_PROGPYTHON, SvP.id);
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
            ResultSet result = dbHandler.checkCourse(Const.COURSE_PROGPYTHON, SvP.id);
            try {
                if (result.next())
                    checkunsub = result.getInt(Const.COURSE_PROGPYTHON);
                    } catch (SQLException ex) {
                Logger.getLogger(GRAPHdesignController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (checkunsub == 1){
                try {
                    dbHandler.unSubCourse(Const.COURSE_PROGPYTHON, SvP.id);
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
