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
	public int insert(MovieVO vo);
	public int delete(MovieVO vo);
	public int update(MovieVO vo);
}
