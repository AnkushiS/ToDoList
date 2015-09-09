import model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import customTools.UserDB;

@ManagedBean
@SessionScoped
public class EmailList {
    private UserCh user;
    private String message;
    
    public EmailList() {
    }
    
    @PostConstruct
    public void init() {
        user = new UserCh();
    }
    
    public String checkEmailList() {
        if (UserDB.emailExists(user.getEmail())) {
            return "todo";
        } else {
        	message = "Please register ";
        	return "register";
        }
    }
    
    public String addToEmailList() {
        UserDB.insert(user);
          return "index";
      }

    public UserCh getUser() {
        return user;
    }

    public void setUser(UserCh user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
}