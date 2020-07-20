package com.appsdeveloperblog.app.ws.service.impl;

import java.util.ArrayList;

import com.appsdeveloperblog.app.ws.io.value.UserAddress;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.io.repository.UserRepository;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto getUserById(String email) {
		UserDto returnValue = new UserDto();

		UserEntity userEntity = userRepository.findByEmail(email);
		BeanUtils.copyProperties(userEntity, returnValue);

		return returnValue;
	}

	@Override
	public UserDto createUser(UserDto user) {

		if (userRepository.findByEmail(user.getEmail()) != null)
			throw new RuntimeException("Record Already Exists!");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);

		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		UserAddress userAddress = new UserAddress();
		userAddress.setStreet("07 street");
		userAddress.setCity("Delhi");
		userAddress.setState("New Delhi");
		userAddress.setPinCode("110096");
		userAddress.setCountry("India");

		UserAddress userAddress1 = new UserAddress();
		userAddress1.setStreet("07 street");
		userAddress1.setCity("Delhi");
		userAddress1.setState("New Delhi");
		userAddress1.setPinCode("110096");
		userAddress1.setCountry("India");

		userEntity.getUserAddressSet().add(userAddress);
		userEntity.getUserAddressSet().add(userAddress1);

		//userEntity.setUserAddress(userAddress);
		UserEntity storedUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);

		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}

}
