package prjIntegrador.hestia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prjIntegrador.hestia.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}