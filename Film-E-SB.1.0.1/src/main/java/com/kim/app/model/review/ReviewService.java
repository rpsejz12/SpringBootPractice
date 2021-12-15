package com.kim.app.model.review;

public interface ReviewService {
	
	public ReviewVO login(ReviewVO vo);
	public ReviewVO c_selectDB_one(ReviewVO vo);
	public boolean checkID(String id);
	public boolean c_insertDB(ReviewVO vo);
	public boolean c_deleteDB(ReviewVO vo);
	public boolean c_updateDB(ReviewVO vo);

}
