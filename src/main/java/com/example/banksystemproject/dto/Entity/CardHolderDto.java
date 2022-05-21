package com.example.banksystemproject.dto.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card_holder")
public class CardHolderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Column(name = "age", nullable = false)
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address", nullable = false,
            foreignKey = @ForeignKey(name = "address_card_holder_fk"))
    private AddressDto address;

    @OneToMany(mappedBy = "cardHolder",cascade = CascadeType.PERSIST)
    private List<AccountDto> accountList=new ArrayList<>();

    @OneToMany(mappedBy = "cardHolder",cascade = CascadeType.PERSIST)
    private List<CardDto> cardList=new ArrayList<>();
}
