package jp.co.stylez.pth.web.service;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	
	public String emailToUserName (final String email) {
		final String[] userName = email.split("@");
		return userName[0];
	}
}