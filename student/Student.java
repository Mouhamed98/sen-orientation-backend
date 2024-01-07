package com.senorientation.backend.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "students")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String id;

    @DBRef
    private String userId;

    @DBRef
    private String schoolId;

    @DBRef
    private String formationId;

    private String examNumber;

    private Boolean isSucceededExam;

    private String examScholarYear;
}
