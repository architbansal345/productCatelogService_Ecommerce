package com.example.productcatelogservice.TableInheritenceExample.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.UUID;

@Entity(name = "joined_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private UUID id;
    private String name;
}
