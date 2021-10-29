package com.umanizales.list_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Boy {
    @NotNull
    @NotEmpty
    @Size(min=2)
    private String identification;
    @NotNull
    @NotEmpty
    @Size(min=2, max = 50)
    private String name;
    @Positive
    private byte age;
    @NotNull
    private String typeSex;
    @Valid
    @NotNull
    private Location location;
}
