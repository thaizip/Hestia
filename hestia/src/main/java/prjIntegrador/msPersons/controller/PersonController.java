package prjIntegrador.msPersons.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prjIntegrador.msPersons.entity.Person;
import prjIntegrador.msPersons.payload.PersonDTO;
import prjIntegrador.msPersons.service.PersonUserServiceIMPL;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonUserServiceIMPL personUserServiceIMPL;

    @Autowired
    public PersonController(PersonUserServiceIMPL personUserServiceIMPL) {
        this.personUserServiceIMPL = personUserServiceIMPL;
    }

    @GetMapping
    public List<Person> FindAllPersons(){
        return personUserServiceIMPL.FindAllPersons();
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personUserServiceIMPL.createPerson(personDTO);
    }

    @GetMapping("/{personId}")
    public PersonDTO getPersonById(@PathVariable("personId") int personId){
        return personUserServiceIMPL.getPersonById(personId);
    }

    @PutMapping("/{personId}")
    public PersonDTO updatePerson(@PathVariable("personId") int personId, @RequestBody PersonDTO personDTO) {
        return personUserServiceIMPL.updatePerson(personId, personDTO);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePersonById(@PathVariable("personId") int personId){
        personUserServiceIMPL.deletePersonById(personId);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }


}