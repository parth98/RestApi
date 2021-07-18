package com.example.parth.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "role_id", updatable = false)
    private UUID uuid;

    private String name;

    public Role() {
    }

    public Role(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUserId() {
        return uuid;
    }

    public void setUserId(UUID userId) {
        this.uuid = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
