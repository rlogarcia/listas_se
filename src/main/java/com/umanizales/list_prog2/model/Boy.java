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
/**
 * la clase boy nos mestra los atributos que tienen el niño
 * y las validaciones que se hace { que no puede ser vacio, positivo, etc}
 */
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
    private Gender typeSex;
    @Valid
    @NotNull
    private Location location;
    @NotNull
    @Positive
    //@Size(min=1,max=5)
    private byte grade;
    @NotNull
    private boolean orphan;
    @NotNull
    @NotEmpty
    private String rh;
}
