package com.senorientation.backend.school;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.senorientation.backend.formation.Formation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "schools")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    private String id;

    private String name;

    private String description;

    private SchoolDegree schoolDegree;

    @DBRef
    private Collection<Formation> formations;

    private String address;

    private String lattitude;

    private String longitude;

    private String logo;

    private List<String> images;

    private Boolean isActive;
}
