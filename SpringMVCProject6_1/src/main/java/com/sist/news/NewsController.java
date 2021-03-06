package com.sist.news;

import java.io.*;
import java.util.*;
import com.sist.xml.*;
import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {
	@Autowired
	private NewsManager nm;
	
	@RequestMapping("main/news.do")
	public String main_new(Model model,String search_keyword)
	{
		if(search_keyword==null)
			search_keyword="코로나";
		// A에서 정보를 보내서 A(자기자신)에게 출력 ==> null값 신경써줘야 
		
		List<Item> list=nm.newsAllData(search_keyword);
		model.addAttribute("list",list);
		
		try 
		{
			String temp="";
			for(Item i:list)
			{
				temp+=i.getDescription()+"\r\n";
			}
			FileWriter fw=new FileWriter("c:\\data\\naver.txt");
			fw.write(temp);
			fw.close();
			
			rGraph();  // 함수호출 ★★★ 
		} catch (Exception ex) {}
		
		return "main/news";
	}
	
	
	// Mapping 없음 ==> Spring 안에 안 들어감. 내 맘대로 코딩...
	// R로 그래프
	// C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVCProject6_1\main
	public void rGraph()
	{
		try 
		{
			// R 연동
			RConnection rc=new RConnection();
			rc.voidEval("library(rJava)");
			rc.voidEval("library(KoNLP)");
			rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVCProject6_1/main/news.png\")");
			rc.voidEval("data<-readLines(\"c:/data/naver.txt\")");
			rc.voidEval("data2<-sapply(data, extractNoun,USE.NAMES = F)");
			rc.voidEval("data3<-unlist(data2)");
			rc.voidEval("data3<-gsub(\"[A-Za-z]\",\"\",data3)");
			rc.voidEval("data3<-gsub(\"[0-9]\",\"\",data3)");
			rc.voidEval("data4<-table(data3)");
			rc.voidEval("data5<-head(sort(data4,decreasing = T),100)");
			rc.voidEval("library(wordcloud)");
			rc.voidEval("wordcloud(names(data5),freq = data5,min.freq = 2,scale = c(5,1), rot.per = 0.25,random.order = F,colors = rainbow(15))");
			rc.voidEval("dev.off()");
			rc.close();
			
		} catch (Exception ex) {}
	}
	
	
}





