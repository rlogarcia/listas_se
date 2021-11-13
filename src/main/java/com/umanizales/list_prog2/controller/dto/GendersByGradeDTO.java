package com.umanizales.list_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class GendersByGradeDTO {
    private byte grade;
    private List<CountGenderDTO>  countgender;
    private int All;
}
