package com.example.banksystemproject.domain.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "IBAN", nullable = false, unique = true, length = 30)
    private String IBAN;
    @Column(name = "account_balance", nullable = false, length = 30)
    private String accountBalance;
    @Embedded
    private Issuer issuer = new Issuer();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card_holder", nullable = false,
            foreignKey = @ForeignKey(name = "card_holder_account_fk"))
    private CardHolder cardHolder;


}