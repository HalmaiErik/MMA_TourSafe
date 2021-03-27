package com.softwaredesign.mmatoursafe.persistence.repository;

import com.softwaredesign.mmatoursafe.domain.entity.CovidTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovidTestRepository extends JpaRepository<CovidTest, Long> {
    CovidTest findFirstByFighter_IdOrderByDateDesc(Long id);
}
