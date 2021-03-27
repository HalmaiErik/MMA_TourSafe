package com.softwaredesign.mmatoursafe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "covidtest")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CovidTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idfighter")
    private Fighter fighter;
    @CreationTimestamp
    private Timestamp date;
    private Boolean result;
}
