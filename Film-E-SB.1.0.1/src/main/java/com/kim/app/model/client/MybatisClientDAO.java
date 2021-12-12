package com.kim.app.model.client;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisClientDAO {
	public ClientVO login(ClientVO vo);
	public ClientVO checkID(String id);
	public boolean c_insertDB(ClientVO vo);
	public boolean c_deleteDB(ClientVO vo);
	public boolean c_updateDB(ClientVO vo);
}
