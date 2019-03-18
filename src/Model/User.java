package Model;
import java.sql.Date;

public class User {
	private String mail;
	private String name;
	private String company;
	private String phone;
	private Date creationDate;
	private Integer status;
	
	public User() {}
	
	public User(String mail, String name, String company, String phone, Date creationDate, Integer status) {
	this.mail = mail;
	this.name = name;
	this.company = company;
	this.phone = phone;
	this.creationDate = creationDate;
	this.status = status;
	}
	
	public setMail(String mail) {
		this.mail = mail;
	}
	
	
	
}
