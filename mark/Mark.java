package com.senorientation.backend.mark;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "marks")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mark {
    @Id
    private String id;

    @DBRef
    private String subjectId;

    @DBRef
    private String studentId;

    private Float mark;

    @DBRef
    private String deegreeId;

}
