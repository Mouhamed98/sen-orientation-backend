package com.senorientation.backend.formation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "formations")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formation {
    @Id
    private String id;

    private String label;

    private String description;

    private FormationType formationType;

    private Object outlets;
}
