package com.kim.app.model.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private MybatisReviewDAO reviewDAO;

	public ReviewVO login(ReviewVO vo) {
		return reviewDAO.login(vo);
	}	
	public ReviewVO c_selectDB_one(ReviewVO vo) {
		return reviewDAO.login(vo);
	}	
	public boolean checkID(String id) {
		return reviewDAO.checkID(id) != null;
	}
	public boolean c_insertDB(ReviewVO vo) {
		return reviewDAO.c_insertDB(vo)>0;
	}
	public boolean c_deleteDB(ReviewVO vo) {
		return reviewDAO.c_deleteDB(vo)>0;
	}
	public boolean c_updateDB(ReviewVO vo) {
		return reviewDAO.c_updateDB(vo)>0;
	};
}
