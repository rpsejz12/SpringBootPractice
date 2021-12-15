package com.kim.app.model.movie;

public interface MovieService {
	
	public MovieVO login(MovieVO vo);
	public MovieVO c_selectDB_one(MovieVO vo);
	public boolean checkID(String id);
	public boolean c_insertDB(MovieVO vo);
	public boolean c_deleteDB(MovieVO vo);
	public boolean c_updateDB(MovieVO vo);

}
