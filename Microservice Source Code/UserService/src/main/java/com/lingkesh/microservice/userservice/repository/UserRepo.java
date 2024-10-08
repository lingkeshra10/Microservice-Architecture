package com.lingkesh.microservice.userservice.repository;

import com.lingkesh.microservice.userservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("from User u where u.username = :username")
    User retrieveByUsername(@Param("username") String username);

    @Query("select count(u)>0 from User u where u.username = :username")
    boolean findExistByUsername(@Param("username") String username);

    @Query("select count(u)>0 from User u where u.email = :email")
    boolean findExistByEmail(@Param("email") String email);

    Page<User> findAll(Specification<User> spec, Pageable pageable);
}
