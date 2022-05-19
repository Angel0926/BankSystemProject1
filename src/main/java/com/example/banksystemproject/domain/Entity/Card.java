package com.example.banksystemproject.domain.Entity;

import com.example.banksystemproject.domain.enumType.BalanceType;
import com.example.banksystemproject.domain.enumType.CardType;
import com.example.banksystemproject.domain.enumType.StatusType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_type", nullable = false)
    private CardType cardType;
    @Column(name = "balance_type", nullable = false)
    private BalanceType balanceType;
    @Column(name = "balance", nullable = false)
    private String balance;
    @Column(name = "card_number", nullable = false,length = 16)
    private String cardNumber;
    @Column(name = "expiration_type", nullable = false)
    private LocalDate ExpirationDate;
    @Column(name = "cvc", nullable = false,length = 3)
    private String cvc;
    @Column(name = "pin", nullable = false,length = 4)
    private String PIN;
    @Column(name = "status", nullable = false)
    private StatusType status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_issuer_branch", nullable = false,
            foreignKey = @ForeignKey(name = "issuer_branch_card_fk"))
    public IssuerBranch issuerBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card_holder", nullable = false,
            foreignKey = @ForeignKey(name = "card_holder_card_fk"))
    private CardHolder cardHolder;

}
