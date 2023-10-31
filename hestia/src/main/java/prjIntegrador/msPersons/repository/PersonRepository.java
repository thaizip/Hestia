package prjIntegrador.msPersons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prjIntegrador.msPersons.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}