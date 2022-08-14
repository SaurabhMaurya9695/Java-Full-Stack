package springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // to save in db we have to make this as a entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  // automatic its id incremented
	private int id ;
	// writing same as we define in contact.jsp
	private String name;
	private String pass;
	private String email;

	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + ", email=" + email + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
