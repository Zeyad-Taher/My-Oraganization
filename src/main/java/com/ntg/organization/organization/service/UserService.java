package com.ntg.organization.organization.service;

import java.util.ArrayList;
import java.util.List;

import com.ntg.organization.organization.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ntg.organization.organization.entity.User;
import com.ntg.organization.organization.respository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUserName(username);

		if (user == null)
			throw new UsernameNotFoundException("User " + username + " Not found");

		return new org.springframework.security.core.userdetails.User(user.getUserName(), 
				user.getPassword(),
				mapToGrantedAuthorities());

	}

	private static List<GrantedAuthority> mapToGrantedAuthorities() {
		List<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		return grantedAuthoritiesList;

	}
	
	public UserDTO createNewUser(UserDTO userDto) {
		if(userDto != null) {
			User user=new User();
			BeanUtils.copyProperties(userDto, user);
			user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
			user=userRepository.save(user);
			BeanUtils.copyProperties(user,userDto);
			//userDto.setPassword(null);
			return userDto;
		}
		
		return null;
	}
}
