package com.example.productcatelogservice.TableInheritenceExample.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name = "joined_mentor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Mentor extends User {
    private String lastCompany;
}
