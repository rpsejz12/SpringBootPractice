package com.kim.app.model.movie;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.app.model.page.PageVO;

@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MybatisMovieDAO movieDAO;

	public ArrayList<MovieVO> m_selectDB_all_m(PageVO vo) {
		ArrayList<MovieVO> datas = movieDAO.selectAllm(vo);
		
		for(int i = 0; i <datas.size(); i++) {
			//이건 되는지 잠시 보류
			if(datas.get(i).getFilename().substring(0,4).equals("http")) {
				datas.get(i).setFilename("img/"+datas.get(i).getFilename());
			}
		}
		// TODO Auto-generated method stub
		return datas;
	}

	public ArrayList<MovieVO> m_selectDB_all(String mtype, String search, PageVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public MovieVO m_selectDB_rand() {
		// TODO Auto-generated method stub
		return null;
	}

	public MovieVO m_selectDB_one(MovieVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean m_insertDB(MovieVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean m_updateDB(MovieVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean m_deleteDB(MovieVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
