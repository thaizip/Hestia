package prjIntegrador.hestia.service;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import prjIntegrador.hestia.entity.PersonBUSS;
import prjIntegrador.hestia.payload.PersonBussDTO;
import prjIntegrador.hestia.repository.PersonBussRepository;
import prjIntegrador.hestia.util.ValitedCNPJ;

import java.util.List;
import java.util.Optional;

@Service
public class PersonBussServiceIMPL implements PersonBussService{

    private PersonBussRepository bussRepository;
    private ModelMapper mapper;

    @Autowired
    public PersonBussServiceIMPL(PersonBussRepository bussRepository, ModelMapper mapper) {
        this.bussRepository = bussRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonBUSS> FindAllPersonsBus() {
        return bussRepository.findAll();
    }

    @Override
    public PersonBussDTO getPersonBusById(int personBussId) {
        Optional<PersonBUSS> personOptional = bussRepository.findById(personBussId);

        if (personOptional.isPresent()) {
            PersonBUSS personBUSS = personOptional.get();
            return mapper.map(personBUSS, PersonBussDTO.class);
        } else {
            throw new EntityNotFoundException("Person with ID " + personBussId + " not found");
        }
    }

    @Override
    public ResponseEntity<PersonBussDTO> createPersonBus(PersonBussDTO personBussDTO){
        String cnpj = personBussDTO.getCNPJ();

        if (!ValitedCNPJ.isCNPJ(cnpj)) {
            throw new EntityNotFoundException("O CNPJ não é válido.");
        }

        PersonBUSS personBUSS = new PersonBUSS();
        personBUSS.setEndereco(personBussDTO.getEndereco());
        personBUSS.setNumero(personBussDTO.getNumero());
        personBUSS.setBairro(personBussDTO.getBairro());
        personBUSS.setCidade(personBussDTO.getCidade());
        personBUSS.setName(personBussDTO.getName());
        personBUSS.setPersonImg(personBussDTO.getPersonImg());
        personBUSS.setEmail(personBussDTO.getEmail());
        personBUSS.setPassword(personBussDTO.getPassword());
        personBUSS.setCNPJ(cnpj);
        personBUSS.setUF(personBussDTO.getUF());
        bussRepository.save(personBUSS);
        return new ResponseEntity<>(mapper.map(personBUSS, PersonBussDTO.class), HttpStatus.CREATED);
    }


    @Override
    public PersonBussDTO updatePersonBus(int personBussId, PersonBussDTO personBussDTO) {
        Optional<PersonBUSS> personOptional = bussRepository.findById(personBussId);

        if (personOptional.isPresent()) {
            PersonBUSS personBUSS = personOptional.get();
            mapper.map(personBUSS, personBUSS);
            bussRepository.save(personBUSS);
            return mapper.map(personBUSS, PersonBussDTO.class);
        } else {
            throw new RuntimeException("Person not found");
        }
    }

    @Override
    public void deletePersonBusById(int personBussId) {
        bussRepository.deleteById(personBussId);
    }

    public PersonBUSS personB(PersonBussDTO personBussDTO) {
        return mapper.map(personBussDTO, PersonBUSS.class);
    }

}
