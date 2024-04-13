package com.careersforyou.jobservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Job (
        @NotBlank(message = "The jobid must be defined.")
        @Pattern(
                regexp = "^([0-9]?\\d$)$",
                message = "The jobid format must be valid."
        )
        String jobid,
        @NotBlank(message = "The job title must be defined.")
        String title,
        @NotBlank(message = "The job description must be defined.")
        String description,
        @NotBlank(message = "The company name must be defined.")
        String companyname,
        @NotBlank(message = "Skill 1 must be defined")
        String skill1,
        @NotBlank(message = "Skill 2 must be defined")
        String skill2
){
}