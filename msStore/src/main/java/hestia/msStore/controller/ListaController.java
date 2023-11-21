package hestia.msStore.controller;

import hestia.msStore.payload.ListaDto;
import hestia.msStore.service.ListaServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lista")
public class ListaController {

    @Autowired
    private ListaServiceIMPL serviceIMPL;

    @PostMapping
    public ResponseEntity<ListaDto> createLista(@RequestBody ListaDto listaDto){
        return new ResponseEntity<>(serviceIMPL.createLista(listaDto), HttpStatus.CREATED);
    }




}