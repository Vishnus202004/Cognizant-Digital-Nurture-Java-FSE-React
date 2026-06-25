package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Custom Finder: Find countries where the name contains a specific string (e.g., Like '%ou%')
    List<Country> findByNameContaining(String namePattern);

    // Custom Finder: Find countries where the name starts with a specific letter, ordered alphabetically
    List<Country> findByNameStartingWithOrderByNameAsc(String prefix);
}