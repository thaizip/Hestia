package prjIntegrador.hestia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prjIntegrador.hestia.model.Person;
import prjIntegrador.hestia.payload.PersonDTO;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
