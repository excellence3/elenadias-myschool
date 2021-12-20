package it.ntt.myschool.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.ntt.myschool.model.SchoolClass;
import it.ntt.myschool.model.Student;
import it.ntt.myschool.repository.SchoolClassRepository;
import it.ntt.myschool.repository.StudentRepository;

// !!!! IMPORTANTE ANNOTATION COMPONENT
@Component //questa classe java ma la devi leggere a bean 
public class BootstrapData implements CommandLineRunner{

    @Autowired //dichiara un costruttore
    private SchoolClassRepository schoolClassRepository;
    @Autowired
    private StudentRepository studentRepository;
  

    @Override
    public void run(String... args) throws Exception {
        
        SchoolClass class1 = new SchoolClass("1A");
        SchoolClass class2 = new SchoolClass("1B");
        SchoolClass class3 = new SchoolClass("1C");

        Student student1 = new Student("Bugs", "Bunny", 10, class1);
        Student student2 = new Student("Duffy", "Duck", 10, class1);
        Student student3 = new Student("Gatto", "Silvestr", 10, class2);
        Student student4 = new Student("Speedy", "Gonzales", 10, class2);
        Student student5 = new Student("Marco", "Rossi", 10, class3);
        Student student6 = new Student("Mario", "Bianchi", 10, class3);
        
        schoolClassRepository.save(class1);
        schoolClassRepository.save(class2);
        schoolClassRepository.save(class3);
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
    }
    
}
