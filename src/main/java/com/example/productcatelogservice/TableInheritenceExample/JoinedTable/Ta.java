package com.example.productcatelogservice.TableInheritenceExample.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name = "joined_ta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ta extends User {
    private String helpRequest;
}
