package com.kim.app.model.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MybatisMovieDAO movieDAO;

	public MovieVO login(MovieVO vo) {
		return movieDAO.login(vo);
	}	
	public MovieVO c_selectDB_one(MovieVO vo) {
		return movieDAO.login(vo);
	}	
	public boolean checkID(String id) {
		return movieDAO.checkID(id) != null;
	}
	public boolean c_insertDB(MovieVO vo) {
		return movieDAO.c_insertDB(vo)>0;
	}
	public boolean c_deleteDB(MovieVO vo) {
		return movieDAO.c_deleteDB(vo)>0;
	}
	public boolean c_updateDB(MovieVO vo) {
		return movieDAO.c_updateDB(vo)>0;
	};
}
