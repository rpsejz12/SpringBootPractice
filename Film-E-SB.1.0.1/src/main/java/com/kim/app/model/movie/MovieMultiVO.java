package com.kim.app.model.movie;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("MovieMultiVO")
public class MovieMultiVO {
	private String mpk;				//pk 장르 + nvl 
	private String title;			//영화 이름
	private String content;			//영화 설명
	private String mtype;			//영화 장르
	private String mdate;			//영화 개봉일
	private MultipartFile filename;		//영화 이미지
	private String fileupload;
	private double ratingavg;
	
	
	public String getMpk() {
		return mpk;
	}
	public void setMpk(String mpk) {
		this.mpk = mpk;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
	
	public MultipartFile getFilename() {
		return filename;
	}
	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}
	public String getFileupload() {
		return fileupload;
	}
	public void setFileupload(String fileupload) {
		this.fileupload = fileupload;
	}
	public double getRatingavg() {
		return ratingavg;
	}
	public void setRatingavg(double ratingavg) {
		this.ratingavg = ratingavg;
	}
	
	
	
	@Override
	public String toString() {
		return "MovieMultiVO [mpk=" + mpk + ", title=" + title + ", content=" + content + ", mtype=" + mtype
				+ ", mdate=" + mdate + ", filename=" + filename + ", fileupload=" + fileupload + ", ratingavg="
				+ ratingavg + "]";
	}
	
	
}
