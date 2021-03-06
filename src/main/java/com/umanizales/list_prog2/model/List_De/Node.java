package com.umanizales.list_prog2.model.List_De;

import com.umanizales.list_prog2.model.Boy;
import lombok.Data;

@Data
        /** Clase de tipo nodo donde se tienen atributos de tipo niño y de topo nodo
        */
public class Node {
    private Boy data;
    private Node next;
    private Node previus;
    /**
     * se tiene un constructor con todos los datos y es de tipo data
     * @param data
     */
    public Node(Boy data) {
        this.data = data;
    }
}
