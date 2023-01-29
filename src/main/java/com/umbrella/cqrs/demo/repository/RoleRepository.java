package com.umbrella.cqrs.demo.repository;

import com.umbrella.cqrs.demo.models.ERole;
import com.umbrella.cqrs.demo.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
