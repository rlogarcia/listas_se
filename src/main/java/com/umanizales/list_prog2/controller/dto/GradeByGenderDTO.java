package com.umanizales.list_prog2.controller.dto;

import com.umanizales.list_prog2.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GradeByGenderDTO {
    private Gender gender;
    private GradeAndRhDTO [] gradeAndRhDTOS;
}
