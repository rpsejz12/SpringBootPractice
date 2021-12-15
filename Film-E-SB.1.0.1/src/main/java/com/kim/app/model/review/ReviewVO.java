package com.kim.app.model.review;

import org.apache.ibatis.type.Alias;

@Alias("ReviewVO")
public class ReviewVO {
	private String id;
	private String pw;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}
	
	
}
