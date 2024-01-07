package com.senorientation.backend.school;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.senorientation.backend.exception.ApiRequestException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public boolean checkDuplicatedSchool(String name) {
        var school = schoolRepository.findByName(name);
        return school.isPresent();
    }

    public String createNewSchool(SchoolRequest schoolRequest) {
        boolean schoolExist = checkDuplicatedSchool(schoolRequest.getName());
        if (schoolExist) throw new ApiRequestException("School already exists");
        School.builder()
            .name(schoolRequest.getName())
            .description(schoolRequest.getDescription())
            .address(schoolRequest.getAddress())
            .lattitude(schoolRequest.getLattitude())
            .longitude(schoolRequest.getLongitude())
            .schoolDegree(schoolRequest.getSchoolDegree());
        return "School created successfully";
    }
    
    public Optional<School> findSchoolById(String id) {
        var school = schoolRepository.findById(id);
        if (!school.isPresent()) throw new ApiRequestException("School not found");
        return school;
    }

    public String updateSchool(String id, SchoolRequest schoolRequest) {
        findSchoolById(id);
        School.builder()
            .name(schoolRequest.getName())
            .description(schoolRequest.getDescription())
            .address(schoolRequest.getAddress())
            .lattitude(schoolRequest.getLattitude())
            .longitude(schoolRequest.getLongitude())
            .schoolDegree(schoolRequest.getSchoolDegree());
        return id;
    }
}
