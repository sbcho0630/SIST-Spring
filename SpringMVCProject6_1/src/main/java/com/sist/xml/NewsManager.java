package com.sist.xml;
// newssearch.naver.com/search.naver?where=rss&query=영화
// ====================  ============
// 서버주소 				 MVC 구조구나!! (*.do가 아니라 .naver인듯) 
// 위의 url에 접속하면 XML을 볼 수 있음

// ★★★ [구조] ★★★
// - <rss>, <channel>, <item> 태그로 구성 ==> 이 세 개의 태그는 ★Class★
// - <item> 태그 안의 태그들은 <태그>데이터</태그>로 구성되어 있음 ex) <title>, <link>, <description>
//    ===> <item> 하위 태그들은 ★변수★
// - 마치, XE > Table > Column 처럼 rss > item > item 하위 태그들 
// - ★Rss 클래스 안에 Channel을 갖다놓고 getter/setter 만들고, 
//   Channel 클래스 안에 Item을 갖다놓고 getter/setter 만들고,
//   Item 클래스 안에 변수설정하고 getter/setter 만든다.★

import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import java.net.*; // 인코딩 함수를 갖고있음 

@Component // 일반 클래스니까 
public class NewsManager {
	public List<Item> newsAllData(String search_keyword)
	{
		List<Item> list=new ArrayList<Item>();
		try 
		{
			JAXBContext jc=JAXBContext.newInstance(Rss.class);
			//                                     ========== 최상위태그 클래스(XML Root Element)가 와야한다
			// [Unmarshal]
			Unmarshaller un=jc.createUnmarshaller(); // Unmarshaller: javax.xml.bind꺼 갖고와야함
			// - Marshal: Java ===> XML
			// - Unmarshal: XML ===> Java
			
			// [인코딩] - 검색쿼리가 한글일 수 있으니 인코딩 시켜줘야함 ex) query=코로나 ==> query=%EC%BD%94%EB%A1%9C%EB%82%98
			URL url=new URL("http://newssearch.naver.com/search.naver?where=rss&query="
							+URLEncoder.encode(search_keyword,"UTF-8"));
			Rss rss=(Rss)un.unmarshal(url);

			list=rss.getChannel().getItem();
			// <channel> 태그 안에 <item> 태그가 여러개 ==> list로 받는다 
			
		} catch (Exception ex) {}
		return list;
	}
}







