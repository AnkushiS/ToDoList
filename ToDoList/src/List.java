

import java.util.*;

import model.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextWrapper;

import customTools.UserDB;

@ManagedBean
@SessionScoped
public class List {
    private UserCh user;
    private ToDoList dolist;
    private String message;
    
    public List() {
    	
    }
    
    @PostConstruct
    public void init() {
        user = new UserCh();
        dolist = new ToDoList();
    }
    
    public String addNewList() {
    	return "newlist";    	
      
    }

    public String insertlist() {
    	
    	
    		
    	FacesContext fc = FacesContext.getCurrentInstance();
    	
    	//get user id
    	user = UserDB.selectUser(getParam(fc, "useremail"));	
     	dolist.setUserid(user.getUserid());
     	
     	String dueDate = getParam(fc, "dueDate");
     	dolist.setDueDate(dueDate);
     	
     	String dateCompleted = getParam(fc, "dateComp");
     	dolist.setDateCompleted(dateCompleted);
     	
     	String statusid = getParam(fc, "statusid");
     	dolist.setStatusid(Double.valueOf(statusid));
     	
        UserDB.insertNewList(dolist);
        viewlist(user.getUserid());
        return "viewlist";
    }
    
	public static List<ToDoList> viewlist(int userid) {
		return UserDB.selectList(userid);
			
	}
	
	

	
	
	
	

	private String getParam(FacesContext fc, String param_name) {
			
			Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
			return params.get(param_name);
			
	}

	public UserCh getUser() {
		return user;
	}

	public void setUser(UserCh user) {
		this.user = user;
	}

	public ToDoList getDolist() {
		return dolist;
	}

	public void setDolist(ToDoList dolist) {
		this.dolist = dolist;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}