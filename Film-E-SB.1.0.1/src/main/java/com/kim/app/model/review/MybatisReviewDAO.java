package com.kim.app.model.review;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.kim.app.model.page.PageVO;

@Mapper
public interface MybatisReviewDAO {
	public ArrayList<ReviewVO> rSelectAll(PageVO vo);
	public ReviewVO rSelectOne(ReviewVO vo);
	public double starAVG(ReviewVO vo);
	public int insert(ReviewVO vo);
	public int delete(ReviewVO vo);
	public int mUpdate(ReviewVO vo);
}
