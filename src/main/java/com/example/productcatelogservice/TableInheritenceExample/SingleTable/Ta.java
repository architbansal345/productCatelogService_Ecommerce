package com.example.productcatelogservice.TableInheritenceExample.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name = "s_ta")
@DiscriminatorValue(value = "TA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Ta extends User {
    private String helpRequest;
}
