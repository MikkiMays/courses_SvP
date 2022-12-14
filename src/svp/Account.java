
package svp;

import java.util.*;

public class Account {

    private String login;
    private String password;
    private String name;
    private String surname; 

    public Account(String name, String surname, String login, String password) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
    
    public Account() {
        
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
      
}
