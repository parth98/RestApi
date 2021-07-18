package com.example.parth.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", updatable = false)
    private UUID uuid;

    @Column(name = "fullname" , nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(){
    }

    public User(UUID uuid, String fullName, String username, String password, boolean enabled, Set<Role> roles) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}



 /*   @Entity(name="User")*/
/*@Table(name = "registration" ,  uniqueConstraints = {
        @UniqueConstraint(
                name="user_email_unique",
                columnNames="email"
        )}
        )*/
/*@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private UUID userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String firstName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String lastName;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String gender;

    @Column(unique = true , nullable = false)
    private  String username;

    @Column(nullable = false)
    private  String password;


    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;

*//*    @Column(
            //name = "email",
            unique = true,
            nullable = false
    )
    private  String email;*//*

    public User() {
    }

    public User(UUID userId, String firstName, String lastName, String gender, String username, String password, List<Role> roles) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}*/
