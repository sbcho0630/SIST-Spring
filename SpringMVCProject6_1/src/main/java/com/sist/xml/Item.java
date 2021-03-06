package com.sist.xml;

public class Item {
	/*  http://newssearch.naver.com/search.naver?where=rss&query=%EC%98%81%ED%99%94
	 *  <item>
			<title>김아중, 패션계까지 접수했다…한혜연 브랜드 모델로 입증</title>
			<link>https://www.tvreport.co.kr/2041295</link>
			<description>
			<![CDATA[
			유수의 영화와 드라마를 통해 탄탄한 연기력을 펼치는 것은 물론, 진정성이 묻어나는 지속적인 선행과 영향력으로 보인 아름다운 됨됨이로 대중의 신뢰를 얻고 있다. 김아중은 ‘믿고 보는 배우’에 이어 ‘선한 영향력의...
			]]>
			</description>
			<pubDate>Fri, 15 May 2020 11:46:00 +0900</pubDate>
			<author>TV리포트</author>
			<category>연예</category>
			<media:thumbnail url="https://imgnews.pstatic.net/image/thumb140/213/2020/05/15/1162990.jpg"/>
		</item>
	 */
	// ★태그 명과 변수명이 반드시 일치해야한다!★ 
	// (다르게 해도 변환할 수는 있지만 alias 줘야함...)
	private String title;
	private String link;
	private String description;
	private String author;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
