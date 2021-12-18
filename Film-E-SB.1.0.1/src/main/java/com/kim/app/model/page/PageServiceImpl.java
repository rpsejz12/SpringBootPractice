package com.kim.app.model.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.app.model.movie.MovieVO;

@Service("pageServiceImpl")
public class PageServiceImpl implements PageService {
	
	@Autowired
	private MybatisPageDAO pageDAO;

	public PageVO paging(PageVO vo) {
		vo.setTotal(pageDAO.selectAll(vo));
		
		
		vo.setLastPage((vo.getTotal()-1)/vo.getPerPage()+1);	//마지막 페이지 설정	
		vo.setStart((vo.getCurPage()-1)*vo.getPerPage());		//페이지에 보여줄 게시물 시작
		vo.setEnd(vo.getStart()+vo.getPerPage());				//페이지에 보여줄 게시물 끝		



		vo.setStartPage((vo.getCurPage()-1)/vo.getPerPageSet()*vo.getPerPageSet()+1);	//목차 시작
		if(vo.getStartPage() < 1) {		//시작페이지가 1보다 작을경우 1로 설정
			vo.setStartPage(1);
		}

		vo.setEndPage(vo.getStartPage()+vo.getPerPageSet()-1);							//목차 끝
		if(vo.getEndPage() > vo.getLastPage()) {	//끝페이지가 마지막페이지보다 클경우 마지막페이지로 설정
			vo.setEndPage(vo.getLastPage());
		}

		System.out.println("pageDAO 설정후 vo :" + vo);

		return vo;
	}	
}
