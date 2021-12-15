package com.kim.app.model.client;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisClientDAO {
	public ClientVO login(ClientVO vo);
	public ClientVO checkID(String id);
	public int c_insertDB(ClientVO vo);
	public int c_deleteDB(ClientVO vo);
	public int c_updateDB(ClientVO vo);
}
