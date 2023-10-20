package prjIntegrador.hestia.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prjIntegrador.hestia.entity.PersonBUSS;
import prjIntegrador.hestia.payload.PersonBussDTO;
import prjIntegrador.hestia.service.PersonBussServiceIMPL;

import java.util.List;

@RestController
@RequestMapping("/personBus")
public class PersonBussController {

    private PersonBussServiceIMPL serviceIMP;

    @Autowired
    public PersonBussController(PersonBussServiceIMPL serviceIMP) {
        this.serviceIMP = serviceIMP;
    }

    @GetMapping
    public List<PersonBUSS> FindAllPersonsBus(){
       return serviceIMP.FindAllPersonsBus();
    }

    @PostMapping
    public ResponseEntity<String> createPersonBus(@Valid @RequestBody PersonBussDTO personBussDTO) {
        serviceIMP.createPersonBus(personBussDTO);
        return new ResponseEntity<>("Person created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{personBussId}")
    public PersonBussDTO getPersonBusById(@PathVariable("personBussId") int personBussId){
        return serviceIMP.getPersonBusById(personBussId);
    }

    @PutMapping("/{personBussId}")
    public PersonBussDTO updatePersonBus(@PathVariable("personBussId") int personBussId, @RequestBody PersonBussDTO personBussDTO){
        return serviceIMP.updatePersonBus(personBussId, personBussDTO);
    }

    @DeleteMapping("/{personBussId}")
    public ResponseEntity<String> deletePersonBusById(@PathVariable("personBussId") int personBussId){
        serviceIMP.deletePersonBusById(personBussId);
        return new ResponseEntity<>("Person deleted Successfully", HttpStatus.OK);
    }
}