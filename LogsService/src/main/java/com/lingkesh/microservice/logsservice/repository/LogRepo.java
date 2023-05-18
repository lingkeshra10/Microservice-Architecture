package com.lingkesh.microservice.logsservice.repository;

import com.lingkesh.microservice.logsservice.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepo extends JpaRepository<Log, Long> {

    @Query("from Log l where l.log_user_id = :userId")
    List<Log> retrieveUserLog(@Param("userId") String userId);

}
