package com.umanizales.list_prog2.controller.dto;

import com.umanizales.list_prog2.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountGenderDTO {
    private Gender gender;
    private int Count;
}
