package com.kim.app.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.app.model.movie.MovieService;
import com.kim.app.model.movie.MovieVO;
import com.kim.app.model.page.PageService;
import com.kim.app.model.page.PageVO;
import com.kim.app.model.review.ReviewService;
import com.kim.app.model.review.ReviewVO;

@Controller
@SessionAttributes("sessionID")
public class ReviewController {
	
	@Autowired
	private PageService pageServiceImpl;
	
	@Autowired
	private ReviewService reviewServiceImpl;

	@Autowired
	private MovieService movieServiceImpl;
	
	@ModelAttribute("sessionID")
	public String ifNull() {
		return null;
	}
	
	
	@RequestMapping("/RselectAll.do")
	public String rselectAll(PageVO pVO,ReviewVO rVO, Model model, @RequestParam(value="page",defaultValue="1")int page, @ModelAttribute(value = "sessionID")String id) {
		MovieVO mVO = new MovieVO();
		MovieVO rmVO = new MovieVO();
		
		rVO.setId(id);
		mVO.setMpk(rVO.getMpk());

		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(8);		//	페이지 게시물 수
		pVO.setPerPageSet(3);	//	페이지 수
		pVO.setTable("review");
		
		mVO = movieServiceImpl.m_selectDB_one(mVO);
		rVO = reviewServiceImpl.r_selectDB_one(rVO);
		
		
		while(true) {
			rmVO = movieServiceImpl.m_selectDB_rand();
			if(!rmVO.getMpk().equals(mVO.getMpk())) {
				break;
			}
		}
		
		System.out.println("여기" + rmVO);
		pVO = pageServiceImpl.paging(pVO);		
		model.addAttribute("mdata", mVO);
		model.addAttribute("mrand", rmVO);
		model.addAttribute("paging", pVO);
		model.addAttribute("page", page);
		model.addAttribute("datas", reviewServiceImpl.r_selectDB_all(pVO));
		model.addAttribute("data", rVO);
		return "review";
	}

	@RequestMapping("/Rinsert.do")
	public String rinsert(ReviewVO vo, @ModelAttribute("sessionID")String id, @RequestParam("rating")Double rating, HttpServletResponse response) throws IOException {
		vo.setId(id);
		
		if(rating != null) {
			vo.setRatingavg(rating);
		}else {
			vo.setRatingavg(3.0);
		}
		
		try {
			reviewServiceImpl.r_insertDB(vo);
			return "redirect:RselectAll.do?mpk=" + vo.getMpk();
		}catch(Exception e) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('리뷰 등록 실패!');history.go(-1)</script>");
			return null;
		}
	}
	
	@RequestMapping("/Rdelete.do")
	public String rdelete(PageVO pVO,ReviewVO rVO, Model model, @RequestParam(value="page",defaultValue="1")int page, HttpServletResponse response) throws IOException {
		
		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(8);		//	페이지 게시물 수
		pVO.setPerPageSet(3);	//	페이지 수
		pVO.setTitle("review");
		
		pVO = pageServiceImpl.paging(pVO);
		
		try {
			reviewServiceImpl.r_deleteDB(rVO);
			return "redirect:RselectAll.do?mpk="+rVO.getMpk();
		}catch (Exception e){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('리뷰 삭제 실패!');history.go(-1)</script>");
			return null;
		}		
	}

}
