package prjIntegrador.hestia.service;

import prjIntegrador.hestia.entity.Person;
import prjIntegrador.hestia.payload.PersonDTO;

import java.util.List;

public interface PersonUserService {

    public List<Person> FindAllPersons();

    public PersonDTO getPersonById(int personId);

    public PersonDTO createPerson(PersonDTO personDTO);

    public PersonDTO updatePerson(int personId, PersonDTO personDTO);

    public void deletePersonById(int personId);

}