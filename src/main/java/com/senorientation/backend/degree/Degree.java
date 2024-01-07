package com.senorientation.backend.degree;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "degrees")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Degree {
    @Id
    private String id;

    private String label;

    private String description;
}
