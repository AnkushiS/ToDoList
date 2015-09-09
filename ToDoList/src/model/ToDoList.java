package model;

import java.io.Serializable;

import javax.persistence.*;




/**
 * The persistent class for the TO_DO_LIST database table.
 * 
 */
@Entity
@Table(name="TO_DO_LIST" , schema="testDB")
@NamedQuery(name="ToDoList.findAll", query="SELECT t FROM ToDoList t")
public class ToDoList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int listid;

	@Column(name="DATE_COMPLETED")
	private String dateCompleted;

	private String description;

	@Column(name="DUE_DATE")
	private String dueDate;

	@Column(name="LIST_NAME")
	private String listName;

	private String priority;

	private Double statusid;

	private int userid;

	public ToDoList() {
	}

	public int getListid() {
		return this.listid;
	}

	public void setListid(int listid) {
		this.listid = listid;
	}

	public String getDateCompleted() {
		return this.dateCompleted;
	}

	public void setDateCompleted(String dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getListName() {
		return this.listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Double getStatusid() {
		return this.statusid;
	}

	public void setStatusid(Double statusid) {
		this.statusid = statusid;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	

}