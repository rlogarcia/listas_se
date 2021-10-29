package com.umanizales.list_prog2.model.List_Se;

import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.Boy;
import lombok.Data;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
public class ListSE {
    private Node head;
    private int count;

    public boolean add(Boy boy) throws ListaSeException {
        Boy boyExist = findById(boy.getIdentification());

        if (boyExist != null) {
            throw new ListaSeException("La identificacion " + boyExist.getIdentification() + " ya existe");
        }
        if (head == null) {
            head = new Node(boy);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                if (boy.getIdentification().equals(temp.getData().getIdentification())) {
                    return false;
                }
                temp = temp.getNext();

            }
            temp.setNext(new Node(boy));
        }
        count++;
        return true;
    }

    public void addToStart(Boy boy) {
        if (this.head == null) {
            this.head = new Node(boy);

        } else {
            Node temp = new Node(boy);
            temp.setNext(this.head);
            this.head = temp;
        }
        count++;
    }

    public List<Boy> list() throws ListaSeException {
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

    public void invert() throws ListaSeException {
        if (this.head != null) {
            ListSE listTemp = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                listTemp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listTemp.head;

        }

    }

    public void deleteBoy(String id) throws ListaSeException {
        if (this.head != null) {
            if (this.head.getData().getIdentification().equals(id)) {
                this.head = this.head.getNext();
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
                } else {
                    throw new ListaSeException("La identificacion " + id + " No existe en la lista ");
                }
            }
        } else {
            throw new ListaSeException("No hay datos en la lsta");
        }
    }

    public int count() {
        int cont = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                cont++;
                temp = temp.getNext();
            }
        }
        return cont;
    }

    public void changeStartoEnd() throws ListaSeException {
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


    public void addNoRepeat(Boy boy) {
        if (head == null) {
            head = new Node(boy);
        } else {
            Node temp = head;
            if (!temp.equals(boy)) {
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(new Node(boy));
                count++;
            }
        }
    }

    public List<Boy> listTypeSex(String typeSex) {
        if (this.head != null) {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null) {
                if (typeSex.equals("f") || typeSex.equals("F")) {
                    list.add(temp.getData());
                    temp = temp.getNext();
                } else if (typeSex.equals("M") || typeSex.equals("m")) {
                    list.add(temp.getData());
                    temp = temp.getNext();
                }
                //
            }
            return list;
        }
        return null;
    }

    public void forGenderList(String typeSex){
        if (this.head != null) {
            Node temp = this.head;
            Boy boy = null;
            while (temp != null) {
                if (temp.getData().getTypeSex().equals(typeSex)) {
                    boy = new Boy(temp.getData().getIdentification(), temp.getData().getName(), temp.getData().getAge(), temp.getData().getTypeSex(),temp.getData().getLocation());
                    //deleteBoy(temp.getData().getIdentification());
                    addToStart(boy);
                }
                temp = temp.getNext();
            }
        }
    }

    public int countGender() {
        int count = 0;
        //int contBoy=0;
        int contGirl = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getTypeSex().equals("F")) {
                    contGirl++;
                    count = count + contGirl;

                }

                temp = temp.getNext();
            }
        }
        return count;

    }

    public int countGenderM() {
        int contBoy = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                if (temp.getData().getTypeSex().equals("M")) {
                    contBoy++;


                }

                temp = temp.getNext();
            }
        }
        return contBoy;

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

    public void valdateListeEmpty() throws ListaSeException {
        if (this.head == null) {
            throw new ListaSeException("No hay datos en la lista");
        }
    }

    public void addToPosition(Boy boy, int pos) throws ListaSeException {
        Boy boyExist = findById(boy.getIdentification());

        if (boyExist != null) {
            //this.add(boy);
            throw new ListaSeException("La identificacion " + boyExist.getIdentification() + " ya existe");
        }
        if (pos > count) {
            this.add(boy);
            return;
            //throw new ListaSeException("LA posicion ingresada no es valida");
        }
        if (pos == 1) {
            addToStart(boy);
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
            temp.setNext(newNode);
        }

    }

    public ListSE getListSeBoyFindGender(String gender) throws ListaSeException {
        valdateListeEmpty();
        Node temp = this.head;
        ListSE listTemp = new ListSE();
        while (temp != null) {
            if (temp.getData().getTypeSex().equals(gender)) {
                listTemp.add(temp.getData());
            }
            temp = temp.getNext();
        }
        return listTemp;

    }

    public void variantBoys() throws ListaSeException {
        valdateListeEmpty();
        ListSE kids = this.getListSeBoyFindGender("M");
        ListSE girl = this.getListSeBoyFindGender("F");
        ListSE minList = null;
        ListSE maxList = null;
        if (kids.getCount() > girl.count) {
            minList = girl;
            maxList = kids;
        } else {
            minList = kids;
            maxList = girl;
        }
        Node temp = minList.getHead();
        int pos=2;
        while(temp!=null){
            maxList.addToPosition(temp.getData(),pos);
            pos=pos+2;
            temp=temp.getNext();
        }
        this.head=maxList.getHead();
    }
    public int getCountByLocation(String code){


            Node temp= this.head;
            int count =0;
            while(temp!= null){
                if(temp.getData().getLocation().getCode().equals(code)){
                    count++;
                }
                temp=temp.getNext();

            }
            return count;

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<Boy> listForAgeAndMu(int age, String municipio) throws ListaSeException{
        valdateListeEmpty();
        Node temp = this.head;
        List<Boy> listAge = new ArrayList<>();
        while (temp!=null){
            if(temp.getData().getAge()==age && temp.getData().getLocation().equals(municipio)){
                listAge.add(temp.getData());

            }
            temp=temp.getNext();
        }

    return listAge;
    }




}


    /*
    public void confirmacion(){

       node temp=head;
       while(
     */

