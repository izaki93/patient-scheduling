package com.jpa.springdata.patientscheduling.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Insurance {

    private String providerName;
    private Double copay;
}
