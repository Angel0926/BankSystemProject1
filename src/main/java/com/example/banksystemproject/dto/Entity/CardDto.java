package com.example.banksystemproject.dto.Entity;

import com.example.banksystemproject.domain.enumType.BalanceType;
import com.example.banksystemproject.domain.enumType.CardType;
import com.example.banksystemproject.domain.enumType.StatusType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "card")
public class CardDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type", nullable = false)
    private CardType cardType;

    @Column(name = "balance_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BalanceType balanceType;

    @Column(name = "balance", nullable = false,columnDefinition = "decimal", precision = 20, scale = 2)
    private String balance;


    @Column(name = "card_number", nullable = false,length = 16)
    private String cardNumber;

    @DateTimeFormat
    @Column(name = "expiration_date", nullable = false)
    private LocalDate ExpirationDate;

    @Column(name = "cvc", nullable = false,length = 3)
    private String cvc;

    @Column(name = "pin", nullable = false,length = 4)
    private String PIN;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusType status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_issuer_branch", nullable = false,
            foreignKey = @ForeignKey(name = "issuer_branch_card_fk"))
    public IssuerBranchDto issuerBranch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_card_holder", nullable = false,
            foreignKey = @ForeignKey(name = "card_holder_card_fk"))
    private CardHolderDto cardHolder;

}
