package com.rit.enrollment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{

 @Query("select u from User u where username = ?1")
 User findUserRoles(String username);
}
