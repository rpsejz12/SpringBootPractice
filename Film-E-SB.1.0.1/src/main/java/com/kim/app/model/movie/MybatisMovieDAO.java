package com.kim.app.model.movie;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisMovieDAO {
	public MovieVO login(MovieVO vo);
	public MovieVO checkID(String id);
	public int c_insertDB(MovieVO vo);
	public int c_deleteDB(MovieVO vo);
	public int c_updateDB(MovieVO vo);
}
