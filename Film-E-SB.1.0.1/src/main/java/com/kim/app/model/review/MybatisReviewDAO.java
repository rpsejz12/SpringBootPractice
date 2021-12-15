package com.kim.app.model.review;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisReviewDAO {
	public ReviewVO login(ReviewVO vo);
	public ReviewVO checkID(String id);
	public int c_insertDB(ReviewVO vo);
	public int c_deleteDB(ReviewVO vo);
	public int c_updateDB(ReviewVO vo);
}
