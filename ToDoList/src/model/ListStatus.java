package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LIST_STATUS database table.
 * 
 */
@Entity
@Table(name="LIST_STATUS", schema="testDB")
@NamedQuery(name="ListStatus.findAll", query="SELECT l FROM ListStatus l")
public class ListStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int statusid;

	private int listid;

	@Column(name="STAT_MSG")
	private String statMsg;

	private int userid;

	public ListStatus() {
	}

	public int getStatusid() {
		return this.statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public int getListid() {
		return this.listid;
	}

	public void setListid(int listid) {
		this.listid = listid;
	}

	public String getStatMsg() {
		return this.statMsg;
	}

	public void setStatMsg(String statMsg) {
		this.statMsg = statMsg;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}