package com.senorientation.backend.classroom;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "classrooms")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    private String id;

    private String label;

    @DBRef
    private String schoolId;

    private Integer registeredSudents;

    private Integer maxStudents;

}
