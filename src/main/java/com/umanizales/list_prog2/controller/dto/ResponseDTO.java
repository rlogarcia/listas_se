package com.umanizales.list_prog2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Clase creada para devolver un mensaje tras un posible error que presente al estar ingresando en la plataforma postman
 *
 */
@Data
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
    private List<ErrorDTO> errors;


}
