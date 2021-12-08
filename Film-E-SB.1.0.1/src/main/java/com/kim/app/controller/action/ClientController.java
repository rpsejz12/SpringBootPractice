package com.kim.app.controller.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.app.model.client.ClientService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientServiceImpl;

	@RequestMapping("/main.do")
	public String c_select(Model model){
		System.out.println("들어옴?");
		model.addAttribute("datas", clientServiceImpl.c_selectDB());
		return "test";
	}
}
