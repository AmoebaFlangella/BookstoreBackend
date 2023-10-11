package com.bookstore.demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);
	List<AppUser> findByListUsername(String username);
}