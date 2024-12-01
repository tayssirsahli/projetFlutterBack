package com.tayssir.cosmetique.repos;

import com.tayssir.cosmetique.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email,String password);

	
}
