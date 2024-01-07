package com.senorientation.backend.school;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("allSchools")
    public List<School> getMethodName(@RequestParam String param) {
        return schoolService.getAllSchools();
    }

    @PostMapping("new-school")
    public String CreateSchool(@RequestBody SchoolRequest schoolRequest) {
        return schoolService.createNewSchool(schoolRequest);
    }

    @PatchMapping("updated-school/:id")
    public String updateSchool(@RequestBody SchoolRequest schoolRequest, @RequestParam("id") String schoolId) {
        return schoolService.updateSchool(schoolId, schoolRequest);
    }
    
}
