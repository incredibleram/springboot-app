package com.inm429.ecommerce.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.inm429.ecommerce.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	List<User> findAll();
	User findByEmail(String emailId);
}
