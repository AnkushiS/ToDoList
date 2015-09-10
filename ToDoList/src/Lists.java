

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
public class Lists {
    private UserCh user;
    private ToDoList dolist;
    private String message;
    
    public List<ToDoList> view_list;

    public Lists() {
    	
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
        ListCatalog(user.getUserid());
        view_list = getView_list();
        return "viewlist";
    }
    
	
	public void ListCatalog(int userid) {
        view_list = new ArrayList<ToDoList>();
        List<ToDoList> getLists =  UserDB.selectList(userid);
        
        for(ToDoList allLists : getLists){
        	view_list.add(allLists);
        	
        }
        
    }

	public List<ToDoList> getView_list() {
		return view_list;
	}

	public void setView_list(List<ToDoList> view_list) {
		this.view_list = view_list;
	}

	
	
	 public String ViewList() {
		 FacesContext fc = FacesContext.getCurrentInstance();
		 user = UserDB.selectUser(getParam(fc, "useremail"));
		 
		 ListCatalog(user.getUserid());
	     view_list = getView_list();
		 return "viewlist";    	
	      
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