package com.umanizales.list_prog2.service;

import com.umanizales.list_prog2.controller.dto.GradesByLocationDTO;
import com.umanizales.list_prog2.controller.dto.ResponseDTO;
import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.*;
import com.umanizales.list_prog2.model.List_Se.ListSE;
import com.umanizales.list_prog2.model.List_Se.Node;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.umanizales.list_prog2.model.List_De.*;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * se inyecta el servicio con el service
 * la clase service me permite inicializar los metodos y dar respuestas a cierto tipo de variables
 */
public class ListDeService {
    // se llama una variable para alternar la lista de
    private ListDe listBoys;
    // se crea un arreglo de tipo locacion
    private List<Location> locations;

    public ListDeService(){

        /**
         * se tiene un metodo para inicializar los metodos
         * crar una liste de tipo losta
         *
         */
        listBoys = new ListDe();
    }
    /**
     * se tiene un metodo para crear cada una de las ciudades que vamos a tener en el metodo
     * se inicializq la creacion del arreglo
     */
    private void inicializatedLocation(){
        locations = new ArrayList<>();
        locations.add(new Location("170001","Manizales"));
        locations.add(new Location("170002","Chinchina"));
        locations.add(new Location("170003","Pereira"));
    }
    /**
     * se crea un metodo que nos valida la locacion y nos devuelva un falso o un verdadero, segun las ciondiciones establecidad
     */
    public Boolean validateLocation(Location location){
        // se hace un ciclo de tipo locacion
        for(Location loc: locations){
            //se pregunta en el que se encuentra es igual a la variable a la que estan en el metodo locacion
            if(loc.getCode().equals(location.getCode()) && loc.getDescription().equals(location.getDescription())){
                return true;            }
        }
        return false;
    }
    /**
     * clase de respiuesta que me debuelva una excepcion ó
     * me devuelve una resspuesta acertada con el sistema y me agrega el niño a la lista
     * @param boy
     * @returnme devuelve una respiesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoy(Boy boy) throws ListaSeException {
        // se llama el metodo de adiccionar niños
        listBoys.add(boy);
        // hubo respuesta con el sistema
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",true,null), HttpStatus.OK);


    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me lista libre los niños y llama el metodo listar niños libres
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listBoysFreeDe() throws ListaSeException {
        // conexion satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.listDe(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me lista los niños y llama el metodo listar
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaSeException {
        // se pregunta si la cabeza esta vacia
        if(listBoys.getHead()== null){
            // el viejito chsimoso lanza una excepcion y grita
            throw new ListaSeException("No hay datos en la lista");
        }
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me adiciona los niños y llama el metodo adicionar al principio
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addToStart(Boy boy) throws ListaSeException{
        // se llama el metodo agregar al inicio y se le envia la data del niño
        listBoys.addToStartDe(boy);
        // hubo coexion con el sistema
        return new ResponseEntity<>(new ResponseDTO("Niño Adicionado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me elimina a un niños y llama el metodo eliminar niño
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyDe(String id) throws ListaSeException {
        // se llama el metodo eliminar niño y se le envia un parametro que es identificacion
        listBoys.deleteBoyDe(id);
        // respuesta satisfacotria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me cambia los niños y llama el metodo cambiar niños de extremos en la lista
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> changeStartoEndDe() throws ListaSeException{
        // se llama el metodor cambiar extremos
        listBoys.changeStartoEndDe();
        // respuesta satisfacoria
        return new ResponseEntity<>(new ResponseDTO("Satisfacorio", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me adiciona los niños y llama el metodo adicionar niños por posicion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoyByPosDe(Boy boy,int pos) throws ListaSeException {
        // se llama el metodo añadir por posicion y se le envia la data del niño y la poscicion
        listBoys.addToPositionDe(boy,pos);
        // restorna una respuesta satisfacotoria
        return new ResponseEntity<>(new ResponseDTO("Niño Adicionado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me invierte los niños y llama el metodo invertir
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> invertListDe() throws ListaSeException {
        // llama el metodo invertir
        listBoys.invertDe();
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me obtener los niños y llama el metodo obetener los niños por locacion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> getBoyByLocationDe(){
        // se crea una arraylist con los niños por locacion
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        // se hace un ciclo que me recorra todos los municipios y me cuente la cantidad en los mismos
        for(Location loc:locations){
            // contador de cada uno de las locaciones
            int count = listBoys.getCountByLocationDe(loc.getCode());
            boysByLocations.add(new BoysByLocation(loc,count));

        }
        // se retorna la respuesta con la cantidad de niños por locacion
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", boysByLocations, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me varia los niños y llama el metodo variar niños por gener
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> variantListDe() throws ListaSeException {
        // se llama el metodo que me intercala los niños
        listBoys.variantBoysDe();
        // respuesta satisfacotria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me lista los niños y llama el metodo lista los niños poredad y genero
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForAgeAndGenderDe(int age, String gender) throws ListaSeException
    {
        // se llama al metodo de listar por edad y genero
        listBoys.listForAgeAndGenderDe(age,gender);
        // se tuvo respuesta del sistema
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me elimina los niños y llama el metodo eliminar  los niños poreda
     * @return una respuesta
     * @throws ListaSeException
     */public ResponseEntity<ResponseDTO> deleteBoyForAgeDe(byte age) throws ListaSeException {
        // se llama el metodo eliminar niño y se le envia un parametro que es identificacion
        listBoys.deleteForAgeDe(age);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me eliminar los niños y llama el metodo eliminar los niños por genero
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyForGenderDe(String gender) throws ListaSeException {
        // se llama el metodo eliminar niño y se le envia un genero
        listBoys.deleteForGenderDe(gender);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me eliminar los niños y llama el metodo eliminar los niños por poscicion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyByPosDe(int pos) throws ListaSeException {
        // se llama el metodo eliminar por posicion
        listBoys.deleteToPositionDe(pos);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Niño eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ó
     * me devuelve una respuesta acertiva con el sistema y me lista los niños y llama el metodo listar los niños por grado
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForGradeDe(byte grade) throws ListaSeException
    {
        // se llama el metodo de listar por grados
        listBoys.listForGradeDe(grade);
        // respuesta satisfacoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }
   /* public ResponseEntity<ResponseDTO> getBoysByGenderDe(String gender)
    {

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getCountBoysByGenderDe(gender), HttpStatus.OK);
    }*/
/*
   public ResponseEntity<ResponseDTO> getBoysByGenderDe()
   {
       List<BoysByGender> boysByGenders = new ArrayList<>();

       int count = listBoys.getCountBoysByOrphanGenderDe(Gender.MASCULINO);
       boysByGenders.add(new BoysByGender(Gender.MASCULINO,count));

       int count1 = listBoys.getCountBoysByOrphanGenderDe(Gender.FEMENINO);
       boysByGenders.add(new BoysByGender(Gender.FEMENINO,count1));

       return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
   }*/
    public ResponseEntity<ResponseDTO>  getOrphansByGradeByLocation() throws ListaSeException
    {
        List<GradesByLocationDTO> gradeByLocationDTOS = new ArrayList<>();
        for (Location loc: locations)
        {
            gradeByLocationDTOS.add(listBoys.getGradesByLocacion(loc));
        }

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", gradeByLocationDTOS, null), HttpStatus.OK);
    }


}
