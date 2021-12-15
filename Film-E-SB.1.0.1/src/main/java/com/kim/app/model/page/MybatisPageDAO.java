package com.kim.app.model.page;

import org.apache.ibatis.annotations.Mapper;

import com.kim.app.model.movie.MovieVO;

@Mapper
public interface MybatisPageDAO {
	public int pagecnt(PageVO pvo,MovieVO mvo, String mtype, String search, String table);
}
