package prjIntegrador.hestia.service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjIntegrador.hestia.entity.Person;
import prjIntegrador.hestia.payload.PersonDTO;
import prjIntegrador.hestia.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonUserServiceIMPL implements PersonUserService {

    private PersonRepository personRepository;

    private ModelMapper mapper;

    @Autowired
    public PersonUserServiceIMPL(PersonRepository personRepository, ModelMapper mapper) {
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Person> FindAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public PersonDTO getPersonById(int personId) {
        Optional<Person> personOptional = personRepository.findById(personId);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            return mapper.map(person, PersonDTO.class);
        } else {
            throw new EntityNotFoundException("Person with ID " + personId + " not found");
        }
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setPersonImg(personDTO.getPersonImg());
        person.setEmail(personDTO.getEmail());
        person.setPassword(personDTO.getPassword());
        personRepository.save(person);
        return mapper.map(person, PersonDTO.class);
    }

    @Override
    public PersonDTO updatePerson(int personId, PersonDTO personDTO) {
        Optional<Person> personOptional = personRepository.findById(personId);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            mapper.map(personDTO, person);
            personRepository.save(person);
            return mapper.map(person, PersonDTO.class);
        } else {
            throw new RuntimeException("Person not found");
        }
    }


    @Override
    public void deletePersonById(int personId) {
        personRepository.deleteById(personId);
    }

    public Person personT(PersonDTO personDTO) {
        return mapper.map(personDTO, Person.class);
    }

}
