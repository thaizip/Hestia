package prjIntegrador.msPersons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prjIntegrador.msPersons.entity.PersonBUSS;

public interface PersonBussRepository extends JpaRepository<PersonBUSS, Integer> {
}
