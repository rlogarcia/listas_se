package com.umanizales.list_prog2.exception;

public class ListaSeException extends Exception {
    /**
     * metodo que me captura un mensaje
     * @param message recibe el mensaje cuando el metodo sea llamado
     */
    public ListaSeException(String message) {
        super(message);
    }
}
