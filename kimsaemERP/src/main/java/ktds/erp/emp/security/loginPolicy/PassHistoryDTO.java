package ktds.erp.emp.security.loginPolicy;

import java.sql.Date;

public class PassHistoryDTO {
	private String id;
	private Date pass_modify_date;
	private String password;
	private String passchangestate;
	public PassHistoryDTO() {
		
	}
	public PassHistoryDTO(String id, Date pass_modify_date, String password, String passchangestate) {
		super();
		this.id = id;
		this.pass_modify_date = pass_modify_date;
		this.password = password;
		this.passchangestate = passchangestate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getPass_modify_date() {
		return pass_modify_date;
	}
	public void setPass_modify_date(Date pass_modify_date) {
		this.pass_modify_date = pass_modify_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasschangestate() {
		return passchangestate;
	}
	public void setPasschangestate(String passchangestate) {
		this.passchangestate = passchangestate;
	}
	@Override
	public String toString() {
		return "PassHistoryDTO [id=" + id + ", pass_modify_date=" + pass_modify_date + ", password=" + password
				+ ", passchangestate=" + passchangestate + "]";
	}
	
}
