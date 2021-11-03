package com.umanizales.list_prog2.controller;

import com.umanizales.list_prog2.controller.dto.ErrorDTO;
import com.umanizales.list_prog2.controller.dto.ResponseDTO;
import com.umanizales.list_prog2.exception.ListaSeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * es un controlador para posibles errores y que estos sean capturados y cuando lo capture muestre uun mensaje
 */
@ControllerAdvice
public class ErrorHandlerController {
    /**
     * este metodo funciona como un capturador de erroreres que responde con un mensaje
     * @param ex el parametro  es viee de la lista de excepciones y toma su respectivo valor cuando es llamado
     * @return  un mensaje cuando es llamado
     */
    @ExceptionHandler(ListaSeException.class)
        protected ResponseEntity<?> handle(ListaSeException ex){
                List<ErrorDTO> listErrors =  new ArrayList<>();

                String message = ex.getMessage();
                ResponseDTO response = new ResponseDTO(message,null, null);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

    /**
     * metodo para validar los datos de un boy y que este tambien responde cuando no se cumplen con las validaciones
     * @param ex el parametro ex viene de la lista de excepciones y toma su respectivo valor cuando es llamad
     * @return un mensaje cuando es llamado
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handle(MethodArgumentNotValidException ex){
        List<ErrorDTO> listErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            listErrors.add(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), fieldName +" "+ errorMessage));
        });
        String message = "Algunos campos son inválidos o faltantes, por favor corrija los errores y vuelva a intentarlo";
        ResponseDTO response = new ResponseDTO( message,null , listErrors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
