package com.softwaredesign.mmatoursafe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tournament")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "tournament")
    private List<Fighter> fighters;
    @OneToMany(mappedBy = "tournament")
    private List<Match> matches;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    @Enumerated(EnumType.STRING)
    private Schedule schedule;
}
