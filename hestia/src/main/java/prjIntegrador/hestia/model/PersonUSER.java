package prjIntegrador.hestia.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class PersonUSER {


    private int personUserId;

    @OneToOne
    @JoinColumn(name = "codPerson")
    private Person codPerson;



}