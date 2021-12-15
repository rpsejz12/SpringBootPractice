package com.kim.app.model.client;

public interface ClientService {
	
	public ClientVO login(ClientVO vo);
	public ClientVO c_selectDB_one(String vo);
	public boolean checkID(String id);
	public boolean c_insertDB(ClientVO vo);
	public boolean c_deleteDB(ClientVO vo);
	public boolean c_updateDB(ClientVO vo);

}
