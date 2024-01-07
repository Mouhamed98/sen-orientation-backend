package com.senorientation.backend.school;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolRepository extends MongoRepository<School, String> {
    List<School> findByIsActive(boolean isActive);
    Optional<School> findByName(String name);
}
