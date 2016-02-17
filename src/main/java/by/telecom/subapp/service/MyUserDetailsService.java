package by.telecom.subapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

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
public class MyUserDetailsService  implements UserDetailsService  {

	@Autowired
	private UserDao userDao;
	

	public UserDetails loadUserByUsername(final String username) 
               throws UsernameNotFoundException {

		by.telecom.subapp.model.User domainUser = userDao.getByLogin(username);

		boolean enabled = true;
	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = true;

	    return new User(
	            domainUser.getLogin(), 
	            domainUser.getPassword(), 
	            enabled, 
	            accountNonExpired, 
	            credentialsNonExpired, 
	            accountNonLocked,
	            getAuthorities(0)
	    );
		

	}

//	// Converts com.mkyong.users.model.User user to
//	// org.springframework.security.core.userdetails.User
//	private User buildUserForAuthentication(by.telecom.subapp.model.User user, 
//		List<GrantedAuthority> authorities) {
//		return new User(user.getLogin(), 
//			user.getPassword(), true, 
//                        true, true, true, authorities);
//	}
//
//	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
//
//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//		// Build user's authorities
//		for (UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//		}
//
//		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//		return Result;
//	}
	
	
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }
	
	public List<String> getRoles(Integer role) {
		 
        List<String> roles = new ArrayList<String>();
 
        roles.add("ROLE_USER");
        
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
