package com.umanizales.list_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GradeAndRhDTO {
    private byte grade ;
    private String rh;
    private int count;
}
