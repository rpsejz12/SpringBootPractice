package com.kim.app.model.review;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.app.model.page.PageVO;

@Service("reviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private MybatisReviewDAO reviewDAO;
	
	public ArrayList<ReviewVO> r_selectDB_all(PageVO vo) {
		return reviewDAO.rSelectAll(vo);
	}

	public ReviewVO r_selectDB_one(ReviewVO vo) {
		return reviewDAO.rSelectOne(vo);
	}

	public boolean r_insertDB(ReviewVO vo) {
		reviewDAO.insert(vo);
		vo.setRatingavg(Math.round(reviewDAO.starAVG(vo)*10)/10.0);
		reviewDAO.mUpdate(vo);
		return true;
	}

	public boolean r_deleteDB(ReviewVO vo) {
		reviewDAO.delete(vo);
		vo.setRatingavg(Math.round(reviewDAO.starAVG(vo)*10)/10.0);
		reviewDAO.mUpdate(vo);
		return true;
	}
}
