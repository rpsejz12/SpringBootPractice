package com.kim.app.model.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kim.app.model.page.PageVO;

@Service("movieServiceImpl")
public class MovieServiceImpl implements MovieService {

	HashMap<String, String> mpkMap = new HashMap<String, String>(){{
		put("액션", "AC");
		put("애니메이션", "AN");
		put("멜로/로맨스", "RO");
		put("드라마", "DR");
		put("다큐멘터리", "DC");
	}};
	ArrayList<MovieVO> datas=null;
	MovieVO data = null;

	@Autowired
	private MybatisMovieDAO movieDAO;


	public ArrayList<MovieVO> m_selectDB_all_m(PageVO vo) {
		datas = movieDAO.selectAllm(vo);
		for(int i = 0; i <datas.size(); i++) {
			if(!datas.get(i).getFilename().substring(0,4).equals("http")) {
				datas.get(i).setFilename("img/"+datas.get(i).getFilename());
			}
		}
		return datas;
	}

	public ArrayList<MovieVO> m_selectDB_all(PageVO vo) {
		datas = movieDAO.selectAll(vo);
		for(int i = 0; i <datas.size(); i++) {
			if(!datas.get(i).getFilename().substring(0,4).equals("http")) {
				datas.get(i).setFilename("img/"+datas.get(i).getFilename());
			}
		}	
		return datas;
	}

	public MovieVO m_selectDB_rand() {	
		Random rand = new Random();
		int temp = 0;
		int cnt = 0;
		temp = rand.nextInt(movieDAO.count());
		
		data = new MovieVO();
		datas = movieDAO.selectRand();
		for(int i = 0; i <datas.size(); i++) {
			if(temp == cnt) {
				data = new MovieVO();
				data.setMpk(datas.get(i).getMpk());
				data.setTitle(datas.get(i).getTitle());
				data.setContent(datas.get(i).getContent());
				data.setMtype(datas.get(i).getMtype());
				data.setMdate(datas.get(i).getMdate());	
				data.setRatingavg(datas.get(i).getRatingavg());
				
				if(!datas.get(i).getFilename().substring(0,4).equals("http")) {
					data.setFilename("img/"+datas.get(i).getFilename());
				}else {
					data.setFilename(datas.get(i).getFilename());
				}
			}
			cnt++;
		}	
		return data;
	}

	public MovieVO m_selectDB_one(MovieVO vo) {
		System.out.println(movieDAO.selectOne(vo));
		System.out.println(vo);
		data = movieDAO.selectOne(vo);
		if(data != null) {
			if(!data.getFilename().substring(0,4).equals("http")) {
				data.setFilename("img/"+data.getFilename());
			}
		}
		return data;
	}

	public boolean m_insertDB(MovieMultiVO vo) {
		String mpkStr = null;      
		String mpkType = null;

		int mpkInt = 0;
		int max = 0;
		boolean isNew = true;

		datas = movieDAO.mpk();
		for(int i = 0; i <datas.size(); i++) {
			mpkStr = datas.get(i).getMpk().substring(2);
			mpkInt = Integer.parseInt(mpkStr);
			if(mpkInt > max) {
				max = mpkInt;
			}
			isNew = false;
		}

		if(isNew) {
			mpkInt =1001;
		}

		if(mpkMap.containsKey(vo.getMtype())) {
			mpkType = mpkMap.get(vo.getMtype());
		}else {
			mpkType = "EX";
			vo.setMtype("ETC");
		}
		max++;
		mpkStr = mpkType + max;
		vo.setMpk(mpkStr);

		return movieDAO.insert(vo)>0;
	}

	public boolean m_updateDB(MovieMultiVO vo) {
		return movieDAO.update(vo)>0;
	}

	@Transactional
	public boolean m_deleteDB(MovieVO vo) {
		movieDAO.delete(vo);
		movieDAO.rdelete(vo);
		return true;
	}
}
