package com.example.reactProject.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.reactProject.dao.UserDao;
import com.example.reactProject.entity.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserDao userDao;
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

}
