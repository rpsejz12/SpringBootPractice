package com.kim.app.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kim.app.model.client.ClientService;
import com.kim.app.model.client.ClientVO;

@Controller
@SessionAttributes("sessionID")
public class ClientController {
	
	@Autowired
	private ClientService clientServiceImpl;
	
	Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@RequestMapping("/Login.do")
	public String login(Model model, ClientVO vo, HttpServletResponse response) throws IOException{
		if(clientServiceImpl.login(vo) != null) {
			model.addAttribute("sessionID", vo.getId());
			if(vo.getId().equals("admin")) { // 관리자 로그인 처리
				return "redirect:Adminlist.do";
			}
			else {
				return "redirect:Main.do";
			}
		}
		else {			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인에 실패하였습니다. 아이디 혹은 비밀번호 확인 후 다시 입력하세요.');history.go(-1)</script>");
			return null;
		}
	}
	
	
	@RequestMapping("/Logout.do")
	public String logout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/CheckID.do")
	public String checkID(@RequestParam(value="id")String id, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		if(id == null || id == "") {
			out.println("null");
		}
		else {
			out.println(clientServiceImpl.checkID(id));
		}
		return null;
	}
	
	
	
	
	@RequestMapping("/Cinsert.do")
	public String c_insertDB(ClientVO vo, HttpServletResponse response) throws IOException{		
		if(clientServiceImpl.c_insertDB(vo)) {
			return "redirect:login.jsp";
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입 실패!');history.go(-1)</script>");
			return null;	
		}
	}
	
	@RequestMapping("/Cupdate.do")
	public String c_updateDB(ClientVO vo, HttpServletResponse response) throws IOException{
		if(clientServiceImpl.c_updateDB(vo)) {
			return "rediect:CselectOnde.do";
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원 정보 변경에 실패하였습니다. 다시 시도해 주세요.');history.go(-1)</script>");
			return null;
		}
	}
	
	@RequestMapping("/Cdelete.do")
	public String c_deleteDB(ClientVO vo, @ModelAttribute("sessionID")String id, HttpServletResponse response, SessionStatus sessionStatus) throws IOException{
		vo.setId(id);	
		if(clientServiceImpl.c_updateDB(vo)) {
			sessionStatus.setComplete();
			return "redirect:Main.do";
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원 삭제에 실패하였습니다. 다시 시도해 주세요.');history.go(-1)</script>");
			return null;
		}
	}
	
	
	@RequestMapping("/CselectOne.do")
	public String c_selectDB_one(Model model, ClientVO vo,@ModelAttribute("sessionID")String id ,HttpServletResponse response) throws IOException{
		vo.setId(id);
		if(clientServiceImpl.c_selectDB_one(vo) != null) {
			model.addAttribute("data", clientServiceImpl.c_selectDB_one(vo));
			return "mypage";
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('접근 실패!');history.go(-1)</script>");
			return null;
		}
	}
	
	
}
