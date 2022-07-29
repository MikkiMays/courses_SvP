
package svp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        
        return dbConnection;
    }
    
    public void signUpUser(Account user) throws SQLException{
        
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_NAME 
                + "," + Const.USERS_SURNAME + "," + Const.USERS_LOGIN + "," + Const.USERS_PASSWORD + ")" +
                "VALUES(?,?,?,?)";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getSurname());
            prSt.setString(3, user.getLogin());
            prSt.setString(4, user.getPassword());
          
            prSt.executeUpdate(); 
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void createCourses(UserCourses usercourses){
        
        String insert = "INSERT INTO " + Const.USER_TABLE_IDCOURSE + "(" + Const.COURSE_DESIGNGRAPH + "," + Const.COURSE_DESIGNINTER + "," + Const.COURSE_DESIGNWEB + "," + 
                Const.COURSE_LANGCHI + "," + Const.COURSE_LANGENG + "," + Const.COURSE_LANGSPA + "," + Const.COURSE_MARKETADS + "," + Const.COURSE_MARKETPR + "," + Const.COURSE_MARKETWEB + "," +
                Const.COURSE_NETWORKMONTAGE + "," + Const.COURSE_NETWORKSMM + "," + Const.COURSE_PROGC + "," + Const.COURSE_PROGJAVA + "," + Const.COURSE_PROGPYTHON + "," + Const.COURSE_SCIEBIO + "," + 
                Const.COURSE_SCIEGEO + "," + Const.COURSE_SCIEPHYS + ")" + "VALUES(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate(); 
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void createRecs(UserCourses usercourses){
        
        String insert = "INSERT INTO userrecomends(" + Const.COURSE_DESIGNGRAPH + "," + Const.COURSE_DESIGNINTER + "," + Const.COURSE_DESIGNWEB + "," + 
                Const.COURSE_LANGCHI + "," + Const.COURSE_LANGENG + "," + Const.COURSE_LANGSPA + "," + Const.COURSE_MARKETADS + "," + Const.COURSE_MARKETPR + "," + Const.COURSE_MARKETWEB + "," +
                Const.COURSE_NETWORKMONTAGE + "," + Const.COURSE_NETWORKSMM + "," + Const.COURSE_PROGC + "," + Const.COURSE_PROGJAVA + "," + Const.COURSE_PROGPYTHON + "," + Const.COURSE_SCIEBIO + "," + 
                Const.COURSE_SCIEGEO + "," + Const.COURSE_SCIEPHYS + ")" + "VALUES(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate(); 
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public ResultSet getUser(Account user){
        ResultSet resSet = null;
        
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOGIN +
                "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            //System.out.println(user.getLogin());
            prSt.setString(2, user.getPassword());
            
            resSet = prSt.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    
    public ResultSet getNameSur(Account user){
        ResultSet resSet = null;
        
        String select = "SELECT iduser, name, surname FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_LOGIN + "=?"; 
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            
            resSet = prSt.executeQuery();
            /*System.out.println(resSet.getString(1));
            System.out.println(resSet.getString(2));*/
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSet;
    }
    
    public ResultSet checkCourse(String COURSE_NAME, int iduser){
        ResultSet resSetCheck = null;
        
        String select = "SELECT " + COURSE_NAME + " FROM " + Const.USER_TABLE_IDCOURSE + " WHERE " + Const.IDUSER_ID + "=?";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, iduser);
            
            resSetCheck = prSt.executeQuery();
            /*System.out.println(resSet.getString(1));
            System.out.println(resSet.getString(2));*/
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSetCheck;
    }
    
    public void signUpCourse(String COURSE_NAME, int iduser) throws SQLException{
        
        String insert = "UPDATE " + Const.USER_TABLE_IDCOURSE + " SET "  + COURSE_NAME + "=" + 1 + " WHERE " + Const.IDUSER_ID + "=?";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, iduser);
            prSt.executeUpdate(); 
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public void unSubCourse(String COURSE_NAME, int iduser) throws SQLException{
        
        String insert = "UPDATE " + Const.USER_TABLE_IDCOURSE + " SET "  + COURSE_NAME + "=" + 0 + " WHERE " + Const.IDUSER_ID + "=?";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, iduser);
            prSt.executeUpdate(); 
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public ResultSet KabinetCourses(int iduser){
        ResultSet resSetCheck = null;
        
        String select = "SELECT designgraph, designinter, designweb, langchi, langeng, langspa, marketads, marketpr, marketweb,"
                + " networkmontage, networksmm, progc, progjava, progpython, sciebio, sciegeo, sciephys FROM " + Const.USER_TABLE_IDCOURSE + " WHERE " + Const.IDUSER_ID + "=?";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, iduser);
            
            resSetCheck = prSt.executeQuery();
            /*System.out.println(resSet.getString(1));
            System.out.println(resSet.getString(2));*/
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resSetCheck;
    }
    /*designgraph1, designinter1, designweb1, langchi1, langeng1, langspa1, marketads1, marketpr1, marketweb1, 
            networkmontage1, networksmm1, progc1, progjava1, progpython1, sciebio1, sciegeo1, sciephys1*/

    public void setRecomends(String COURSE_NAME, int iduser) throws SQLException{
        
        String insert = "UPDATE userrecomends SET "  + COURSE_NAME + "=" + 1 + " WHERE iduserrecomends =?";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1, iduser);
            prSt.executeUpdate(); 
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public ResultSet recCourses(int iduser){
        ResultSet resRec = null;
        
        String select = "SELECT designgraph, designinter, designweb, langchi, langeng, langspa, marketads, marketpr, marketweb,"
                + " networkmontage, networksmm, progc, progjava, progpython, sciebio, sciegeo, sciephys FROM userrecomends WHERE iduserrecomends =?";
        
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setInt(1, iduser);
            
            resRec = prSt.executeQuery();
            /*System.out.println(resSet.getString(1));
            System.out.println(resSet.getString(2));*/
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return resRec;
    }
    
    
    /*public void outTable() throws SQLException{
        ResultSet resultSet = null;
        
        String select = "SELECT iduser, name, surname FROM "+ Const.USER_TABLE +" WHERE "+Const.USERS_LOGIN +"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, "123");
            resultSet = prSt.executeQuery();
            while(resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
         }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }*/
    
}