package com.umanizales.list_prog2.model.List_De;

import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.Boy;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDe {
    private Node head;
    int count;

    public void addToStartDe(Boy boy) throws ListaSeException {
        Boy boyExist = findById(boy.getIdentification());
        if(boyExist != null)
        {
            throw new ListaSeException("La identificacion ya existe");
        }
        if(this.head==null)
        {
            this.head = new Node(boy);
        }
        else
        {
            Node temp = new Node(boy);
            temp.setNext(this.head);
            temp.setPrevius(null);
            this.head = temp;
        }
        count++;
    }
    public List<Boy> listDe() throws ListaSeException {
        if (this.head != null) {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null) {
                list.add(temp.getData());
                temp = temp.getNext();
            }
            return list;
        }
        throw new ListaSeException("No hay datos que mostrar");
        //return null;
    }
    public boolean add(Boy boy) throws ListaSeException {
        Boy boyExist = findById(boy.getIdentification());

        if (boyExist != null) {
            throw new ListaSeException("La identificacion " + boyExist.getIdentification() + " ya existe");
        }
        if (head == null) {
            head = new Node(boy);
        } else {
            Node temp = head;
            //Node temp
            while (temp.getNext() != null) {

                temp = temp.getNext();

            }
            temp.setNext(new Node(boy));
            temp.getNext().setPrevius(temp);
        }
        count++;
        return true;
    }
    public void deleteBoyDe(String id) throws ListaSeException {
        if (this.head != null) {
            if (this.head.getData().getIdentification().equals(id)) {
                this.head = this.head.getNext();
                this.head.setPrevius(null);
            } else {
                Node temp = this.head;
                while (temp != null) {
                    if (temp.getNext() != null && temp.getNext().getData().getIdentification().equals(id)) {
                        break;
                    }
                    temp = temp.getNext();
                }
                if (temp != null) {
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevius(temp);
                } else {
                    throw new ListaSeException("La identificacion " + id + " No existe en la lista ");
                }
            }
        } else {
            throw new ListaSeException("No hay datos en la lsta");
        }
    }
    public Boy findById(String id) {

        Node temp = this.head;
        while (temp != null) {
            if (temp.getData().getIdentification().equals(id)) {
                return temp.getData();
            }
            temp = temp.getNext();
        }
        return null;
    }
    public void changeStartoEndDe() throws ListaSeException {
        if (this.head != null && this.head.getNext() != null) {
            Boy start = this.head.getData();
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            this.head.setData(temp.getData());
            temp.setData(start);
        } else {
            throw new ListaSeException("no es posible ejecutar cambio de extremos");
        }
    }
    public void addToPositionDe(Boy boy, int pos) throws ListaSeException {
        Boy boyExist = findById(boy.getIdentification());

        if (boyExist != null) {
            //this.add(boy);
            throw new ListaSeException("La identificacion " + boyExist.getIdentification() + " ya existe");
        }
        if (pos > count) {
            //this.add(boy);
            //
            throw new ListaSeException("LA posicion ingresada no es valida");

        }
        if (pos == 1) {
            addToStartDe(boy);
        } else {
            int cont = 1;
            Node temp = this.head;
            while (temp != null) {
                if (cont == pos - 1) {
                    break;
                }
                temp = temp.getNext();
                cont++;
            }
            Node newNode = new Node(boy);
            newNode.setNext(temp.getNext());
            //previus agarra al next del
            temp.setNext(newNode);
        }
    }

    }
