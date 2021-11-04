package com.umanizales.list_prog2.model.List_Se;

import com.umanizales.list_prog2.model.Boy;
import lombok.Data;

@Data
/**
 * Clase de tipo nodo donde se tienen atributos de tipo niño y de topo nodo
 */
public class Node {
    private Boy data;
    private Node next;

    /**
     * se tiene un constructor con todos los datos y es de tipo datas
     * @param data
     */
    public Node(Boy data) {
        this.data = data;
    }
}
