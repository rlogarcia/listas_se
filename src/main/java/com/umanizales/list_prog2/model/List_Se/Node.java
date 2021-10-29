package com.umanizales.list_prog2.model.List_Se;

import com.umanizales.list_prog2.model.Boy;
import lombok.Data;

@Data

public class Node {
    private Boy data;
    private Node next;

    public Node(Boy data) {
        this.data = data;
    }
}
