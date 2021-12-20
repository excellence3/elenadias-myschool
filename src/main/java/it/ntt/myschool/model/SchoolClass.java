package it.ntt.myschool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    //private Integer number; da eliminare perchè abbiamo creato List<student> students

    @OneToMany(mappedBy = "schoolClass") //entità forte
    private List<Student> students = new ArrayList<Student>();

    //COstruttori
    public SchoolClass() {};

    public SchoolClass( String name) {
        this.name = name;
    }
    public SchoolClass( String name,  List<Student> students) {
        this.name = name;
        //this.number = number;
        this.students = students;
    }

    
    //GET SET
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getNumber() {
        return students.size();
    }
   
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    
    
    
}
