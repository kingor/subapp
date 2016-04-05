package by.telecom.subapp.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.telecom.subapp.dao.UserDao;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	private static final Logger logger = Logger.getLogger(MyUserDetailsService.class);

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		logger.info("SERVICE - Try to login with username = " + username);
		by.telecom.subapp.model.User domainUser = userDao.getByLogin(username);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(domainUser.getLogin(), domainUser.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(domainUser.getCategory()));

	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 2) {
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 1) {
			roles.add("ROLE_OPERATOR");
		} else if (role.intValue() == 0) {
			roles.add("ROLE_USER");
		}

		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
