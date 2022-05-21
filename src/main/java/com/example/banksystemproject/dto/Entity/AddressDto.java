package com.example.banksystemproject.dto.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class AddressDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name ="street", nullable = false,length = 30)
    private String street;
    @Column(name = "city",nullable = false,length = 30)
    private  String city;
    @Column(name = "country",nullable = false,length = 30)
    private String country;

    @OneToMany(mappedBy = "address",cascade = CascadeType.PERSIST)
    private List<CardHolderDto> cardHolderList=new ArrayList<>();

}
