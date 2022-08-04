package com.spring.phoenix.oauth.provider;

import java.util.Map;

public class KakaoUserInfo implements Oauth2UserInfo {
	Map<String, Object> attributes;
	Map<String, Object> properties;
	
	//78789017dccc4be030da16f019f344ba -> client-id
	//ryWFEv0DH5lHw78msPgzCX9ydxfycLiO -> 코드
	public KakaoUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
		this.properties = (Map<String, Object>)attributes.get("kakao_account");
	}
	
	@Override
	public String getProviderId() {
		return attributes.get("id")+"";
	}
	
	@Override
	public String getProvider() {
		return "kakao";
	}
	
	@Override
	public String getEmail() {
		return (String)properties.get("email");
	}
	
	@Override
	public String getName() {
		Map profile = (Map)properties.get("profile");
		return (String)profile.get("nickname");
	}
	
}
