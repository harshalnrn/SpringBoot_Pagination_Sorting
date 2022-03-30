package main.repository;

import main.entities.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationRepo extends PagingAndSortingRepository<Country, Long> {
}
