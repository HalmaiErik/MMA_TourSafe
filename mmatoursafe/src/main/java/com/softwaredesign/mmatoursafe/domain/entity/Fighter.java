package com.softwaredesign.mmatoursafe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fighter")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private WeightClass weightClass;
    @ManyToOne
    @JoinColumn(name = "idtournament")
    private Tournament tournament;
    @OneToMany(mappedBy = "fighter")
    private List<CovidTest> tests;
}
