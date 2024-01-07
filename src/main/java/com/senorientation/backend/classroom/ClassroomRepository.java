package com.senorientation.backend.classroom;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassroomRepository extends MongoRepository<Classroom, String> {

}
