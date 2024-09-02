package com.lingkesh.microservice.userservice.repository;

import com.lingkesh.microservice.userservice.entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class UserListSpecification {

    public static Specification<User> hasUsername(String username) {
        return (root, query, criteriaBuilder) -> {
            if (username == null || username.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("username"), username);
        };
    }

    public static Specification<User> hasUniqueId(String uniqueId) {
        return (root, query, criteriaBuilder) -> {
            if (uniqueId == null || uniqueId.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("unique_id"), uniqueId);
        };
    }

    public static Specification<User> hasApplicationId(String applicationId) {
        return (root, query, criteriaBuilder) -> {
            if (applicationId == null || applicationId.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("application_id"), applicationId);
        };
    }

    public static Specification<User> hasUserEmail(String userEmail) {
        return (root, query, criteriaBuilder) -> {
            if (userEmail == null || userEmail.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("email"), userEmail);
        };
    }

    public static Specification<User> hasUserPhoneNumber(String userPhoneNo) {
        return (root, query, criteriaBuilder) -> {
            if (userPhoneNo == null || userPhoneNo.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("user_phone_number"), userPhoneNo);
        };
    }

    public static Specification<User> hasStatus(Integer status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null || status == 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<User> createdDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return (root, query, criteriaBuilder) -> {
            if (startDate == null && endDate == null) {
                return criteriaBuilder.conjunction();
            } else if (startDate == null) {
                long endMillis = endDate.toInstant(ZoneOffset.UTC).toEpochMilli();
                return criteriaBuilder.lessThanOrEqualTo(root.get("created_date"), endMillis);
            } else if (endDate == null) {
                long startMillis = startDate.toInstant(ZoneOffset.UTC).toEpochMilli();
                return criteriaBuilder.greaterThanOrEqualTo(root.get("created_date"), startMillis);
            } else {
                long startMillis = startDate.toInstant(ZoneOffset.UTC).toEpochMilli();
                long endMillis = endDate.toInstant(ZoneOffset.UTC).toEpochMilli();
                return criteriaBuilder.between(root.get("created_date"), startMillis, endMillis);
            }
        };
    }
}
