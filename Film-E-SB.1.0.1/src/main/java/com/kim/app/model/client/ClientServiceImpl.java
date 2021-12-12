package com.kim.app.model.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private MybatisClientDAO clientDAO;

	public ClientVO login(ClientVO vo) {
		return clientDAO.login(vo);
	}	
	public ClientVO c_selectDB_one(ClientVO vo) {
		return clientDAO.login(vo);
	}	
	public boolean checkID(String id) {
		return clientDAO.checkID(id) != null;
	}
	public boolean c_insertDB(ClientVO vo) {
		return clientDAO.c_insertDB(vo);
	}
	public boolean c_deleteDB(ClientVO vo) {
		return clientDAO.c_deleteDB(vo);
	}
	public boolean c_updateDB(ClientVO vo) {
		return clientDAO.c_updateDB(vo);
	};
}
