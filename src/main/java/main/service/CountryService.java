package main.service;

import main.entities.Country;

import java.util.List;


public interface CountryService {

    List<Country> findByIdPaginated(int pageNumber, int size);
}
