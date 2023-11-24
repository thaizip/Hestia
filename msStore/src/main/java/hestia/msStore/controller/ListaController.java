package hestia.msStore.controller;

import hestia.msStore.payload.ListaDto;
import hestia.msStore.service.ListaServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaController {

    @Autowired
    private ListaServiceIMPL serviceIMPL;


    @GetMapping
    public ResponseEntity<List<ListaDto>> findAllListas() {
        return new ResponseEntity<>(serviceIMPL.findAllListas(), HttpStatus.OK);
    }

    @GetMapping("/{listaName}")
    public ResponseEntity<List<ListaDto>> findAllListaByName(@PathVariable(value = "listaName") String listaName, @RequestBody(required = false) ListaDto listaDto) {
        return new ResponseEntity<>(serviceIMPL.findAllListaByName(listaName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ListaDto> createLista(@RequestBody ListaDto listaDto){
        return new ResponseEntity<>(serviceIMPL.createLista(listaDto), HttpStatus.CREATED);
    }

    @PutMapping("/{listaId}")
    public ResponseEntity<ListaDto> updateLista(@PathVariable(value = "listaId") int listaId, @RequestBody ListaDto listaDto){
        return new ResponseEntity<>(serviceIMPL.updateLista(listaId, listaDto), HttpStatus.OK);
    }

}