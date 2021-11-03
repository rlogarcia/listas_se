package com.umanizales.list_prog2.controller;

import com.umanizales.list_prog2.controller.dto.ResponseDTO;
import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.Boy;
import com.umanizales.list_prog2.service.ListDeService;
import com.umanizales.list_prog2.service.ListeSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * clase creada para como su nombre lo dice controlar el acceso a cada uno de los links
 * y que a su vez cada que se necesite(autowired)  se llaman a los metodos de cada lista que sea necesario
 * el requiesmapping
 */
@RestController
@RequestMapping(path="/boys")
public class BoysController {
    /**
     * el famoso llamame cuando me necesites  y tambien es una forma de llamar la una clase con otro nombre
     * y poderla llamar mas adelante
     */
    @Autowired
    private ListeSeService listeSeService;
    @Autowired
    private ListDeService listDeServiceDe;

    /**
     *
     * @param boy parametro que pide y valida con todos sus datos para agregar en el metodo adiccionado
     * @return lo que se retorna es una lista ya con el niño agregado
     * @throws ListaSeException esta es la excepcion que puede lanzar y le esta haciendo pasarela para que el no sea el que grite la excepcion
     *
     */
    @PostMapping
    public ResponseEntity<ResponseDTO> addBoy(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listeSeService.addBoy(boy);
    }

    /**
     * este es un metodo que nos ayuda a listar los niños de manera independiente y no solicita
     * ningun dato para ser ejecutado
     * @return se retorna la lista con los niños que se encuentren ya en la respectiva lista
     * @throws ListaSeException esta es la excepcion que puede lanzar
     * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping
    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException {
        return listeSeService.listBoys();
    }

    /**
     * metodo para invertir la lista en el getmpaping se slicita la palabra invertir y automaticamente el invierte la lista llamando
     * el metodo de invertir lista
     * @return se retorna la lista ya invertidad
     * @throws ListaSeException esta es la excepcion que puede lanzar
     * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/invert")
    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException {
        return listeSeService.invertList();
    }

    /**
     *
     * @param boy se solicita el parametro con los dats del niños ademas  donde validan los mismos
     * @return se retorna al niño agregado al comienzo de la lista si cumple los parametros y despues de los mismos
     * ser validados
     * @throws ListaSeException  esta es la excepcion que puede lanzar
     *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @PostMapping(path = "/addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listeSeService.addToStart(boy);
    }
    /**
     *
     * @param boys se solicita el parametro con los dats del niños ademas  donde validan los mismos
     * @return se retorna al niño agregado al final de la lista si cumple los parametros y despues de los mismos
     * ser validados y es un cuclo donde agregan una cantidad n de niñ@s
     * @throws ListaSeException  esta es la excepcion que puede lanzar
     *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @PostMapping(path = "/addboys")
    public ResponseEntity<ResponseDTO> addBoys(@RequestBody @Valid List<Boy> boys) throws ListaSeException {
        for (Boy boy : boys) {
            listeSeService.addBoy(boy);
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Satisfactorio", listeSeService.listBoys(), null), HttpStatus.OK);
    }

    /**
     * metodo que en el get solicita el parametro getcount y te llama al metodo contar niños
     * @return te retorna la cantidad de niños en total que hay en la lista
     */
    @GetMapping(path = "/getcount")
    public ResponseEntity<ResponseDTO> getCount() {
        return listeSeService.getCount();
    }
    /**
     * metodo que en el get solicita el parametro getcount y te llama al metodo contar niños
     * @return te retorna la cantidad de niños en total que hay en la lista
     */
    @GetMapping(path = "/count")
    public ResponseEntity<ResponseDTO> count() {
        return listeSeService.getCount();
    }

    /**
     * metodo que me lista los niños de manera libre sin los brazosn, pero si en orden
     * @return retorna una lista de niños pero de una manera mas libre
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/free")
    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException {
        return listeSeService.listBoysFree();
    }

    /**
     * metodo que me cambia los extremos de los niños, estos cambian de posicion
     * @return retorna la misma lista pero con los extremos que cambian de posicion
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/changextremes")
    public ResponseEntity<ResponseDTO> changeStartoEnd() throws ListaSeException {
        return listeSeService.changeStartoEnd();
    }

    /**
     * metodo que elimina un niña de la lista
     * @param id parametro que se solicita para  a su vez bsuscar la misma identificacion del niño y eliminarlo de la lista
     * @return retorna un mensaje satsifactorio con el servicio del nño ya eliminado
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/deleteboy/{id}")
    public ResponseEntity<ResponseDTO> deleteBoy(@PathVariable String id) throws ListaSeException {
        return listeSeService.deleteBoy(id);
    }

    /**
     * este metodo verifica que se agreguen los niños sin repetir suss identificaciones
     * @param boy el paraetro que pide para poder ejecutarce es los datos de un niño
     * @return retorna el listado de los niños, con el niño ya agregado
     */
    @PostMapping(path = "/addnorepeat")
    public ResponseEntity<ResponseDTO> addNoRepeat(@RequestBody Boy boy) {
        return listeSeService.addNoRepeat(boy);
    }

    /*@GetMapping(path = "/list/{typesex}")
    public ResponseEntity<ResponseDTO>typeSex(@PathVariable String typesex){return listeSeService.listTypeSex(typesex);}*/

    /**
     * metodo que me permite listar segun el tipo de sexo que se le envie en el geytmapping
     * @param typeSex el parametro a ingresar el el genero en el cual vamos a listar
     * @return se retorna una lista con el genero que se pide a ser listado
     */
    @GetMapping(path = "/listsex/{typeSex}")
    public ResponseEntity<ResponseDTO> listForType(@PathVariable String typeSex) {
        return listeSeService.forGenderList(typeSex);
    }
    /**
     * metodo que en el get solicita el parametro getcount y te llama al metodo contar niños
     * @return te retorna la cantidad de niñas en total que hay en la lista
     */
    @GetMapping(path = "/count/girl")
    public ResponseEntity<ResponseDTO> countGirl() {
        return listeSeService.countGirls();
    }
    /**
     * metodo que en el get solicita el parametro getcount y te llama al metodo contar niños
     * @return te retorna la cantidad de niños en total que hay en la lista
     */
    @GetMapping(path = "/count/boy")
    public ResponseEntity<ResponseDTO> countBoys() {
        return listeSeService.countBoys();
    }

    /**
     * metodo que me permite cambiar la posicion de un niño y los recibe dos parametros(el niño y la posicion en la que lo vamos a poner
     * @param pos el parametro es la posicion del niño en la que lo vamos a ingresar a la lista
     * @param boy este es el parametro del niño que desea ingrear a la lista
     * @return se devuelve la lista con el niño insertado en una posicion n
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @PostMapping(path = "/addtopositon/{pos}")
    public ResponseEntity<ResponseDTO> addBoyToPosition(@PathVariable int pos, @RequestBody Boy boy) throws ListaSeException {
        return listeSeService.addBoyByPos(boy, pos);
    }

    /**
     * metodo que me permite intercalar en un listado ya sea niños o niñas seugun el mayor numero de los mismos
     * @return este retorna la nueva lista donde se encuentra intercalados los niños por genero
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/variant")
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException {
        return listeSeService.variantList();
    }

    /**
     * metodo  que me lista los niños segun la locacion de los mismos
     * @return me retorna el metodo de los niños por locacion
     */
    @GetMapping(path = "/boysbylocation")
    public ResponseEntity<ResponseDTO> boysbylocation() {
        return listeSeService.getBoyByLocation();
    }

    /**
     * metodo que me permite decirle al usuario los niños que hay igual a la edad  y el municipio que se ha ingresado
     * @param age el parametro es la edad del niño  que se desea verificar
     * @param municipio el parametro es el muniipio del niño que se desea verificar
     * @returnse retorna el listado que cumple las condiciones del proceso
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/listforageandmu/{age}/{municipio}")
    public ResponseEntity<ResponseDTO> listForAgeAndMu(int age, String municipio) throws ListaSeException {
        return listeSeService.listForAgeAndMu(age, municipio);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param boy se solicita el parametro con los dats del niños ademas  donde validan los mismos
     * @return se retorna al niño agregado al comienzo de la lista si cumple los parametros y despues de los mismos
     * ser validados
     * @throws ListaSeException  esta es la excepcion que puede lanzar
     *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @PostMapping(path = "/addtostartde")
    public ResponseEntity<ResponseDTO> addBoyToStartDe(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listDeServiceDe.addToStart(boy);
    }
    /**
     * este es un metodo que nos ayuda a listar los niños de manera independiente y no solicita
     * ningun dato para ser ejecutado
     * @return se retorna la lista con los niños que se encuentren ya en la respectiva lista
     * @throws ListaSeException esta es la excepcion que puede lanzar
     * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/listde")
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaSeException {
        return listDeServiceDe.listBoysDe();
    }
    /**
     *
     * @param boy parametro que pide y valida con todos sus datos para agregar en el metodo adiccionado
     * @return lo que se retorna es una lista ya con el niño agregado
     * @throws ListaSeException esta es la excepcion que puede lanzar y le esta haciendo pasarela para que el no sea el que grite la excepcion
     *
     */
    @PostMapping(path = "/addde")
    public ResponseEntity<ResponseDTO> addDe(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listDeServiceDe.addBoy(boy);
    }
    /**
     * metodo que me lista los niños de manera libre sin los brazosn, pero si en orden
     * @return retorna una lista de niños pero de una manera mas libre
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/freede")
    public ResponseEntity<ResponseDTO> listBoysFreeDe() throws ListaSeException {
        return listDeServiceDe.listBoysFreeDe();
    }
    /**
     * metodo que elimina un niña de la lista
     * @param id parametro que se solicita para  a su vez bsuscar la misma identificacion del niño y eliminarlo de la lista
     * @return retorna un mensaje satsifactorio con el servicio del nño ya eliminado
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/deleteboyde/{id}")
    public ResponseEntity<ResponseDTO> deleteBoyDe(@PathVariable String id) throws ListaSeException {
        return listDeServiceDe.deleteBoyDe(id);
    }
    /**
     * metodo que me cambia los extremos de los niños, estos cambian de posicion
     * @return retorna la misma lista pero con los extremos que cambian de posicion
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @GetMapping(path = "/changextremesde")
    public ResponseEntity<ResponseDTO> changeStartoEndDe() throws ListaSeException {
        return listDeServiceDe.changeStartoEndDe();
    }
    /**
     * metodo que me permite cambiar la posicion de un niño y los recibe dos parametros(el niño y la posicion en la que lo vamos a poner
     * @param pos el parametro es la posicion del niño en la que lo vamos a ingresar a la lista
     * @param boy este es el parametro del niño que desea ingrear a la lista
     * @return se devuelve la lista con el niño insertado en una posicion n
     * @throws ListaSeException esta es la excepcion que puede lanzar
     *      *      *      * y le esta haciendo pasarela para que el no sea el que grite la excepcion
     */
    @PostMapping(path = "/addtopositonde/{pos}")
    public ResponseEntity<ResponseDTO> addBoyToPositionDe(@PathVariable int pos, @RequestBody Boy boy) throws ListaSeException {
        return listDeServiceDe.addBoyByPosDe(boy, pos);
    }
}
