package jp.co.stylez.pth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String selectUserNameFromStaff (Integer accountId) {
		final String sql = "SELECT NAME FROM STAFF WHERE STAFF_ID = ?";
		return jdbcTemplate.queryForObject(sql, String.class, accountId);
	}
}