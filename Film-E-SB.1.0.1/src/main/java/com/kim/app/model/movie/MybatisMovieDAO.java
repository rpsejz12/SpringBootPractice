package com.kim.app.model.movie;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.kim.app.model.page.PageVO;

@Mapper
public interface MybatisMovieDAO {
	public ArrayList<MovieVO> selectAllm(PageVO vo);
	public ArrayList<MovieVO> selectAll(PageVO vo);
	public MovieVO selectRand();
	public MovieVO selectOne(MovieVO vo);
	public Boolean insert(MovieVO vo);
	public Boolean delete(MovieVO vo);
	public Boolean update(MovieVO vo);
}
