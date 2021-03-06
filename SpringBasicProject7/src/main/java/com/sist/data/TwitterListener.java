package com.sist.data;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class TwitterListener implements StatusListener{

	@Override
	public void onException(Exception ex) { 
		// 에러났을 때 처리하는 부분
		System.out.println(ex.getMessage());
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatus(Status status) {
		// 실제 처리하는 부분 - 한 줄을 읽을 때마다 onStatus
		System.out.println(status.getUser().getScreenName());
		System.out.println(status.getText());
		System.out.println(status.getCreatedAt()); // 쓴 날짜 
		System.out.println(status.getFavoriteCount());
		System.out.println(status.getUser().getProfileBackgroundImageURL());
		System.out.println("===============================================");
		
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
