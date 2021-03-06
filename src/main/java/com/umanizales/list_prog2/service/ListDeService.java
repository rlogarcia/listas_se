package com.umanizales.list_prog2.service;

import com.umanizales.list_prog2.controller.dto.GradesByLocationDTO;
import com.umanizales.list_prog2.controller.dto.ResponseDTO;
import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.*;
import com.umanizales.list_prog2.model.List_Se.ListSE;
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
        inicializatedLocation();
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
     * clase de respiuesta que me debuelva una excepcion ??
     * me devuelve una resspuesta acertada con el sistema y me agrega el ni??o a la lista
     * @param boy
     * @returnme devuelve una respiesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoy(Boy boy) throws ListaSeException {
        // se llama el metodo de adiccionar ni??os
        listBoys.add(boy);
        // hubo respuesta con el sistema
        return new ResponseEntity<>(new ResponseDTO("Ni??o adicionado",true,null), HttpStatus.OK);


    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista libre los ni??os y llama el metodo listar ni??os libres
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listBoysFreeDe() throws ListaSeException {
        // conexion satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.listDe(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista los ni??os y llama el metodo listar
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
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me adiciona los ni??os y llama el metodo adicionar al principio
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addToStart(Boy boy) throws ListaSeException{
        // se llama el metodo agregar al inicio y se le envia la data del ni??o
        listBoys.addToStartDe(boy);
        // hubo coexion con el sistema
        return new ResponseEntity<>(new ResponseDTO("Ni??o Adicionado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me elimina a un ni??os y llama el metodo eliminar ni??o
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyDe(String id) throws ListaSeException {
        // se llama el metodo eliminar ni??o y se le envia un parametro que es identificacion
        listBoys.deleteBoyDe(id);
        // respuesta satisfacotria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me cambia los ni??os y llama el metodo cambiar ni??os de extremos en la lista
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
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me adiciona los ni??os y llama el metodo adicionar ni??os por posicion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoyByPosDe(Boy boy,int pos) throws ListaSeException {
        // se llama el metodo a??adir por posicion y se le envia la data del ni??o y la poscicion
        listBoys.addToPositionDe(boy,pos);
        // restorna una respuesta satisfacotoria
        return new ResponseEntity<>(new ResponseDTO("Ni??o Adicionado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me invierte los ni??os y llama el metodo invertir
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
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me obtener los ni??os y llama el metodo obetener los ni??os por locacion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> getBoyByLocationDe(){
        // se crea una arraylist con los ni??os por locacion
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        // se hace un ciclo que me recorra todos los municipios y me cuente la cantidad en los mismos
        for(Location loc:locations){
            // contador de cada uno de las locaciones
            int count = listBoys.getCountByLocationDe(loc.getCode());
            boysByLocations.add(new BoysByLocation(loc,count));

        }
        // se retorna la respuesta con la cantidad de ni??os por locacion
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", boysByLocations, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me varia los ni??os y llama el metodo variar ni??os por gener
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> variantListDe() throws ListaSeException {
        // se llama el metodo que me intercala los ni??os
        listBoys.variantBoysDe();
        // respuesta satisfacotria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista los ni??os y llama el metodo lista los ni??os poredad y genero
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
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me elimina los ni??os y llama el metodo eliminar  los ni??os poreda
     * @return una respuesta
     * @throws ListaSeException
     */public ResponseEntity<ResponseDTO> deleteBoyForAgeDe(byte age) throws ListaSeException {
        // se llama el metodo eliminar ni??o y se le envia un parametro que es identificacion
        listBoys.deleteForAgeDe(age);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me eliminar los ni??os y llama el metodo eliminar los ni??os por genero
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyForGenderDe(String gender) throws ListaSeException {
        // se llama el metodo eliminar ni??o y se le envia un genero
        listBoys.deleteForGenderDe(gender);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me eliminar los ni??os y llama el metodo eliminar los ni??os por poscicion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyByPosDe(int pos) throws ListaSeException {
        // se llama el metodo eliminar por posicion
        listBoys.deleteToPositionDe(pos);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Ni??o eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista los ni??os y llama el metodo listar los ni??os por grado
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
    /*
   public ResponseEntity<ResponseDTO> getBoysByGenderDe(String gender)
    {

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getCountBoysByGenderDe(gender), HttpStatus.OK);
    }*/

   public ResponseEntity<ResponseDTO> getBoysByGenderDe()
   {
       List<BoysByGender> boysByGenders = new ArrayList<>();

       int count = listBoys.getCountBoysByOrphanGenderDe(Gender.MASCULINO);
       boysByGenders.add(new BoysByGender(Gender.MASCULINO,count));

       int count1 = listBoys.getCountBoysByOrphanGenderDe(Gender.FEMENINO);
       boysByGenders.add(new BoysByGender(Gender.FEMENINO,count1));

       return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
   }
    public ResponseEntity<ResponseDTO>  getOrphansByGradeByLocation() throws ListaSeException
    {
        List<GradesByLocationDTO> gradeByLocationDTOS = new ArrayList<>();
        for (Location loc: locations)
        {
            gradeByLocationDTOS.add(listBoys.getGradesByLocacion(loc));
        }

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", gradeByLocationDTOS, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoysForCodeDe() throws ListaSeException {
        // se llama el metodo de listar los ji??os por codigo
        listBoys.listBoysForCode();
        // respuesta satisfacotria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> listDeLocacion() throws ListaSeException {
        ListDe listTemp= new ListDe();
        for(Location loc:locations){
            ListDe listLoc=this.listBoys.listDeLocacion(loc);
            if(listLoc.getHead()!=null){
                listTemp.addNode(listLoc.getHead());
            }
        }

        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listTemp.listDe(), null), HttpStatus.OK);
    }


}
