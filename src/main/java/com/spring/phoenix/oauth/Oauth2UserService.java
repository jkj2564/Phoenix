package com.spring.phoenix.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.spring.phoenix.entitiy.CustomUserDetails;
import com.spring.phoenix.entitiy.User;
import com.spring.phoenix.oauth.provider.KakaoUserInfo;
import com.spring.phoenix.oauth.provider.Oauth2UserInfo;
import com.spring.phoenix.repository.UserRepository;

@Service
public class Oauth2UserService extends DefaultOAuth2UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	public OAuth2User loadUser (OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		
		String userName = "";
		String providerId = "";
		
		Oauth2UserInfo oauth2UserInfo = null;
		
		if(userRequest.getClientRegistration().getRegistrationId().equals("kakao")) {
			oauth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
			providerId = oauth2UserInfo.getProviderId();
			userName = oauth2UserInfo.getName();
			
		}else {
			System.out.println("카카오 로그인만 지원합니다.");
		}
		//kakao
		String provider = oauth2UserInfo.getProvider();
		//kakao_123454235
		String userId = provider + "_" + providerId;
		String password = passwordEncoder.encode(oauth2UserInfo.getName());
		String email = oauth2UserInfo.getEmail();
		String role = "ROLE_USER";
		//사용자가 가입되어 있는지 검사할 Entity 객체 생성
		User user;
		
		if(userRepository.findById(userId).isPresent()) {
			//가입이 되어있으면 정보 담아줌
			user = userRepository.findById(userId).get();
		} else {
			//가입이 안되어있으면 null 리턴하여 가입 진행
			user = null;
		}
		
		//소셜 로그인 정보로 가입 진행
		if(user == null) {
			user = new User();
			user.setUserId(userId);
			user.setUserPw(password);
			user.setUserNm(oauth2UserInfo.getName());
			user.setUserEmail(email);
			user.setRole(role);
			
			//사용자 정보 DB에 저장
			userRepository.save(user);
		}
		
			//세션에 로그인 정보 저장
			return new CustomUserDetails(user, oAuth2User.getAttributes());
		}
				
	}
	
	

