package com.umanizales.list_prog2.controller.dto;

import com.umanizales.list_prog2.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class GenderByLocationDTO {
    private Location location;
    private List<GradeByGenderDTO> gradeByGenderDTOS;
    private int all;
}
