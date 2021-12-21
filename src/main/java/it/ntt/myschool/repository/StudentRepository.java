package it.ntt.myschool.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.ntt.myschool.model.Student;

//questa interfaccia estende credurepository che ha tutte le cose per interrogare db
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.schoolClass.name = :name")
    public Collection<Student> findStudentByClass(@Param("name") String name);
    
}
