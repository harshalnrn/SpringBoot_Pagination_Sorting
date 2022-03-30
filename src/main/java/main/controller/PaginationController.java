package main.controller;

import main.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class PaginationController {

    @Autowired
private CountryService countryService;
    @GetMapping(value = "/page/{pageNo}/{size}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Country>> getPaginatedCountries(@PathVariable("pageNo") int pageNo, @PathVariable("size") int size){
        return new ResponseEntity<>(countryService.findByIdPaginated(pageNo,size), HttpStatus.OK);
    }
}
