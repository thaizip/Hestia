package prjIntegrador.hestia.service;

import org.springframework.http.ResponseEntity;
import prjIntegrador.hestia.model.Person;
import prjIntegrador.hestia.payload.PersonDTO;

import java.util.List;

public interface PersonService {

    public List<Person> FindAllPersons();

    public PersonDTO getPersonById(int personId);

    public PersonDTO createPerson(PersonDTO personDTO);

    public void deletePersonById(int personId);

    public PersonDTO updatePerson(int personId,PersonDTO personDTO);




}