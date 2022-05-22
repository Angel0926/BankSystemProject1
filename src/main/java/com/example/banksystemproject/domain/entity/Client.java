package com.example.banksystemproject.domain.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(mappedBy = "client",cascade = CascadeType.PERSIST)
    private Set<Account> accounts;

    public Client(Long id, String firstName, String lastName, LocalDate dateOfBirth, Address address, Set<Account> accountList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.accounts = accountList;
    }

    public Client(String firstName, String lastName, LocalDate dateOfBirth, Address address, Set<Account> accountList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.accounts = accountList;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Account> getAccountList() {
        return accounts;
    }

    public void setAccountList(Set<Account> accountList) {
        this.accounts = accountList;
    }
}
