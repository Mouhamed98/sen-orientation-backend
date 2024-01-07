package com.senorientation.backend.degree;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DegreeRepository extends MongoRepository<Degree, String> {

}
