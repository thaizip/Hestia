package prjIntegrador.hestia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prjIntegrador.hestia.entity.PersonBUSS;

public interface PersonBussRepository extends JpaRepository<PersonBUSS, Integer> {
}
