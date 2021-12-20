package it.ntt.myschool.repository;

import org.springframework.data.repository.CrudRepository;
import it.ntt.myschool.model.SchoolClass;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> {
    
}
