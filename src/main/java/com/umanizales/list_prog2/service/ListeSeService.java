package com.umanizales.list_prog2.service;

import com.umanizales.list_prog2.controller.dto.ResponseDTO;
import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.Boy;
import com.umanizales.list_prog2.model.BoysByLocation;
import com.umanizales.list_prog2.model.List_Se.ListSE;
import com.umanizales.list_prog2.model.Location;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListeSeService {
    private ListSE listBoys;
    private List<Location> locations;


    public ListeSeService() {
        listBoys = new ListSE();
        inicializatedLocation();
    }

    private void inicializatedLocation(){
        locations = new ArrayList<>();
        locations.add(new Location("170001","Manizales"));
        locations.add(new Location("170002","Chinchina"));
        locations.add(new Location("170003","Pereira"));
    }
    public Boolean validateLocation(Location location){
        
        for(Location loc: locations){
            if(loc.getCode().equals(location.getCode()) && loc.getDescription().equals(location.getDescription())){
                 return true;            }
        }
        return false;
    }

    public ResponseEntity<ResponseDTO> addBoy(Boy boy) throws ListaSeException {
        if(!validateLocation(boy.getLocation())){
            throw  new ListaSeException("La ubicacion ingresada no es valida");
        }
        listBoys.add(boy);
            return new ResponseEntity<>(new ResponseDTO("Niño adicionado",true,null), HttpStatus.OK);


    }

    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException {
        if(listBoys.getHead()== null){
            throw new ListaSeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException {
        listBoys.invert();
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addToStart(Boy boy) throws ListaSeException{
        listBoys.addToStart(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño Adicionado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getCount() {
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getCount(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> Count() {
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getCount(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException {
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.list(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> changeStartoEnd() throws ListaSeException{
        listBoys.changeStartoEnd();
        return new ResponseEntity<>(new ResponseDTO("Satisfacorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> deleteBoy(String id) throws ListaSeException {
        listBoys.deleteBoy(id);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addNoRepeat(Boy boy) {
        listBoys.addNoRepeat(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño Adicionado", true, null), HttpStatus.OK);
    }

    /*public ResponseEntity<ResponseDTO> listTypeSex(String typeSex) {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",listBoys.list().stream().filter(boy-> boy.getTypeSex().equals(typeSex)) , null), HttpStatus.OK);
    }*/
    public ResponseEntity<ResponseDTO> forGenderList(String typeSex)
    {
        listBoys.forGenderList(typeSex);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",true, null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> countGirls(){

        return new ResponseEntity<>(new ResponseDTO("Cantidad de niñas", listBoys.countGender(), null),HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> countBoys(){

        return new ResponseEntity<>(new ResponseDTO("Cantidad de niños", listBoys.countGenderM(), null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> addBoyByPos(Boy boy,int pos) throws ListaSeException {
        listBoys.addToPosition(boy,pos);
        return new ResponseEntity<>(new ResponseDTO("Niño Adicionado", true, null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException {
        listBoys.variantBoys();
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> getBoyByLocation(){
        List<BoysByLocation> boysByLocations = new ArrayList<>();
        for(Location loc:locations){
            int count = listBoys.getCountByLocation(loc.getCode());
            boysByLocations.add(new BoysByLocation(loc,count));

        }
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", boysByLocations, null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> listForAgeAndMu(int age,String municipio) throws ListaSeException {
        if(listBoys.getHead()== null){
            throw new ListaSeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.listForAgeAndMu(age,municipio), null), HttpStatus.OK);
    }
   /* public ResponseEntity<ResponseDTO> getBoysByGender()
    {
        List<BoysByGender> boysByGenders = new ArrayList<>();
        for(Gender1 gender:genders)
        {
            int count = listBoys.getCountBoysByGender(gender.getCode());
            boysByGenders.add(new BoysByGender(gender,count));
        }
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio",boysByGenders,null), HttpStatus.OK);
    }*/

}
