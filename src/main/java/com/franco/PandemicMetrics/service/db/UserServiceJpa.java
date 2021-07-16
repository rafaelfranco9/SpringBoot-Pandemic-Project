package com.franco.PandemicMetrics.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.franco.PandemicMetrics.model.User;
import com.franco.PandemicMetrics.repository.UserRepository;

public class UserServiceJpa implements IUserServiceJpa {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAll() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public void insert(User user) throws Exception {
		userRepository.save(user);
	}

	@Override
	public void update(User user) throws Exception {
		
		if(user.getId() != null) throw new Exception("El ID es nulo");
		
		if(userRepository.existsById(user.getId())) {
			userRepository.save(user);
		}else {
			throw new Exception("El ID no existe");
		}
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}else {
			throw new Exception("El ID no existe");
		}
		
	}

}
