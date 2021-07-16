package com.franco.PandemicMetrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franco.PandemicMetrics.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
