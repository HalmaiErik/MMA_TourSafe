package com.softwaredesign.mmatoursafe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mmamatch")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idfighter1")
    private Fighter fighter1;
    @ManyToOne
    @JoinColumn(name = "idfighter2")
    private Fighter fighter2;
    @ManyToOne
    @JoinColumn(name = "idtournament")
    private Tournament tournament;
    private LocalDateTime dateTime;
}
