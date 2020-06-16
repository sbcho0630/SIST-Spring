package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicVO {
	private int mno;
	private int rank;
	private String title;
	private String singer; //
	private String album;
	private String poster;
	private int idcrement;
	private String state;
	private String key;
	private int hit; // 댓글 수(?): 댓글 올라가면 hit 증가. Trigger 사용.
	
	// private : 은닉화
	// @Getter,@Setter ===> 캡슐화 
}


/*
 *  MNO       NOT NULL NUMBER        
	RANK               NUMBER        
	TITLE              VARCHAR2(500) 
	SINGER             VARCHAR2(200) 
	ALBUM              VARCHAR2(300) 
	POSTER             VARCHAR2(260) 
	IDCREMENT          NUMBER        
	STATE              CHAR(6)       
	KEY                VARCHAR2(100) 
	HIT                NUMBER        
*/
