package com.example.productcatelogservice.TableInheritenceExample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name = "s_mentor")
@DiscriminatorValue(value = "Mentor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mentor extends User {
    private String lastCompany;
}
