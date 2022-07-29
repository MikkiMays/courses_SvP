
package svp;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
import javafx.stage.Stage;
import svp.Shake;


public class ENTERController{
     
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField passwordAuto;

    @FXML
    private TextField loginAuto;
    
    @FXML
    private Button enterRegist;

    @FXML
    private Button enterAuto;
    
    private String NameLK;
    private String SurnameLK;
     
    @FXML
    void initialize() {
        enterAuto.setOnAction(event ->{
            
            String loginLog = loginAuto.getText().trim();
            String loginPassword = passwordAuto.getText().trim();
            if (!loginLog.equals("") && !loginPassword.equals(""))
                try {
                    loginUser(loginLog, loginPassword);
                    
                    SvP.name = NameLK;
                    SvP.surname = SurnameLK;
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ENTERController.class.getName()).log(Level.SEVERE, null, ex);
                }
            else{
                Shake enterRegAnim = new Shake(enterAuto);
                enterRegAnim.playAnim();
                System.out.println("log or pass is empty");
            }
        });
        
        enterRegist.setOnAction(event ->{
            enterRegist.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("REGISTER.fxml"));
            
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

    public void loginUser(String loginLog, String loginPassword) throws SQLException {
        
        DatabaseHandler dbHandler = new DatabaseHandler();
        Account user = new Account();
        user.setLogin(loginLog);
        user.setPassword(loginPassword);
        
           ResultSet result = dbHandler.getUser(user);
           ResultSet resnasu = dbHandler.getNameSur(user);
           
           while(resnasu.next()){
            SvP.id = resnasu.getInt("iduser");
            this.NameLK = resnasu.getString("name");
            this.SurnameLK = resnasu.getString("surname");
           }
            
        int count = 0;
        while(result.next()){

            count++;
        }
        
        if(count >= 1){
                enterAuto.getScene().getWindow().hide();
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
            Shake enterAnim = new Shake(enterAuto);
            enterAnim.playAnim();
        }
    }
}

