package com.kim.app.model.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private MybatisClientDAO clientDAO;

	public ClientVO login(ClientVO vo) {
		return clientDAO.login(vo);
	}	
	public ClientVO c_selectDB_one(ClientVO vo) {
		return clientDAO.checkID(vo.getId());
	}	
	public boolean checkID(String id) {
		return clientDAO.checkID(id) != null;
	}
	public boolean c_insertDB(ClientVO vo) {
		return clientDAO.insert(vo)>0;
	}	
	@Transactional
	public boolean c_deleteDB(ClientVO vo) {
		clientDAO.delete(vo);
		clientDAO.rUpdate(vo);
		return true;
	}
	
	public boolean c_updateDB(ClientVO vo) {
		return clientDAO.update(vo)>0;
	};
}
