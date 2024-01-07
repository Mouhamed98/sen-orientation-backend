package com.senorientation.backend.region;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "regions")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    private String name;

    private String lattitude;

    private String longitude;
}
