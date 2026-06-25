package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CountryNotFoundException("Country not found with code: " + countryCode);
    }

    // Hands-on 8: Save a new Country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    // Hands-on 9: Update an existing country's name
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isPresent()) {
            Country country = result.get();
            country.setName(name);
            countryRepository.save(country); // Overwrites existing state
        } else {
            throw new CountryNotFoundException("Country not found for update with code: " + code);
        }
    }

    // Hands-on 10: Delete a country by its primary key
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    @Transactional(readOnly = true)
    public List<Country> findCountriesMatching(String pattern) {
        return countryRepository.findByNameContaining(pattern);
    }

    @Transactional(readOnly = true)
    public List<Country> findCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWithOrderByNameAsc(prefix);
    }
}