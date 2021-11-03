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
    /**
     * metodo que me adicciona a un niño al principio de la lista
     * @param boy el parametro es un niño con su respectiva data
     */
    public void addToStartDe(Boy boy) throws ListaSeException {
        // se crea un dato para buscar la identificacion del niño
        Boy boyExist = findById(boy.getIdentification());
        // se pregunta si la identificacion es diferente de vacio
        if(boyExist != null)
        {
            // si ingresa hasta aqui es porque la identificacion es igual a otra que ya hay en la lista
            throw new ListaSeException("La identificacion ya existe");
        }
        // se pregunta si la cabeza esta vacia
        if(this.head==null)
        {
            // si ingresa aqui es porque es el primer dato
            // se agrega el nuevo niño en la cabeza
            this.head = new Node(boy);
        }
        else
        {
            /**
             * se crea  un ayudante que se pare en la cabeza
             * se le dice al brazo next del ayudante que agarre la cabeza
             * y le decimo al brazo del previus ayudante que agarre al vacio
             */
            Node temp = new Node(boy);
            temp.setNext(this.head);
            temp.setPrevius(null);
            this.head = temp;
        }
        // se aumenta el contador
        count++;
    }
    /**
     * metodo que me lista los niños que hay agregados en el metodo
     * @return se retona una lista de niños
     * @throws ListaSeException lanza una excepcion si la lista esta vacia
     */
    public List<Boy> listDe() throws ListaSeException {
        /**
         * se verifica si hay datos en el sistema
         * se crea un ayudante que se pare en la cabeza y nos ayude a recorrer el metodo
         * se crea una lista
         * se recorre el ciclo hasta llegar al ultimo nodo
         */
        if (this.head != null) {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null) {
                /**
                 * a cada paso que va dando agrega los datos del niño a la lista
                 * se le da el paso al siguiente niño
                 */
                list.add(temp.getData());
                temp = temp.getNext();
            }
            // se retorna la lista
            return list;
        }
        // se lanza una excepcion  porque no hay datos en la lista
        throw new ListaSeException("No hay datos que mostrar");
        //return null;
    }
    public boolean add(Boy boy) throws ListaSeException {
        /**
         * Se invoca el método encontrar por identificación, para verificar si
         * el niño que está ingresando ya existe
         */
        Boy boyExist = findById(boy.getIdentification());

        if (boyExist != null) {
            /**
             * Si el niño ya existe se lanza la excepeción para comunicar al usuario en el controller
             */
            throw new ListaSeException("La identificacion " + boyExist.getIdentification() + " ya existe");
        }
        /**
         * se pregunta si la cabeza esta vacia
         * si cumple la condicion se agrega al niño
         */
        if (head == null) {
            head = new Node(boy);
        } else {
            /**
             * si no se cumple la condicion anterior
             * se crea un ayudante que nos ayude a recorrer la lista
             * se recorre la lista hasta estar parado een el ultimo niño
             */
            Node temp = head;
            while (temp.getNext() != null) {

                // se de la paso al siguiente nodo
                temp = temp.getNext();

            }
            // aqui ya esta parado en el ultimo niño
            // se le dice que en su brazo next agarre al ultimo nodo
            temp.setNext(new Node(boy));
            // se le dice al brazo del sigueinte que agarre al anterior
            temp.getNext().setPrevius(temp);
        }
        // se aumenta el contador
        count++;
        return true;
    }
    /**
     * metodo que me permite eliminar un dato de los nodos
     * @param id el parametro que se le envia es una identificacion
     * @throws ListaSeException
     */
    public void deleteBoyDe(String id) throws ListaSeException {
        // se preguntan si hay datos en la cabeza
        if (this.head != null) {
            /**
             * se pregunta si la identificacion de el dato que esta en la cabeza es el que vamos a eliminar
             * si lo es le declaramos que la cabeza va a ser el dato que este tenia agarrado
             */
            if (this.head.getData().getIdentification().equals(id)) {
                this.head = this.head.getNext();
                this.head.setPrevius(null);
            } else {
                /**
                 * se crea un ayudante que se pare en la cabeza  y me ayude a recorrer el listado
                 * se recorre el listado hasta que este llegue al utlimo
                 */
                Node temp = this.head;
                while (temp != null) {
                    /**
                     * se pregunta si el dato que se ingreso es igual al dato que tiene el ayudante en su momenti
                     * si si es hace un break y para todo porque encontramos el dato a eliminar
                     */
                    if (temp.getNext() != null && temp.getNext().getData().getIdentification().equals(id)) {
                        break;
                    }
                    // se le da el paso al siguiente dato
                    temp = temp.getNext();
                }
                /**
                 * se pregunta si el dato es el ultimo
                 * si si es se le dice que el brazo es el siguiente del siguiente
                 */
                if (temp != null) {
                    temp.getNext().setPrevius(temp);
                    //temp.setNext(temp.getNext().getNext());
                } else {
                    // se dalnza una excepcion si el dato de la identiciacion no existe
                    throw new ListaSeException("La identificacion " + id + " No existe en la lista ");
                }
            }
        } else {
            // se lanzaa una excepcion si no hay datos en la lista
            throw new ListaSeException("No hay datos en la lsta");
        }
    }
    /**
     * Método que me busca en la lista simplemente enlazada, un niño a partir de la identificación
     * Si no encuentra el niño retorna vacío (null)
     * @param id Cédula, TI, CE , Sisben que identifica el niño que voy a buscar
     * @return El niño que encontré con todos sus datos
     */
    public Boy findById(String id) {
        /**
         * Cómo no me puedo mover de la cabeza por que s eme vuelan todos los niños,
         * LLamo a un ayudante y lo ubico en la cabeza o inicio
         */
        Node temp = this.head;
        /**
         * Creo un ccilo para recorrer la lista SE de principio a fin
         * llego al final cuando mi ayudante queda para en vacío (null)
         */
        while (temp != null) {
            /**
             * Pregunto si el niño en el cual está ubicado mi ayudante es el de la identificación
             * que estoy buscando ingresado en el parámetro identificacion
             */
            if (temp.getData().getIdentification().equals(id)) {
                /**
                 * Lo encontré y lo retorno de inmediato
                 * Finaliza mi método
                 */
                return temp.getData();
                /**
                 * Mi ayudante se pasa al siguiente nodo
                 */
            }
            temp = temp.getNext();

        }

        /**
         * Si llega a esta línea significa que no encontré el niño y retorno vacío
         */
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
            if(newNode.getNext()!=null){
                newNode.getNext().setPrevius(newNode);

            }
            newNode.setPrevius(temp);
            temp.setNext(newNode);
        }
    }

    }
