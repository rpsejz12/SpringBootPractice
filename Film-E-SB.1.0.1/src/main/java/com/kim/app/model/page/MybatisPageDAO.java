package com.kim.app.model.page;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisPageDAO {
	public int pagecnt(PageVO vo);
}
