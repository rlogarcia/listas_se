package com.umanizales.list_prog2.model.List_De;

import com.umanizales.list_prog2.model.Boy;
import lombok.Data;

@Data
public class Node {
    private Boy data;
    private Node next;
    private Node previus;

    public Node(Boy data) {
        this.data = data;
    }
}
