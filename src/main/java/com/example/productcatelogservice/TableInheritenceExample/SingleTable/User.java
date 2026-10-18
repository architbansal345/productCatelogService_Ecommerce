package com.example.productcatelogservice.TableInheritenceExample.SingleTable;

import jakarta.persistence.*;

import java.util.UUID;

//@Entity(name = "s_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type" , discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    private UUID id;
    private String name;
}
