package com.kim.app.model.movie;

import java.util.ArrayList;

import com.kim.app.model.page.PageVO;

public interface MovieService {
	public ArrayList<MovieVO> m_selectDB_all_m(PageVO vo);
	public ArrayList<MovieVO> m_selectDB_all(PageVO vo);
	public MovieVO m_selectDB_rand();
	public MovieVO m_selectDB_one(MovieVO vo);
	public boolean m_insertDB(MovieVO vo);
	public boolean m_updateDB(MovieVO vo);
	public boolean m_deleteDB(MovieVO vo);
}
