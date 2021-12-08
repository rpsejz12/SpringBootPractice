package com.kim.app.model.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private MybatisClientDAO clientDAO;
	
	public List<ClientVO> c_selectDB() {
		return clientDAO.c_selectDB();
	}
}
