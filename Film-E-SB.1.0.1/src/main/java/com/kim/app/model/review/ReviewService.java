package com.kim.app.model.review;

import java.util.ArrayList;

import com.kim.app.model.page.PageVO;

public interface ReviewService {
	
	public ArrayList<ReviewVO> r_selectDB_all(PageVO vo);
	public ReviewVO r_selectDB_one(ReviewVO vo);
	public boolean r_insertDB(ReviewVO vo);
	public boolean r_deleteDB(ReviewVO vo);

}
