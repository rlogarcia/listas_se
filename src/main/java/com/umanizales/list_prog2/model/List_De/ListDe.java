package com.umanizales.list_prog2.model.List_De;

import com.umanizales.list_prog2.controller.dto.*;
import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.Boy;

import com.umanizales.list_prog2.model.Gender;
import com.umanizales.list_prog2.model.List_Se.ListSE;
import com.umanizales.list_prog2.model.Location;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
/**
 * Clase que me permite gestionar una lista Doblemente  enlazada
 * contiene los métodos u operaciones ....
 * solo cuenta con los atributo head = que representa el primer niño
 * ...
 */
public class ListDe {
    /**
     * Atributo que representa el inicio de la lista se
     */
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

    /**
     * metodo que me cambia de lugares los dos extremos de la lista
     * @throws ListaSeException
     */
    public void changeStartoEndDe() throws ListaSeException {
        /**
         * se pregunta si hay datos en la cabeza y si solo hay un dato en la lista
         * se crea un ayudante que me almcaene los datos de la cabeza
         * se crea un ayudante que se pare en la cabeza y ma yudae a recorres la lista
         * se recorre la lista hasta el ultimo dato
         */
        if (this.head != null && this.head.getNext() != null) {
            Boy start = this.head.getData();
            Node temp = head;
            while (temp.getNext() != null) {
                // se da paso al siguiente dato
                temp = temp.getNext();
            }
            // se le dice que el ultimo dato va a tener la data del ultimo dato
            // y el ultimo dato se le manda la informacion del ayudante que tenia la infromacion de la cabeza
            this.head.setData(temp.getData());
            temp.setData(start);
        } else {
            // se arroja una excepcion porque no se puede ejecutar los cambios
            throw new ListaSeException("no es posible ejecutar cambio de extremos");
        }
    }
    /**
     * metodo que me permite agregar un niño por porsicion
     * @param boy el parametro de niño pide cada uno de lo dtaos del niño y la valida
     * @param pos la posicion a la que se desea ingresar el niño
     * @throws ListaSeException
     */
    public void addToPositionDe(Boy boy, int pos) throws ListaSeException {
        // se almacena el niño en una variable y se llama el metodo de encontrar por id
        Boy boyExist = findById(boy.getIdentification());
        // se pregunta si el niño ya existe
        if (boyExist != null) {
            //this.add(boy);
            // si ingresa aqui es porque el niño esta repetido
            throw new ListaSeException("La identificacion " + boyExist.getIdentification() + " ya existe");
        }
        /**
         * se pregunta si la validacion es mayor a la cantidad de niño
         * si ingresa a este es porque la posicion es valida
         * y se procede a agregar el niño
         */
        if (pos > count) {
            this.add(boy);
            return;
            //throw new ListaSeException("LA posicion ingresada no es valida");
        }
        /**
         * se pregunta a la que quieren ingresar al niño es la primer
         * y se llama el metodo que lo agrega al principio
         */
        if (pos == 1) {
            addToStartDe(boy);
        } else {
            /**
             *se crea un contador que inicializa en 1
             * se crea un ayudante que se pare en la cabeza y nos ayude a recorrer todo el listado
             * se empieza a recorrer todo el ciclo hasta llegar al ultimo
             */
            int cont = 1;
            Node temp = this.head;
            while (temp != null) {
                // se pregunta si el contador es igual a la posicion menos 1
                if (cont == pos - 1) {
                    // se hace un alto
                    break;
                }
                //se le da paso al siguiente nodo
                temp = temp.getNext();
                // se aumenta el contador
                cont++;
            }
            /**
             * se crea un nuevo nodo para agregar al niño
             * se le dice al brazo que agarre al anteror del ultimo
             * se le dice al brazo del ultimo que agarre al nuevo
             */
            Node newNode = new Node(boy);
            //newNode.setNext(temp.getNext());
            newNode.setPrevius(temp);
            temp.setNext(newNode);
        }

    }
    /**
     * metodo que me permite invertir la lista simplemente enlazada
     * @throws ListaSeException
     */
    public void invertDe() throws ListaSeException {
        /**
         * se pregunta si la lista esta vacia
         * se crea una lista temporal
         * se crea un ayudante que se pare en la cabeza
         * se recorre la lista hasta el ultimo
         */
        if (this.head != null) {
            ListDe listTemp = new ListDe();
            Node temp = this.head;
            while (temp != null) {
                /**
                 * a cada paso se agrega el dato al comienzo de la lista temporal
                 * se le da el paso a cada una de los nodos
                 */
                listTemp.addToStartDe(temp.getData());
                temp = temp.getNext();
            }
            // le decimos que la nueva cabeza va a ser la cabeza de la lista temporal
            this.head = listTemp.head;

        }

    }
    /**
     * metodo que me cuente los niños que hay existentes
     * @return se retorna la cantidad de niños que hay
     */
    public int countDe() {
        /**
         * se crea un numero que empiece desde cero
         * se pregunta si hay datos en el listado
         * se crea un ayudante que se pare en la cabeza y nos ayude a recorres el listado
         * se recorre el listado hasta el final
         */
        int cont = 0;
        if (this.head != null) {
            Node temp = this.head;
            while (temp != null) {
                // se aumenta el contador y se le da paso al siguiente paso
                cont++;
                temp = temp.getNext();
            }
        }
        // se retorna el contador
        return cont;
    }

    /**
     * metodo que retorna una lista que permite encontrar una lista por el genero
     * @param gender el parametro es el genero del niño que se desea ingresa
     * @return se retorna una lista
     * @throws ListaSeException
     */
    public ListDe getListDeBoyFindGender(String gender) throws ListaSeException {
        // se validan si hay datos
        valdateListeEmptyDe();
        /**
         * se crea un ayudante para recorrer todo el listado
         * se crea una lista temporal para agregar los niños de este genero
         * se comienza a recorrer todo el listado hasta llegar al ultmo
         */
        Node temp = this.head;
        ListDe listTemp = new ListDe();
        while (temp != null) {
            // se pregunta si el genero del dato actual es igual al ingresado
            if (temp.getData().getTypeSex().equals(gender)) {
                // si ingresa aqui es por que cumple los requisitos y se agrega a la nueva lista
                listTemp.add(temp.getData());
            }
            // se da paso al siguiente termino
            temp = temp.getNext();
        }
        // se devuelve la lista
        return listTemp;

    }
    public void valdateListeEmptyDe() throws ListaSeException {
        //se pregunta si la lista esta vacia
        if (this.head == null) {
            /**
             * se ingresa aqui es porque la lista esta vacia
             * y arroja esta excepcion
             */
            throw new ListaSeException("No hay datos en la lista");
        }
    }
    public int getCountByLocationDe(String code){

        /**
         * se crea un ayudante que me ayude a recorrer la lista
         * se crea un contador que empiece en cero
         * se recorre el ciclo hasta el ultimo
         */
        Node temp= this.head;
        int count =0;
        while(temp!= null){
            // se pregunta si la locacion es igual al codigo
            if(temp.getData().getLocation().getCode().equals(code)){
                // se aumenta el contador
                count++;
            }
            // se da paso al siguiente nodo
            temp=temp.getNext();

        }
        // se retorna el contador
        return count;

    }
    public void variantBoysDe() throws ListaSeException {
        //se valida si hay datos en la lista
        valdateListeEmptyDe();
        /**
         * se crea una lista temporal para agregar los niños
         * se crea una lista temporal para agregar las niñas
         * se inicializa una variable de tipon lista vacia
         * se inicializa una variable de femenino de tipo lista
         */
        ListDe kids = this.getListDeBoyFindGender("M");
        ListDe girl = this.getListDeBoyFindGender("F");
        ListDe minList = null;
        ListDe maxList = null;
        // se pregunta si el contador de niños es mayor al contador de niñas
        if (kids.getCount() > girl.count) {
            // se dice que la lista maxima es de los niños
            // la lista minima es de las niñas
            minList = girl;
            maxList = kids;
        } else {
            // se dice que la lista maxima es de las niñas
            // las lista minima es de los niños
            minList = kids;
            maxList = girl;
        }

    }
    /**
     *metodo que me permite listar los niños por edad y por municipio ingresad
     * @param age
     * @param municipio
     * @throws ListaSeException
     */
    public void listForAgeAndMuDe(int age, String municipio) throws ListaSeException{
        // List<Boy>
        // se valida si hay datos en el sistema
        valdateListeEmptyDe();
        // se pregunta si la cabeza esta vacia
        if(this.head!= null){
            // se crea una lista temporal donde se van a ingresar los niños
            ListDe listAge= new ListDe();
            // se crea un ayudante que se pare en la cabeza y nos ayude a recorrer la lista
            Node temp = this.head;
            //List<Boy> listAge =
            // se recorre toda la lista hasta llegar al ultimo
            while (temp!=null){
                /**
                 * se pregunta si la edad del niño actual tiene una edad menor o ifual a la edad ingresada
                 * y se pregunta si la locacion ingresada es ifual a la del niño actual
                 */
                if(temp.getData().getAge()<=age && temp.getData().getLocation().getDescription().equals(municipio)){
                    // si cumple con los requisitos se adiciona a la lista
                    listAge.addToStartDe(temp.getData());
                }
                // se le da paso al siguiente niño
                temp=temp.getNext();
            }
            // se asigna la nueva lista como la cabeza
            this.head=listAge.getHead();

        }
        //this.head=listAge.g
        //return listAge;
    }

    /**
     * metodo que me lista por edad y por genero, segun la edad ingresada y genero ingresado
     * @param age
     * @param gender
     * @throws ListaSeException
     */
    public void listForAgeAndGenderDe(int age, String gender) throws ListaSeException
    {
        // se valida si hay datos en la lista
        valdateListeEmptyDe();
        // si  hay datos en la cabeza
        if (this.head != null) {
            // se crea una lista temporal
            ListDe listTemp = new ListDe();
            // se crea un ayudante que me ayude a recorrer la lista
            Node temp = this.head;
            // se recorre la lista hasta encontrar el ultimod dato
            while(temp != null)
            {
                // se pregunta si la edad ed menor a la edad ingresada y  a su vez que el genero coincida con el de la lista
                if(temp.getData().getAge()<=age && temp.getData().getTypeSex().equals(gender)){
                    // si cumple las condiciones anteriores  se agrega a la lista
                    listTemp.addToStartDe(temp.getData());
                }
                // si no se cumple lo anterior
                else {
                    // se adiciona al final de la lista
                    listTemp.add(temp.getData());
                }
                // se le da paso al siguiente nodo
                temp = temp.getNext();
            }
            // se le asigna como nueva cabeza a la cabeza de  la lista nueva
            this.head = listTemp.getHead();
        }
    }

    /**
     * metodo que me permite eliminar de la lista a quienes cumplan la edad
     * @param age
     * @throws ListaSeException
     */
    public void deleteForAgeDe(byte age) throws ListaSeException{
        // se valida si hay datos en la lista
        valdateListeEmptyDe();
        // se crea un ayudante que se pare en la cabeza y me ayude a recorrer la lista
        Node temp = this.head;
        // se recorre el ciclo hasta llegar al ultimo
        while(temp!=null){
            // se pregunta si el dato actual tiene edad inferior a la edad ingresada
            if(temp.getData().getAge()>age){
                // si ingresa aqui es porque cumple las condiciones y se llama el metodo eliminar y se le manda la identificacion
                // para que este lo elimine
                deleteBoyDe(temp.getData().getIdentification());
            }
            // se le da paso al siguiente nodo
            temp=temp.getNext();
        }
    }

    /**
     * metodo que me permite eliminar de la lista por genero
     * @param gender
     * @throws ListaSeException
     */
    public void deleteForGenderDe(String gender) throws ListaSeException{
        // se valida si hay datos en la lista
        valdateListeEmptyDe();
        // se crea un nodo que se pare en la cabeza y me ayude a recorrer la lista
        Node temp = this.head;
        // se recorre el ciclo hasta el ultimo dato
        while(temp!=null){
            // se pregunta si el genero del dato acutal es igual al genero
            if(temp.getData().getTypeSex().equals(gender)){
                // si ingresa aqui es porque cumple las condiciones y se llama el metodo eliminar y se le manda la identificacion
                // para que este lo elimine
                deleteBoyDe(temp.getData().getIdentification());
            }
            // se le da paso al siguiente niño
            temp=temp.getNext();
        }
    }

    /**
     * metodo que me permite determinar el niño yh la niña  con la edad mayor
     * @return
     * @throws ListaSeException
     */
    public List<Boy> boyAndChildrenHigherDe()throws ListaSeException{
        // se valida si hay datis
        valdateListeEmptyDe();
        // se crea un ayudante que me ayude a recorrer la lista
        Node temp=this.head;
        List<Boy> listForHigher = new ArrayList<>();
        // crea un ayudante para que la edad empiece en =0;
        //Boy girlMax = new Boy();
        while(temp!= null){
            if(temp.getData().getTypeSex().equals("F") ){
                //pregunta si la edaddel ayudante es mayor al contador
                // se almacena los datos del niño en el ayudante
                if(temp.getNext()==null){
                    // listForHigher.add();//agrega a la lista a
                }
            }
            if(temp.getData().getTypeSex().equals("M")){
                //pregunta si la edad es mayor al contador
                // se almacena los datos del niño en el ayudante

            }
            // se da paso al siguiente dato
            temp=temp.getNext();
        }
        // se retorna la lista
        return listForHigher;

    }

    /**
     * metodo que me elimina un niñon dada una posicion
     * @param pos
     * @throws ListaSeException
     */
    public void deleteToPositionDe(int pos) throws ListaSeException {

        /**
         * se pregunta si la validacion es mayor a la cantidad de niño
         * si ingresa a este es porque la posicion es valida
         * y se procede a eliminar el niño
         */
        if (pos > count) {
            //this.add(boy);
            //return;
            throw new ListaSeException("LA posicion ingresada no es valida");
        }
        /**
         * se pregunta a la que quieren ingresar al niño es la primer
         * y se llama el metodo que lo agrega al principio
         */
        if (pos == 1) {
            // si la posicion a eliminar es 1, se le dice que la nueva cabeza es el que tenia agarrado
            this.head = head.getNext();
        } else {
            /**
             *se crea un contador que inicializa en 1
             * se crea un ayudante que se pare en la cabeza y nos ayude a recorrer todo el listado
             * se empieza a recorrer todo el ciclo hasta llegar al ultimo
             */
            int cont = 1;
            Node temp = this.head;
            while (temp != null) {
                // se pregunta si el contador es igual a la posicion menos 1
                if (cont == pos - 1) {
                    // se hace un alto
                    // se llama el metodo eliminar al dato actual
                    deleteBoyDe(temp.getData().getIdentification());
                    break;
                }
                //se le da paso al siguiente nodo
                temp = temp.getNext();
                // se aumenta el contador
                cont--;
            }
            /**
             * se crea un nuevo nodo para agregar al niño
             * se le dice al brazo que agarre al anteror del ultimo
             * se le dice al brazo del ultimo que agarre al nuevo
             */
            //deleteBoy(temp.getData().getIdentification());
        }

    }

    /**
     * metodo que me permite listar por grado
     * @param grade
     * @throws ListaSeException
     */
    public void listForGradeDe(byte grade) throws ListaSeException{
        // se valida si hay datos en la lista
        valdateListeEmptyDe();
        // se pregunta si la cabeza es diferente de vacio
        if (this.head != null) {
            // se crea una lista temporal donde vamos a almacenar los datos
            ListDe listTemp = new ListDe();
            // se crea un ayudante que me ayude arecorrer la lista
            Node temp = this.head;
            // se recorre la lista hasta llegar al ultimo
            while(temp != null)
            {
                // se pregunta si el dato actual tiene el mismo grado al grado ingresado
                if (temp.getData().getGrade()==grade){
                    // se adiciona a la lista
                    listTemp.addToStartDe(temp.getData());
                }
                // se le da paso al sigueinte niño
                temp = temp.getNext();
            }
            // se asigna como cabeza ala cabeza de la nueva lista
            this.head = listTemp.getHead();
        }
    }
    public void orderBoysAgeDe()throws ListaSeException {
        //validamos si hay datos en la lista

        valdateListeEmptyDe();
        // creamos un ayudante que se pare en la cabeza
        Node temp = this.head;

        // se recorre todo el ciclo hasta llegar al ultimo

        while(temp.getNext() != null) {
            // preguntamos si la edad del niño actual es mayor a la edad del que tiene en el brazo

            if(temp.getData().getAge()>temp.getNext().getData().getAge()){
                // se crea un dato ayudante
                Boy boy = temp.getData();
                // borramos al niño que tenia el ayudante
                deleteBoyDe(temp.getData().getIdentification());
                // adicionamos al niño al final
                add(boy);
                //le decimos al ayudante que se pare de nuevo en la cabeza
                temp =this.head;
            }

            else{
                // le damos paso al siguiente niño
                temp = temp.getNext();
            }
        }
    }
    public int getCountBoysByGenderDe(String gender)
    {
        // creamos un ayudante que se pare en la cabeza
        Node temp = this.getHead();
        // empezamos el contador de el genero en cero
        int count = 0;
        // recorremos el ciclo hasta llegar al ultimo
        while (temp!=null)
        {
            // se pregunta si ael dato del niño actual(genero) es igual al genero pedido
            if(temp.getData().getTypeSex().equals(gender))
            {
                // se aumenta el contador
                count++;
            }
            // se da paso al siguiente termino
            temp=temp.getNext();
        }
        // se retorna el contadir
        return count;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * metodo para conrar los niños por locacion y por grado
     * @param location
     * @param grade
     * @return el valor del contador
     * @throws ListaSeException
     */
    public int countByLocationAndGrade(String location, byte grade) throws ListaSeException{
        // se valida si hay datos en la lista
        valdateListeEmptyDe();
        // se crea un ayudante  para que me ayude a recorrer la lista
        Node temp= this.getHead();
        // se crea un contador que empiece en cero
        int count=0;
        // se recorre el ciclo hasta el ultimo dato
        while(temp!=null){
            if(temp.getData().getLocation().getDescription().equals(location) && temp.getData().getGrade()==grade && temp.getData().isOrphan()){
                count++;
            }
            temp=temp.getNext();
        }
        return count;
    }
    public List<CountGenderDTO> getBoysorphantByLocations(){
        return null;
    }

    public int getCountBoysByOrphanGenderDe(Gender gender)
    {
        // creamos un ayudante que se pare en la cabeza
        Node temp = this.getHead();
        // empezamos el contador de el genero en cero
        int count = 0;
        // recorremos el ciclo hasta llegar al ultimo
        while (temp!=null)
        {
            // se pregunta si ael dato del niño actual(genero) es igual al genero pedido
            if(temp.getData().getTypeSex().equals(gender) && temp.getData().isOrphan())
            {
                // se aumenta el contador
                count++;
            }
            // se da paso al siguiente termino
            temp=temp.getNext();
        }
        // se retorna el contadir
        return count;
    }
    public GendersByGradeDTO listForGradeAndGenderDe(byte grade, Location location) throws ListaSeException {
        valdateListeEmptyDe();
        List<CountGenderDTO> countByGenderDTOS = new ArrayList<>();
        Node temp = this.head;
        int count = 0;
        int countF = 0;
        int countM = 0;

        while (temp != null) {
            if (temp.getData().getLocation().getCode().equals(location) && temp.getData().getGrade() == grade) {
                count++;
                if (temp.getData().isOrphan()) {
                    if (temp.getData().getTypeSex().equals(Gender.MASCULINO)) {
                        countM++;
                    } else {
                        countF++;
                    }
                }
            }
            temp = temp.getNext();
        }
        countByGenderDTOS.add(new CountGenderDTO(Gender.MASCULINO, countM));
        countByGenderDTOS.add(new CountGenderDTO(Gender.FEMENINO, countF));

        GendersByGradeDTO genderByGradeDTO = new GendersByGradeDTO(grade, countByGenderDTOS, count);

        return genderByGradeDTO;
    }
    public GradesByLocationDTO getGradesByLocacion(Location location) throws ListaSeException{
        List<GendersByGradeDTO> gendersByGradeDTO = new ArrayList<>();
        for(byte i=1; i<=5; i++){

            gendersByGradeDTO.add(listForGradeAndGenderDe(i, location));

        }
        GradesByLocationDTO gradesByLocationDTO = new GradesByLocationDTO(location,gendersByGradeDTO);
        return gradesByLocationDTO;
    }
    public void listBoysForCode() throws ListaSeException{
        // se valida si hay datos en la lista
        valdateListeEmptyDe();
        // se crea un ayudante que nos ayude a recorrer la lista
        // se crea una lista en la cual vamos a agrupar los niños
        Node temp=this.head;
        ListDe listTemp = new ListDe();
        // se recorre la lista hasta llegar al ultimo
        while (temp!= null){
            // se pregnta s el dato actual
            if(temp.getData().getTypeSex().equals(Gender.MASCULINO)){
                // si ingresa aqui el dato del niño se agrega al comienzo
                listTemp.addToStartDe(temp.getData());
            }else{
                // si no se cumple lo anterior se agregar al niño al final
                listTemp.add(temp.getData());
            }
            // se le da paso al siguiente dato
            temp=temp.getNext();
        }
        // se asigna como cabeza este nuevo listado
        this.head = listTemp.getHead();
    }

    /**
     *metodo que me permite ahrehar un niño por nodo ingresado
     * @param nodeInt
     * @throws ListaSeException
     */
    public void addNode(Node nodeInt)throws ListaSeException {
        // se pregunta si la cabeza esta vacia
        // se agrega al nodo nuevo a la cabeza
        if (this.head == null) {
            this.head = nodeInt;
        } else {
            // se cre un ayudanye que se pare en la cabeza
            // recorremos todo el ciclo hasta pararnos en el ultimo
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();

            }
            // se le dice al ultimo que agarre al nuevo nodo
            // y que el nodo neuvo agarre al que esta parado el ayudando
            temp.setNext(nodeInt);
            nodeInt.setPrevius(temp);
        }
    }
    public ListDe listDeLocacion(Location location) throws ListaSeException{
        ListDe listTemp= new ListDe();
        Node temp= this.head;
        while(temp!=null){
            if(temp.getData().getLocation().equals(location)){
                listTemp.add(temp.getData());
            }
            temp =temp.getNext();
        }
        return listTemp;
    }
    public GradeAndRhDTO getGradesAndRhDto(byte grade) throws ListaSeException{
        //GradeAndRhDTO gradeAndRhDTO= new GradeAndRhDTO(grade);
        Node temp= this.head;
        String rh="";
        int count=0;
        while(temp!=null){
            if(temp.getData().getGrade()==grade){
                if(rh.contains(temp.getData().getRh())){
                    rh= rh +" , "+temp.getData().getRh();
                }
                count++;
            }
            temp=temp.getNext();
        }
        return  new GradeAndRhDTO(grade,rh,count);
    }


    public GradeByGenderDTO getGradesByGenderDTO(Gender gender)throws ListaSeException{
        GradeAndRhDTO [] gradeAndRhDTO= new GradeAndRhDTO[5];
        for(byte i=1; i<=5; i++){
            gradeAndRhDTO[i]=getGradesAndRhDto((byte)(i+1));

        }
        return new GradeByGenderDTO(gender,gradeAndRhDTO);

        }


    /*
    public GradesByLocationDTO gradesByLocationDTO() throws ListaSeException {
        //GradesByLocationDTO gradesByLocationDTO= new GradesByLocationDTO();

        ListDe listTemp= new ListDe();
        for(Location loc:locations){
            ListDe listLoc=this.listBoys.listDeLocacion(loc);
            if(listLoc.getHead()!=null){
                listTemp.addNode(listLoc.getHead());
            }

    }*/
}






