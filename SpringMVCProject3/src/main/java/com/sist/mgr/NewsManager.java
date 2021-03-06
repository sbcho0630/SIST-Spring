package com.sist.mgr;

// ★★★ [뉴스 실시간 크롤링] ★★★
//JSoup을 사용해서 실시간으로 데이터를 크롤링할 수도 있다.
//데이터도 실시간으로 ==> 그래프 그릴 때 등 
//스케쥴링: task 이용. 
import java.util.*;
import java.text.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.sist.mgr.NewsVO;

@Component
public class NewsManager {

	public List<NewsVO> newsAllData()
	{
		List<NewsVO> list = new ArrayList<NewsVO>();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String today=sdf.format(date);
		
		try 
		{			
			//for(int i=1;i<=18;i++) 
			//{
				Document doc = Jsoup.connect("https://movie.daum.net/magazine/new?tab=nws&regdate="+today+"&page=1").get(); 
				
				Elements title=doc.select("ul.list_line strong.tit_line a");
				Elements poster=doc.select("ul.list_line a.thumb_line span.thumb_img");
				Elements link=doc.select("ul.list_line strong.tit_line a");
				Elements temp=doc.select("span.cont_line span.state_line");
				Elements content=doc.select("span.cont_line a.desc_line");
				
				for(int j=0;j<title.size();j++)
				{
					System.out.println(title.get(j).text());
					
					String ss=poster.get(j).attr("style");
					ss=ss.substring(ss.indexOf("(")+1, ss.lastIndexOf(")"));
					System.out.println(ss);
					
					System.out.println(link.get(j).attr("href"));
					String str=temp.get(j).text();
					//String author=str.substring(0, str.indexOf(""));
					//String regdate=str.substring(str.lastIndexOf("자")+1);
					//System.out.println(author);
					//System.out.println(regdate);
					//System.out.println(temp.get(j).text());
					System.out.println(content.get(j).text());
					System.out.println("================================");
					
					
					NewsVO vo=new NewsVO();
					vo.setTitle(title.get(j).text());
					vo.setLink(link.get(j).attr("href"));
					vo.setContent(content.get(j).text());
					vo.setPoster(ss);
					//vo.setRegdate(regdate);
					vo.setAuthor(str);
					
					list.add(vo);
					
					//dao.newsInsert(vo);
					
				}
			//}
			//System.out.println("Save End ...");
					
		} 
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
}
