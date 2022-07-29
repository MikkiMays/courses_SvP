package svp;

import java.io.IOException;
import javafx.scene.control.TextField;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import svp.Shake;

public class REGISTERController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordReg;

    @FXML
    private TextField loginReg;

    @FXML
    private Button enterReg;

    @FXML
    private PasswordField passwordAgainReg;

    @FXML
    private Hyperlink haveAcc;

    @FXML
    private TextField nameReg;

    @FXML
    private TextField surnameReg;

    @FXML
    void initialize() {
        enterReg.setOnAction(event ->{
            String login_field = loginReg.getText().trim();
            String password_field = passwordReg.getText().trim();
            String name_field = nameReg.getText().trim();
            String surname_field = surnameReg.getText().trim();
            String passwordAgain_field = passwordAgainReg.getText().trim();
            if (password_field.equals(passwordAgain_field) && !login_field.equals("") && !password_field.equals("") &&
                    !name_field.equals("") && !surname_field.equals("") && !passwordAgain_field.equals(""))
            {
                try {
                    signUpNewUser();
                } catch (SQLException ex) {
                    Logger.getLogger(REGISTERController.class.getName()).log(Level.SEVERE, null, ex);
                }
                              
                enterReg.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("MAIN.fxml"));
            
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
            else{
                Shake enterRegAnim = new Shake(enterReg);
                enterRegAnim.playAnim();
            }
        });
        haveAcc.setOnAction(event -> {
            haveAcc.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ENTER.fxml"));
            
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
        });
    }

    private void signUpNewUser() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        
        String name = nameReg.getText();
        String surname = surnameReg.getText();
        String login = loginReg.getText();
        String password = passwordReg.getText();
        
        Account user = new Account(name, surname, login, password);
        UserCourses usercourses = new UserCourses(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        
            dbHandler.createRecs(usercourses);
            dbHandler.createCourses(usercourses);
            dbHandler.signUpUser(user);
            ResultSet result = dbHandler.getNameSur(user);
            
            while(result.next()){
            SvP.id = result.getInt("iduser");
            SvP.name = result.getString("name");
            SvP.surname = result.getString("surname");
           }
            
    }
}
