package com.umanizales.list_prog2.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoysByGender {
    private Gender typeSex;
    private int count;
}
