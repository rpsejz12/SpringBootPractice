package com.kim.app.model.page;

import org.apache.ibatis.type.Alias;

@Alias("PageVO")
public class PageVO {
	int curPage;	//현재 페이지
	int startPage;	//페이지 목차 시작	< '1' 2 3 4 5 >
	int endPage;	//페이지 목차 끝	< 1 2 3 4 '5' >
	int lastPage;	//마지막 페이지	< 11 12 '13'> 전체 페이지의 마지막
	int total;		//게시물 총 개수
	int perPage;	//페이지당 출력할 게시물 수
	int perPageSet; //페이지 목차 출력할 개수 < 1 2 3 4 5 > => 5개 
	int start;		//현재페이지에서 시작 게시물
	int end;		//현재페이지에서 끝 게시물
	
	
	
	private String mpk;				//pk 장르 + nvl 
	private String title;			//영화 이름
	private String content;			//영화 설명
	private String mtype;			//영화 장르
	private String mdate;			//영화 개봉일
	private String filename;		//영화 이미지
	private double ratingavg;
	private String table;
	private String search;

	
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}	
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}	
	public int getPerPageSet() {
		return perPageSet;
	}
	public void setPerPageSet(int perPageSet) {
		this.perPageSet = perPageSet;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
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
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public double getRatingavg() {
		return ratingavg;
	}
	public void setRatingavg(double ratingavg) {
		this.ratingavg = ratingavg;
	}
	@Override
	public String toString() {
		return "PageVO [curPage=" + curPage + ", startPage=" + startPage + ", endPage=" + endPage + ", lastPage="
				+ lastPage + ", total=" + total + ", perPage=" + perPage + ", perPageSet=" + perPageSet + ", start="
				+ start + ", end=" + end + ", mpk=" + mpk + ", title=" + title + ", content=" + content + ", mtype="
				+ mtype + ", mdate=" + mdate + ", filename=" + filename + ", ratingavg=" + ratingavg + ", table="
				+ table + ", search=" + search + "]";
	}	
}
