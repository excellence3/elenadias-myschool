package it.ntt.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.ntt.myschool.model.Student;
import it.ntt.myschool.repository.SchoolClassRepository;
import it.ntt.myschool.repository.StudentRepository;


@Controller
public class StudentController {
     //ottenere il repository con dep.Injection
     private StudentRepository studentRepository ;
     private SchoolClassRepository schoolClassRepository;

     public StudentController(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository ){
         this. studentRepository =  studentRepository;
         this.schoolClassRepository = schoolClassRepository;
     }

 //********************************************************************************
     //http get request -solo se viene interrogato /classes
     @GetMapping("/students") //1- path che vogliamo
     public String getClasses(Model model) { //MODEL view controller -- model ce lo da spring
         //model è un po' il nostro dizionario= chiave-valore

        model.addAttribute("students", studentRepository.findAll() ); //2 - ottenere il repository con dep.Injection  //.findAll serve a noi per prendere tutti i dati della tabella

         return "students";  //3 - nome della pag html che usiamo come template
     }

     @GetMapping("/students/{name}")
     public String getStudentByClass(Model model, @PathVariable String name){
        //Cosi mi ritorna una lista di una certa sezione
        model.addAttribute("students", studentRepository.findStudentByClass(name) );
        return "students";
     }

     @GetMapping("/newstudent") //nel path newstudent fa la chiamata get
     public String getNewStudent(Model model){
         model.addAttribute("schoolclasses", schoolClassRepository.findAll()); //di tutte le classi dell'istituto presenti in schoolClassRepository
         return "newstudent"; 
     }


     @PostMapping("newstudent") //metodo post che mi permette di....
     public String postNewStudent(Student student, @RequestParam String schoolclassname){
         //aggiungere studenti nuovi nella lista dei studenti
        student.setSchoolClass(schoolClassRepository.findSchoolClassBySection(schoolclassname));
        //e li salva nel db : studentRepository
        studentRepository.save(student);
        return "redirect:/students";
     }
}
