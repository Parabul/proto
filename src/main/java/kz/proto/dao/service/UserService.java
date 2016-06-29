package kz.proto.dao.service;

import java.util.Arrays;

import kz.proto.dao.domain.entity.GlUser;
import kz.proto.dao.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {

	public static final String ADMIN_ROLES = "USER, ADMIN";
	public static final String CASHIER_ROLES = "USER, CASHIER";

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public GlUser findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public GlUser findByCashierId(Integer cashierId) {
		return userRepository.findByCashierId(cashierId);
	}

	public String getCashierDefaultPassword(String email) {
		return DigestUtils.md5DigestAsHex(email.getBytes()).substring(0, 6);
	}

	public GlUser create(String email, String password, String roles, Integer cashierId) {
		GlUser user = new GlUser();
		user.setEmail(email);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (password == null)
			password = getCashierDefaultPassword(email);
		logger.info("new user {1} with password {2}", email, password);
		user.setPassword(passwordEncoder.encode(password));
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setRoles(Arrays.asList(roles));
		user.setCashierId(cashierId);
		return userRepository.save(user);
	}
}
