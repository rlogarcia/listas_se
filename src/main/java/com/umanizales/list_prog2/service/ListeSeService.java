package com.umanizales.list_prog2.service;

import com.umanizales.list_prog2.controller.dto.GradesByLocationDTO;
import com.umanizales.list_prog2.controller.dto.ResponseDTO;
import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.*;
import com.umanizales.list_prog2.model.List_Se.ListSE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * se inyecta el servicio con el service
 * la clase service me permite inicializar los metodos y dar respuestas a cierto tipo de variables
 */
public class ListeSeService {
    // se llama una variable para alternar la lista se
    private ListSE listBoys;
    // se crea un arreglo de tipo locacion
    private List<Location> locations;

    /**
     * se tiene un metodo para inicializar los metodos
     * crar una liste de tipo losta
     * inicializar el metoo de locacion
     */
    public ListeSeService() {
        listBoys = new ListSE();
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
        // pregunta su la locacion del ni??o es diferente a las de las listas
        if(!validateLocation(boy.getLocation())){
            // como no son iguales se  lanza una excepcion y el viejito chismo grita
            throw  new ListaSeException("La ubicacion ingresada no es valida");
        }
        // se llama el metodo de agregar
        listBoys.add(boy);
        // se retorna una respuesta satisfactoria y se agrega el ni??o a la lista
            return new ResponseEntity<>(new ResponseDTO("Ni??o adicionado",true,null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista los ni??os y llama el metodo listar
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException {
        // se pregunta si la cabeza esta vacia
        if(listBoys.getHead()== null){
            // se responde con una excepcion de que no la lista
            throw new ListaSeException("No hay datos en la lista");
        }
        // se responde con satisfactorio y que hubo conexcion con el sistema.
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me invierte los ni??os y llama el metodo invertir
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException {
        // llama el metodo invertir
        listBoys.invert();
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
        // llama el metodo adicionar y se agrega la data del ni??o
        listBoys.addToStart(boy);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Ni??o Adicionado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me cuenta los ni??os y llama el metodo contar ni??os
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> getCount() {
        // respuesta satisfactoria con el numero total de ni??os
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getCount(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me cuenta los ni??os y llama el metodo contar ni??os
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> Count() {
        // respuesta satisfactoria y conteo total de los ni??os
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getCount(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista libre los ni??os y llama el metodo listar ni??os libres
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException {
        // hubo conexion con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.list(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me cambia los ni??os y llama el metodo cambiar ni??os de extremos en la lista
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> changeStartoEnd() throws ListaSeException{
        // se llama el metodo el cual me cambia los ni??os de extremos
        listBoys.changeStartoEnd();
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Satisfacorio", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me elimina a un ni??os y llama el metodo eliminar ni??o
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoy(String id) throws ListaSeException {
        // se llama el metodo eliminar ni??o y se le envia un parametro que es identificacion
        listBoys.deleteBoy(id);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me adiciona los ni??os y llama el metodo adicionar ni??os sin repetir
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addNoRepeat(Boy boy) {
        // me llama el metodo de agregar sin reptir y le enviamos la data de un ni??o
        listBoys.addNoRepeat(boy);
        // hubo conexion con el sistema
        return new ResponseEntity<>(new ResponseDTO("Ni??o Adicionado", true, null), HttpStatus.OK);
    }

    /*public ResponseEntity<ResponseDTO> listTypeSex(String typeSex) {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.list().stream().filter(boy-> boy.getTypeSex().equals(typeSex)) , null), HttpStatus.OK);
    }*/
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista  los ni??os y llama el metodo listar ni??os por genero
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> forGenderList(String typeSex)
    {
        // llama el metodo de listar los ni??os por genero y se le envia un tipon de sexo por el cual listar
        listBoys.forGenderList(typeSex);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me cuenta los ni??as y llama el metodo contar ni??as
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> countGirls(){
        // respuesta con el coneto de las ni??as
        return new ResponseEntity<>(new ResponseDTO("Cantidad de ni??as", listBoys.countGender(), null),HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me cuenta los ni??os y llama el metodo contar ni??os
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> countBoys(){
        // respuesta con el coneto de los ni??os
        return new ResponseEntity<>(new ResponseDTO("Cantidad de ni??os", listBoys.countGenderM(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me adiciona los ni??os y llama el metodo adicionar ni??os por posicion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> addBoyByPos(Boy boy,int pos) throws ListaSeException {
        // se llama el metodo adicionar por poscion
        listBoys.addToPosition(boy,pos);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Ni??o Adicionado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me varia los ni??os y llama el metodo variar ni??os por gener
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException {
        // se llama el metodo que me intercala los ni??os
        listBoys.variantBoys();
        // respuesta satisfacotria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me obtener los ni??os y llama el metodo obetener los ni??os por locacion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> getBoyByLocation(){
        // se crea una arraylist con los ni??os por locacion
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        // se hace un ciclo que me recorra todos los municipios y me cuente la cantidad en los mismos
        for(Location loc:locations){
            // contador de cada uno de las locaciones
            int count = listBoys.getCountByLocation(loc.getCode());
            boysByLocations.add(new BoysByLocation(loc,count));

        }
        // se retorna la respuesta con la cantidad de ni??os por locacion
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", boysByLocations, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista los ni??os y llama el metodo lista los ni??os poredad y municipio
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForAgeAndMu(int age,String municipio) throws ListaSeException {
        // se pregunta si la lista esta vacia
        listBoys.listForAgeAndMu(age, municipio);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("satisfactorio",listBoys.getHead() , null), HttpStatus.OK);
    }
    //  // listBoys.listForAgeAndMu(age,municipio)

   public ResponseEntity<ResponseDTO> getBoysByGender()
    {
        List<BoysByGender> boysByGenders = new ArrayList<>();

            int count = listBoys.getCountBoysByGender(Gender.MASCULINO);
            boysByGenders.add(new BoysByGender(Gender.MASCULINO,count));

            int count1 = listBoys.getCountBoysByGender(Gender.FEMENINO);
            boysByGenders.add(new BoysByGender(Gender.FEMENINO,count1));

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista los ni??os y llama el metodo lista los ni??os poredad y genero
     * @return una respuesta
     * @throws ListaSeException
     */
   public ResponseEntity<ResponseDTO> listForAgeAndGender(int age, String gender) throws ListaSeException
   {
       // se llama al metodo de listar por edad y genero
       listBoys.listForAgeAndGender(age,gender);
       // se tuvo respuesta del sistema
       return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
   }

    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me elimina los ni??os y llama el metodo eliminar  los ni??os poreda
     * @return una respuesta
     * @throws ListaSeException
     */public ResponseEntity<ResponseDTO> deleteBoyForAge(byte age) throws ListaSeException {
        // se llama el metodo eliminar ni??o y se le envia un parametro que es identificacion
        listBoys.deleteForAge(age);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me eliminar los ni??os y llama el metodo eliminar los ni??os por genero
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyForGender(String gender) throws ListaSeException {
        // se llama el metodo eliminar ni??o y se le envia un genero
        listBoys.deleteForGender(gender);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me eliminar los ni??os y llama el metodo eliminar los ni??os por poscicion
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> deleteBoyByPos(int pos) throws ListaSeException {
        // se llama el metodo eliminar por posicion
        listBoys.deleteToPosition(pos);
        // respuesta satisfactoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Ni??o eliminado", true, null), HttpStatus.OK);
    }
    /**
     *calse de respuesta que me devuelve una exepcion ??
     * me devuelve una respuesta acertiva con el sistema y me lista los ni??os y llama el metodo listar los ni??os por grado
     * @return una respuesta
     * @throws ListaSeException
     */
    public ResponseEntity<ResponseDTO> listForGrade(byte grade) throws ListaSeException
    {
        // se llama el metodo de listar por grados
        listBoys.listForGrade(grade);
        // respuesta satisfacoria con el sistema
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getHead(), null), HttpStatus.OK);
    }
    ////
    public ResponseEntity<ResponseDTO> locationMax()
    {
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        int maxLocation=0;
        for(Location loc:locations)
        {
            int count = listBoys.getCountByLocation(loc.getCode());
            if(count> maxLocation){
                maxLocation=count;
                boysByLocations.clear();
                boysByLocations.add(new BoysByLocation(loc,maxLocation));
            }
            else {
                if (count == maxLocation) {
                    boysByLocations.add(new BoysByLocation(loc, maxLocation));
                }
            }
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByLocations,null), HttpStatus.OK);
    }
   /* public ResponseEntity<ResponseDTO> getBoysByGender(Gender gender)
    {

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.getCountBoysByGender(gender),null), HttpStatus.OK);
    }*/

    public ResponseEntity<ResponseDTO> getOrphansByGradesByLocation()
    {
        List<GradesByLocationDTO> gradesByLocationDTOS = new ArrayList<>();

        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",gradesByLocationDTOS,null), HttpStatus.OK);
    }
}
