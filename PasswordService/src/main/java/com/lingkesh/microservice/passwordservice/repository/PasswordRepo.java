package com.lingkesh.microservice.passwordservice.repository;

import com.lingkesh.microservice.passwordservice.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordRepo extends JpaRepository<Password, Long> {

    @Query("from Password p where p.password_user_id = :userId")
    List<Password> retrieveUserPassword(@Param("userId") String userId);

}
