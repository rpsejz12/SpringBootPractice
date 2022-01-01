package com.kim.app.controller.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kim.app.model.movie.MovieMultiVO;
import com.kim.app.model.movie.MovieService;
import com.kim.app.model.movie.MovieVO;
import com.kim.app.model.page.PageService;
import com.kim.app.model.page.PageVO;


@Controller
public class MovieController {
	
	
	@Autowired
	private PageService pageServiceImpl;
	
	@Autowired
	private MovieService movieServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(ClientController.class);

	
	
	@RequestMapping("/Main.do")
	public String main(PageVO pVO, Model model, @RequestParam(value="page",defaultValue="1")int page) {
		logger.info("params = [ " + pVO + "]");
		pVO.setTable("movie");
		pVO.setCurPage(page);	//	현재 페이지	
		pVO.setPerPage(12);		//	페이지 게시물 수
		pVO.setPerPageSet(5);	//	페이지 수

		pVO = pageServiceImpl.paging(pVO);
		
		model.addAttribute("datas",movieServiceImpl.m_selectDB_all_m(pVO));
		model.addAttribute("paging",pVO);
		model.addAttribute("page", page);
		
		logger.info("main datas : " + model.getAttribute("datas"));
		return "main";
	}
	
	@RequestMapping("/Admin.do")
	public String admin(MovieVO mVO, Model model) {
		System.out.println(mVO);
		model.addAttribute("datas",movieServiceImpl.m_selectDB_one(mVO));
		return "admin";
	}
	
	@RequestMapping("/Adminlist.do")
	public String adminlist(PageVO pVO, Model model, @RequestParam(value="page",defaultValue="1")int page) {
		pVO.setTable("movie");
		pVO.setCurPage(page);    
	    pVO.setPerPage(12); 
	    pVO.setPerPageSet(5);
	    pVO = pageServiceImpl.paging(pVO);
	    model.addAttribute("datas",movieServiceImpl.m_selectDB_all(pVO));
		model.addAttribute("paging",pVO);
		model.addAttribute("page", page);
		model.addAttribute("search", pVO.getSearch());
		return "adminlist";
	}
	
	@RequestMapping("/Categories.do")
	public String categories(PageVO pVO, Model model, @RequestParam(value="page",defaultValue="1")int page) {
		pVO.setTable("movie");
		pVO.setCurPage(page);    
	    pVO.setPerPage(8); 
	    pVO.setPerPageSet(5);
	    pVO = pageServiceImpl.paging(pVO);
	    model.addAttribute("datas",movieServiceImpl.m_selectDB_all(pVO));
		model.addAttribute("paging",pVO);
		model.addAttribute("page", page);
		model.addAttribute("mtype", pVO.getMtype());
		model.addAttribute("page", pVO.getSearch());
		return "categories";
	}
	
	@RequestMapping("/Minsert.do")
	public String minsert(HttpServletRequest request, HttpServletResponse response, MovieMultiVO vo) throws IllegalStateException, IOException {
		
		PrintWriter out = response.getWriter();
		String savedir = request.getSession().getServletContext().getRealPath("img");
		
		MultipartFile fileupload = vo.getFilename();
		
		if(!fileupload.isEmpty()) {
			vo.setFileupload(UUID.randomUUID().toString().substring(0,7)+fileupload.getOriginalFilename());
			fileupload.transferTo(new File(savedir+"/"+vo.getFileupload()));
		}

		if(movieServiceImpl.m_insertDB(vo)) {
			return "redirect:Adminlist.do";
		}
		else {
			File file = new File(savedir+"/"+vo.getFileupload());
			if(file.exists()) {
				file.delete();
			}
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('게시물 등록 실패');history.go(-1)</script>");
			return null;
		}
	}
	
	@RequestMapping("/Mupdate.do")
	public String mupdate(HttpServletRequest request, HttpServletResponse response, MovieMultiVO vo) throws IOException {
		PrintWriter out = response.getWriter();
		String savedir = request.getSession().getServletContext().getRealPath("img");
		
		MultipartFile fileupload = vo.getFilename();
		
		
		MovieVO mvo = new MovieVO();
		mvo.setMpk(vo.getMpk());
	
		if(!fileupload.isEmpty()) {
			vo.setFileupload(UUID.randomUUID().toString().substring(0,7)+fileupload.getOriginalFilename());
			fileupload.transferTo(new File(savedir+"/"+vo.getFileupload()));
		}else {
			mvo = (movieServiceImpl.m_selectDB_one(mvo));
			mvo.setFilename(mvo.getFilename().replace("img/", ""));
			vo.setFileupload(mvo.getFilename());
		}

		if(movieServiceImpl.m_updateDB(vo)) {
			if(!fileupload.isEmpty()) {
				File file = new File(savedir+"/"+mvo.getFilename());
				if(file.exists()) {
					file.delete();
				}
			}
			return "redirect:Adminlist.do";
		}else {
			File file = new File(savedir+"/"+vo.getFileupload());
			if(file.exists()) {
				file.delete();
			}
			response.setContentType("text/html; charset=UTF-8");      
			out.println("<script>alert('수정 실패');history.go(-1)</script>"); // 사진 수정 실패 시 alert창
			return null;
		}
	}
	
	@RequestMapping("/Mdelete.do")
	public String mdelete(HttpServletRequest request, HttpServletResponse response, MovieVO vo) throws IOException {
		PrintWriter out = response.getWriter();
		String savedir = request.getSession().getServletContext().getRealPath("img");
		vo = movieServiceImpl.m_selectDB_one(vo);
		try {
			movieServiceImpl.m_deleteDB(vo);
			File file = new File(savedir+"/"+vo.getFilename());
			if(file.exists()) {
				file.delete();
			}
			return "redirect:Adminlist.do";
		}catch(Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			out.println("<script>alert('사진 삭제 실패!');history.go(-1)</script>"); //게시물 삭제 실패 시 alert
			return null;
		}

	}
}
