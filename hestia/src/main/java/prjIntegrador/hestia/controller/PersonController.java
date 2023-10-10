package prjIntegrador.hestia.controller;

import com.sun.jdi.PrimitiveValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import prjIntegrador.hestia.model.Person;
import prjIntegrador.hestia.payload.PersonDTO;
import prjIntegrador.hestia.repository.PersonRepository;
import prjIntegrador.hestia.service.PersonServiceIMPL;

import java.util.List;

@RestController
public class PersonController {

    private PersonServiceIMPL personServiceIMPL;

    @Autowired
    public PersonController(PersonServiceIMPL personServiceIMPL) {
        this.personServiceIMPL = personServiceIMPL;
    }

    public List<Person> FindAllPersons(){
        return null;
    }

    public PersonDTO getPersonById(int personId){
        return null;
    }

    public PersonDTO createPerson(PersonDTO personDTO){
        return null;
    }

    public Object deletePersonById(int personId){
        return null;
    }

    public PersonDTO updatePerson(int personId,PersonDTO personDTO){
        return null;
    }



}