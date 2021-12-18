package com.kim.app.model.client;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MybatisClientDAO {
	public ClientVO login(ClientVO vo);
	public ClientVO checkID(String id);
	public int insert(ClientVO vo);
	public int delete(ClientVO vo);
	public int update(ClientVO vo);
	public int rUpdate(ClientVO vo);
}
