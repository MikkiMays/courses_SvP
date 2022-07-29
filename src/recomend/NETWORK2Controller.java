package recomend;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import static recomend.RECOMENDController.design;
import static recomend.RECOMENDController.lang;
import static recomend.RECOMENDController.market;
import static recomend.RECOMENDController.network;
import static recomend.RECOMENDController.prog;
import static recomend.RECOMENDController.scie;
import svp.DatabaseHandler;
import svp.SvP;

public class NETWORK2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next12;

    @FXML
    private RadioButton never;

    @FXML
    private ToggleGroup question;

    @FXML
    private RadioButton rarely;

    @FXML
    private RadioButton somet;

    @FXML
    private RadioButton often;

    @FXML
    private RadioButton always;

    @FXML
    void initialize() throws SQLException {
        next12.setOnAction(event -> {
            RECOMENDController.scie += selected();
            next12.getScene().getWindow().hide();
            int max = 0;
        int[] all = {lang, design, market, network, prog, scie};
        for (int i = 0; i < all.length; i++){
            if (max <= all[i])
                max = all[i];
        }
        
        System.out.println(max);
        if (max == design)
            try {
                setRec("designgraph", "designinter", "designweb");
            } catch (SQLException ex) {
                Logger.getLogger(NETWORK2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (max == lang)
            try {
                setRec("langchi", "langeng", "langspa");
            } catch (SQLException ex) {
                Logger.getLogger(NETWORK2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (max == market)
            try {
                setRec("marketads", "marketpr", "marketweb");
            } catch (SQLException ex) {
                Logger.getLogger(NETWORK2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (max == network)
            try {
                setRec("networkmontage", "networksmm", "");
            } catch (SQLException ex) {
                Logger.getLogger(NETWORK2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (max == prog)
            try {
                setRec("progc", "progjava", "progpython");
            } catch (SQLException ex) {
                Logger.getLogger(NETWORK2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (max == scie)
            try {
                setRec("sciebio", "sciegeo", "sciephys");
            } catch (SQLException ex) {
                Logger.getLogger(NETWORK2Controller.class.getName()).log(Level.SEVERE, null, ex);
            } 
            openScene("/svp/KABINET.fxml");
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
    private void setRec(String a, String b, String c) throws SQLException{
        DatabaseHandler dbHandler = new DatabaseHandler();
        if (!c.equals("")) {
            dbHandler.setRecomends(a, SvP.id);
            dbHandler.setRecomends(b, SvP.id);
            dbHandler.setRecomends(c, SvP.id);
        }
        else{
            dbHandler.setRecomends(a, SvP.id);
            dbHandler.setRecomends(b, SvP.id);
        }
    }
}
