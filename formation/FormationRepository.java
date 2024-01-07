package com.senorientation.backend.formation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormationRepository extends MongoRepository<Formation, String> {

}
