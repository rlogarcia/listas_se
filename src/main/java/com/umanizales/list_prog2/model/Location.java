package com.umanizales.list_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Location {
    @NotNull
    @NotEmpty
    private String code;
    @NotNull
    @NotEmpty
    private String description;
}
