package Model;

import java.lang.Boolean;

@Entity
@Table(name="QUESTION")
public class Question {
		
// attributs privés
	private Integer id;
	private Integer goodAnswerId;
	private String entitled;
	private Boolean status;
	
	public Question() {}
		
	// classe publique
		
	public Survey(Integer id, String entitled, Integer goodAnswerId, Boolean status) {
		this.id = id;
		this.entitled = entitled;
		this.goodAnswerId = goodAnswerId;
		this.status = status;
	}
	
	// fonction set 
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setSubject(String entitled) {
		this.entitled = entitled;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public void setGoodAnswerId(Integer goodAnswerId) {
		this.goodAnswerId = goodAnswerId;
	}
	
	// fonction get
	
	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	
	@Basic
	@NotNull
	@Column(name = "ENTITLED")
	public String getEntitled() {
		return entitled;
	}
	
	@Basic
	@NotNull
	@Column(name = "GOOD_ANSWER_ID")
	public String getGoodAnswerId() {
		return goodAnswerId;
	}
	
	@Basic
	@NotNull
	@Column(name = "STATUS")
	public Boolean getStatus() {
		return status;
	}
}
