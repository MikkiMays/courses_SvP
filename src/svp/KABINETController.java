package svp;

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
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import recomend.RECOMENDController;

public class KABINETController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane paneNonRec;

    @FXML
    private Button createRec;
    
    @FXML
    private Button logOut;
    
    @FXML
    private ImageView logoHome;

    @FXML
    private Text nameLK;

    @FXML
    private Text surnameLK;
    
    @FXML
    private MenuItem designgraph;

    @FXML
    private MenuItem designinter;

    @FXML
    private MenuItem designweb;

    @FXML
    private MenuItem langchi;

    @FXML
    private MenuItem langeng;

    @FXML
    private MenuItem langspa;

    @FXML
    private MenuItem marketads;

    @FXML
    private MenuItem marketpr;

    @FXML
    private MenuItem marketweb;

    @FXML
    private MenuItem networkmontage;

    @FXML
    private MenuItem networksmm;

    @FXML
    private MenuItem progc;

    @FXML
    private MenuItem progjava;

    @FXML
    private MenuItem progpython;

    @FXML
    private MenuItem sciebio;

    @FXML
    private MenuItem sciegeo;

    @FXML
    private Pane panealreadyRec;
        
    @FXML
    private MenuItem sciephys;

    @FXML
    private MenuItem designgraph1;

    @FXML
    private MenuItem designinter1;

    @FXML
    private MenuItem designweb1;

    @FXML
    private MenuItem langchi1;

    @FXML
    private MenuItem langeng1;

    @FXML
    private MenuItem langspa1;

    @FXML
    private MenuItem marketads1;

    @FXML
    private MenuItem marketpr1;

    @FXML
    private MenuItem marketweb1;

    @FXML
    private MenuItem networkmontage1;

    @FXML
    private MenuItem networksmm1;

    @FXML
    private MenuItem progc1;

    @FXML
    private MenuItem progjava1;

    @FXML
    private MenuItem progpython1;

    @FXML
    private MenuItem sciebio1;

    @FXML
    private MenuItem sciegeo1;

    @FXML
    private MenuItem sciephys1;
     
    @FXML
    void initialize() throws SQLException {       
        logoHome.setPickOnBounds(true);
        MenuItem courses[] = {designgraph, designinter, designweb, langchi, langeng, langspa, marketads, marketpr, marketweb, 
            networkmontage, networksmm, progc, progjava, progpython, sciebio, sciegeo, sciephys};
        
        MenuItem coursesRec[] = {designgraph1, designinter1, designweb1, langchi1, langeng1, langspa1, marketads1, marketpr1, marketweb1, 
            networkmontage1, networksmm1, progc1, progjava1, progpython1, sciebio1, sciegeo1, sciephys1};
        String[] courseLoc = {"/design/GRAPHdesign", "/design/INTERdesign", "/design/WEBdesign", "/language/CHIlang", "/language/ENGlang", "/language/SPAlang", "/market/ADSmarket", "/market/PRmarket", "/market/WEBmarket", 
            "/network/MONTAGEnetwork", "/network/SMMnetwork", "/prog/Cprog", "/prog/JAVAprog", "/prog/PYTHONprog", "/science/BIOscie", "/science/GEOscie", "/science/PHYSscie"};
        
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet resSetCourse = dbHandler.KabinetCourses(SvP.id);
        while(resSetCourse.next())
            for (int i = 0; i < courses.length - 1; i++){
                //System.out.println(resSetCourse.getInt(i + 1));
            if (resSetCourse.getInt(i + 1) == 0)
                courses[i].setVisible(false);
            else{
                final String crs = courseLoc[i];
                courses[i].setVisible(true);       
                courses[i].setOnAction(event ->{
                    logoHome.getScene().getWindow().hide();
                    openScene(crs + ".fxml");
                });
            }
        }
        nameLK.setText(SvP.name);
        surnameLK.setText(SvP.surname);
        
        ResultSet recs = dbHandler.recCourses(SvP.id);
        int count = 0;
        while(recs.next())
            for (int i = 0; i < coursesRec.length - 1; i++){
                //System.out.println(recs.getInt(i + 1));
            if (recs.getInt(i + 1) == 0)
                coursesRec[i].setVisible(false);
            else{
                final String crs = courseLoc[i];
                coursesRec[i].setVisible(true);  
                count++;
                coursesRec[i].setOnAction(event ->{
                    logoHome.getScene().getWindow().hide();
                    openScene(crs + ".fxml");
                });
            }
            if (count > 0){
                panealreadyRec.setVisible(true);
                paneNonRec.setVisible(false);
            }
            else{
                panealreadyRec.setVisible(false);
                paneNonRec.setVisible(true);
            }
                
        }
        logOut.setOnAction(event ->{            
            createRec.getScene().getWindow().hide();
            openScene("ENTER.fxml");
        });
        
        createRec.setOnAction(event ->{           
            createRec.getScene().getWindow().hide(); 
            openScene("/recomend/RECOMEND.fxml");
        });

        logoHome.setOnMouseClicked((MouseEvent e) -> {
            logoHome.getScene().getWindow().hide();
            openScene("MAIN.fxml");
        });
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