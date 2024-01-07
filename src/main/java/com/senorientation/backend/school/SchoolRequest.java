package com.senorientation.backend.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolRequest {
    private String name;
    private String description;
    private SchoolDegree schoolDegree;
    private String address;
    private String lattitude;
    private String longitude;
}
