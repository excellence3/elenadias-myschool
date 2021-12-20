package it.ntt.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.ntt.myschool.repository.StudentRepository;


@Controller
public class StudentController {
     //ottenere il repository con dep.Injection
     private StudentRepository studentRepository ;  

     public StudentController(StudentRepository studentRepository){
         this. studentRepository =  studentRepository;
     }
 
     //http get request -solo se viene interrogato /classes
     @GetMapping("/students") //1- path che vogliamo
     public String getStudents(Model model) { //MODEL view controller -- model ce lo da spring
         //model è un po' il nostro dizionario= chiave-valore

        model.addAttribute("students", studentRepository.findAll() ); //2 - ottenere il repository con dep.Injection  //.findAll serve a noi per prendere tutti i dati della tabella

         return "students";  //3 - nome della pag html che usiamo come template
     }
}
