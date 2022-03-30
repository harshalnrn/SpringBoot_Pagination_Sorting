package main.service.impl;

import main.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import main.repository.PaginationRepo;
import main.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {


    @Autowired
    private PaginationRepo repo;
    @Override
    public List<Country> findByIdPaginated(int pageNumber, int size) {
         // Spring data jpa caches and maps pages and their size dynamically, such that appropriate limit and offset can be applied for each paginated requests
        //create paging object
       Pageable pageable= PageRequest.of(pageNumber,size);
        //consume repository crud method by passing paging object
        Page<Country> countryPage=repo.findAll(pageable);
        //VIMP: note both limit and offset =size that is passed.
        return countryPage.getContent();
    }
}
