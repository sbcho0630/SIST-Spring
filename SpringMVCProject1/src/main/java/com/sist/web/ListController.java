package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
	@RequestMapping("main/list.do")
	public String main_list(HttpServletRequest request) // 옛날방식 - 지양해야.
	{
		request.setAttribute("msg", "Hello, Spring!");
		return "list"; // JSP의 이름만 주면 됨. ex) return "list";(O) return "list" (X); 
	}
	/* 
	 * 	public class Model
	 * 	{
	 * 		public void addAttribte(String key,Object obj)
	 * 		{
	 * 			request.setAttribue(key,obj);
	 * 		} 
	 * 	}
	 */
	
	@RequestMapping("main/list2.do")
	public String main_list2(Model model)// 이제부터는 request대신에 Model을 사용하여 데이터 전달
	{
		model.addAttribute("msg","Hello Spring~~"); // Model은 JSP 추가된 데이터만 전송 // MODEL 
		//model.addAttribute("msg1","Hi Spring~~");
		//model.addAttribute("msg2","Haha Spring~~");
		//model.addAttribute("msg3","Spring~~");
		return "list2"; // VIEW 
	}
	
	@GetMapping("main/input.do")
	public String main_input()
	{
		return "input"; //input.jsp라고 확장자 쓰면 안 됨!!!
	}
	
	// [방법1] - 소스가 너무 길다. 비효율적. 
	@PostMapping("main/output.do")
	public String main_output(HttpServletRequest request)
	{
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {}
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		String content=request.getParameter("content");
		
		MemberVO vo=new MemberVO();
		vo.setName(name);
		vo.setSex(sex);
		//vo.setAddr(addr);
		vo.setTel(tel);
		vo.setContent(content);
		
		request.setAttribute("vo", vo);
		
		return "output"; //output.jsp라고 확장자 쓰면 안 됨!!!
	}
	
	
	/* 
	 * list.do?p=2
	 * 
	 * board_list(Model model, int p)
	 * 
	 * 
	 * find.do?title=영화
	 * movie_find(Model model,@RequestParam("title") String title)
	 *                        ===================== 생략가능
	 *
	 */
	
	// [방법2] - 효율적.
	@PostMapping("main/output2.do")
	public String main_output2(Model model,MemberVO vo)
	{
		model.addAttribute("vo",vo);
		return "output";
	}
	
	
	
	
	
}










