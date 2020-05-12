package com.sist.myapp2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/")
public class MainController {
	@RequestMapping("main.do") // 위의 @RequestMapping("main/") + @RequestMapping("main.do") ==> main/main.do 
	public String main_main(Model model) // 데이터 전송하면 무조건 model이 있어야함 
	{
		
		
		model.addAttribute("main_jsp","default.jsp");
		return "main/main";
	}
	
	
}
