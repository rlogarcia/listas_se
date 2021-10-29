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

@RestController
@RequestMapping(path="/boys")
public class BoysController {
    @Autowired
    private ListeSeService listeSeService;
    @Autowired
    private ListDeService listDeServiceDe;

    @PostMapping
    public ResponseEntity<ResponseDTO> addBoy(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listeSeService.addBoy(boy);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> listBoys() throws ListaSeException {
        return listeSeService.listBoys();
    }

    @GetMapping(path = "/invert")
    public ResponseEntity<ResponseDTO> invertList() throws ListaSeException {
        return listeSeService.invertList();
    }

    @PostMapping(path = "/addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStart(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listeSeService.addToStart(boy);
    }

    @PostMapping(path = "/addboys")
    public ResponseEntity<ResponseDTO> addBoys(@RequestBody @Valid List<Boy> boys) throws ListaSeException {
        for (Boy boy : boys) {
            listeSeService.addBoy(boy);
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Satisfactorio", listeSeService.listBoys(), null), HttpStatus.OK);
    }

    @GetMapping(path = "/getcount")
    public ResponseEntity<ResponseDTO> getCount() {
        return listeSeService.getCount();
    }

    @GetMapping(path = "/count")
    public ResponseEntity<ResponseDTO> count() {
        return listeSeService.getCount();
    }

    @GetMapping(path = "/free")
    public ResponseEntity<ResponseDTO> listBoysFree() throws ListaSeException {
        return listeSeService.listBoysFree();
    }

    @GetMapping(path = "/changextremes")
    public ResponseEntity<ResponseDTO> changeStartoEnd() throws ListaSeException {
        return listeSeService.changeStartoEnd();
    }

    @GetMapping(path = "/deleteboy/{id}")
    public ResponseEntity<ResponseDTO> deleteBoy(@PathVariable String id) throws ListaSeException {
        return listeSeService.deleteBoy(id);
    }

    @PostMapping(path = "/addnorepeat")
    public ResponseEntity<ResponseDTO> addNoRepeat(@RequestBody Boy boy) {
        return listeSeService.addNoRepeat(boy);
    }

    /*@GetMapping(path = "/list/{typesex}")
    public ResponseEntity<ResponseDTO>typeSex(@PathVariable String typesex){return listeSeService.listTypeSex(typesex);}*/
    @GetMapping(path = "/listsex/{typeSex}")
    public ResponseEntity<ResponseDTO> listForType(@PathVariable String typeSex) {
        return listeSeService.forGenderList(typeSex);
    }

    @GetMapping(path = "/count/girl")
    public ResponseEntity<ResponseDTO> countGirl() {
        return listeSeService.countGirls();
    }

    @GetMapping(path = "/count/boy")
    public ResponseEntity<ResponseDTO> countBoys() {
        return listeSeService.countBoys();
    }

    @PostMapping(path = "/addtopositon/{pos}")
    public ResponseEntity<ResponseDTO> addBoyToPosition(@PathVariable int pos, @RequestBody Boy boy) throws ListaSeException {
        return listeSeService.addBoyByPos(boy, pos);
    }

    @GetMapping(path = "/variant")
    public ResponseEntity<ResponseDTO> variantList() throws ListaSeException {
        return listeSeService.variantList();
    }

    @GetMapping(path = "/boysbylocation")
    public ResponseEntity<ResponseDTO> boysbylocation() {
        return listeSeService.getBoyByLocation();
    }

    @GetMapping(path = "/listforageandmu/{age}/{municipio}")
    public ResponseEntity<ResponseDTO> listForAgeAndMu(int age, String municipio) throws ListaSeException {
        return listeSeService.listForAgeAndMu(age, municipio);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping(path = "/addtostartde")
    public ResponseEntity<ResponseDTO> addBoyToStartDe(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listDeServiceDe.addToStart(boy);
    }
    @GetMapping(path = "/listde")
    public ResponseEntity<ResponseDTO> listBoysDe() throws ListaSeException {
        return listDeServiceDe.listBoysDe();
    }
    @PostMapping(path = "/addde")
    public ResponseEntity<ResponseDTO> addDe(@RequestBody @Valid Boy boy) throws ListaSeException {
        return listDeServiceDe.addBoy(boy);
    }
    @GetMapping(path = "/freede")
    public ResponseEntity<ResponseDTO> listBoysFreeDe() throws ListaSeException {
        return listDeServiceDe.listBoysFreeDe();
    }
    @GetMapping(path = "/deleteboyde/{id}")
    public ResponseEntity<ResponseDTO> deleteBoyDe(@PathVariable String id) throws ListaSeException {
        return listDeServiceDe.deleteBoyDe(id);
    }
    @GetMapping(path = "/changextremesde")
    public ResponseEntity<ResponseDTO> changeStartoEndDe() throws ListaSeException {
        return listDeServiceDe.changeStartoEndDe();
    }
    @PostMapping(path = "/addtopositonde/{pos}")
    public ResponseEntity<ResponseDTO> addBoyToPositionDe(@PathVariable int pos, @RequestBody Boy boy) throws ListaSeException {
        return listDeServiceDe.addBoyByPosDe(boy, pos);
    }
}
