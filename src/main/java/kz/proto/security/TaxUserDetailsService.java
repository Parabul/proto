package kz.proto.security;

import java.util.ArrayList;
import java.util.List;

import kz.proto.dao.domain.entity.GlUser;
import kz.proto.dao.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("taxUserDetailsService")
public class TaxUserDetailsService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(TaxUserDetailsService.class);

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("loadUserByUsername: " + email);
		GlUser user = userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new User(user.getEmail(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(GlUser user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		return authorities;
	}

}
