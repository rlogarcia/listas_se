package com.umanizales.list_prog2.service;

import com.umanizales.list_prog2.controller.dto.ResponseDTO;
import com.umanizales.list_prog2.exception.ListaSeException;
import com.umanizales.list_prog2.model.Boy;
import com.umanizales.list_prog2.model.List_Se.ListSE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.umanizales.list_prog2.model.List_De.*;

@Service
public class ListDeService {
    public ListDe listBoys;

    public ListDeService(){
        listBoys = new ListDe();
    }
    public ResponseEntity<ResponseDTO> addBoy(Boy boy) throws ListaSeException {

        listBoys.add(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado",true,null), HttpStatus.OK);


    }
    public ResponseEntity<ResponseDTO> listBoysFreeDe() throws ListaSeException {
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.listDe(), null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaSeException {
        if(listBoys.getHead()== null){
            throw new ListaSeException("No hay datos en la lista");
        }
        return new ResponseEntity<>(new ResponseDTO("satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> addToStart(Boy boy) throws ListaSeException{
        listBoys.addToStartDe(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño Adicionado", true, null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> deleteBoyDe(String id) throws ListaSeException {
        listBoys.deleteBoyDe(id);
        return new ResponseEntity<>(new ResponseDTO("Eliminado", true, null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> changeStartoEndDe() throws ListaSeException{
        listBoys.changeStartoEndDe();
        return new ResponseEntity<>(new ResponseDTO("Satisfacorio", true, null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> addBoyByPosDe(Boy boy,int pos) throws ListaSeException {
        listBoys.addToPositionDe(boy,pos);
        return new ResponseEntity<>(new ResponseDTO("Niño Adicionado", true, null), HttpStatus.OK);
    }
}
