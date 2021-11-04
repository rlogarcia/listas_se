package com.umanizales.list_prog2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
/**
 * en la clase locacion  tiene como principales caracteristicas la division por codigo y por descripcion del mismo
 */
public class Location {
    @NotNull
    @NotEmpty
    private String code;
    @NotNull
    @NotEmpty
    private String description;
}
