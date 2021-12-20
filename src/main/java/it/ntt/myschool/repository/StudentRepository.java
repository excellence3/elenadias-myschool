package it.ntt.myschool.repository;

import org.springframework.data.repository.CrudRepository;
import it.ntt.myschool.model.Student;

//questa interfaccia estende credurepository che ha tutte le cose per interrogare db
public interface StudentRepository extends CrudRepository<Student, Long> {
    
}
