package com.thesnoozingturtle.moneymanagerrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150)
    private String description;
    private String type;

    @Column(nullable = false)
    private String amount;
    private String imageName;

    @Column(nullable = false)
    private LocalDateTime dateAdded;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
