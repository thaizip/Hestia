package prjIntegrador.msPersons.service;

import org.springframework.http.ResponseEntity;
import prjIntegrador.msPersons.entity.PersonBUSS;
import prjIntegrador.msPersons.payload.PersonBussDTO;

import java.util.List;

public interface PersonBussService {

    public List<PersonBUSS> FindAllPersonsBus();

    public PersonBussDTO getPersonBusById(int personBussId);

    public ResponseEntity<PersonBussDTO> createPersonBus(PersonBussDTO personBussDTO);

    public PersonBussDTO updatePersonBus(int personBussId, PersonBussDTO personBussDTO);

    public void deletePersonBusById(int personBussId);

}