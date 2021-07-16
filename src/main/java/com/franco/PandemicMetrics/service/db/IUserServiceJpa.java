package com.franco.PandemicMetrics.service.db;

import java.util.List;

import com.franco.PandemicMetrics.model.User;

public interface IUserServiceJpa {
	
	List<User> getAll() throws Exception;
	void insert(User user) throws Exception;
	void update(User user) throws Exception;
	void delete(Integer id) throws Exception;
	
}
