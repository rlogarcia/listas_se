package com.umanizales.list_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase  creada para responder el error de un procedimiento en el postman
 *
 */
@Data
@AllArgsConstructor
public class ErrorDTO {
    private int code;
    private String messaje;
}
