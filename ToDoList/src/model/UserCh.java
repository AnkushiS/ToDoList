package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_CH database table.
 * 
 */
@Entity
@Table(name="USER_CH", schema="testdb")
@NamedQuery(name="UserCh.findAll", query="SELECT u FROM UserCh u")
public class UserCh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userid;

	private int birthyear;

	private String email;

	private String firstname;

	private String lastname;

	public UserCh() {
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBirthyear() {
		return this.birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}