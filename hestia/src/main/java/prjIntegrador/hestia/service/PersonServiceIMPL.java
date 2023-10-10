package prjIntegrador.hestia.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjIntegrador.hestia.model.Person;
import prjIntegrador.hestia.payload.PersonDTO;
import prjIntegrador.hestia.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceIMPL implements PersonService {

    private PersonRepository personRepository;

    private ModelMapper mapper;

    @Autowired
    public PersonServiceIMPL(PersonRepository personRepository, ModelMapper mapper) {
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Person> FindAllPersons() {
        return null;
    }

    @Override
    public PersonDTO getPersonById(int personId) {
        Optional<Person> person = personRepository.findById(personId);

        if (person.isPresent()){
            return mapper.map(person, PersonDTO.class);
        }else {
            throw new RuntimeException().
        }
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = new Person();




        personRepository.save(person);


        return null;
    }

    @Override
    public void deletePersonById(int personId) {

    }

    @Override
    public PersonDTO updatePerson(int personId, PersonDTO personDTO) {
        return null;
    }

    public Person personT(PersonDTO personDTO) {
        // Use a instância existente de ModelMapper
        return mapper.map(personDTO, Person.class);
    }





}