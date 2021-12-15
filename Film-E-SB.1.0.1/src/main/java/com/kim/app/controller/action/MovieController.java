package com.kim.app.controller.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kim.app.model.movie.MovieService;
import com.kim.app.model.page.PageService;
import com.kim.app.model.page.PageVO;

public class MovieController {
	
	
	@Autowired
	private PageService pageServiceImpl;
	
	@Autowired
	private MovieService movieServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(ClientController.class);

	
	
	@RequestMapping("/Main.do")
	public String main(PageVO pVO, Model model, @RequestParam(value="page",defaultValue="1")int page, @RequestParam(value="mtype")String mtype, @RequestParam(value="search")String search) {
		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(12);		//	페이지 게시물 수
		pVO.setPerPageSet(5);	//	페이지 수

		pVO = pageServiceImpl.paging(pVO,null,mtype,search,"movie");
		model.addAttribute("datas",movieServiceImpl.m_selelctDB_all_m);
		model.addAttribute("paging",pVO);
		model.addAttribute("page", page);
		return "main";
	}

}
