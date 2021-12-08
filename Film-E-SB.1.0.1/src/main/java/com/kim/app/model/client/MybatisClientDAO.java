package com.kim.app.model.client;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisClientDAO {
	public List<ClientVO> c_selectDB();
}
