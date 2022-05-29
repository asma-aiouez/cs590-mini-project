package com.cs590.miniproject.repository;

import com.cs590.miniproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long > {

    User findByUsername(String username);
}
