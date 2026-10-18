package com.example.productcatelogservice.TableInheritenceExample.TablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

//@Entity(name = "tpc_ta")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ta extends User{
    private String helpRequest;
}
