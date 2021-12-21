package it.ntt.myschool.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.ntt.myschool.model.SchoolClass;
import it.ntt.myschool.repository.SchoolClassRepository;

@Controller
public class SchoolClassController {
    //ottenere il repository con dep.Injection
    private SchoolClassRepository schoolClassRepository;  
    public SchoolClassController(SchoolClassRepository schoolClassRepository){
        this.schoolClassRepository = schoolClassRepository;
    }

    //**************************************************************************************** */
    //http get request -solo se viene interrogato /classes
    @GetMapping("/classes") //path che vogliamo
    public String getClasses(Model model) { //MODEL view controller -- model ce lo da spring
        //model è un po' il nostro dizionario= chiave-valore
       model.addAttribute("schoolClasses", schoolClassRepository.findAll() ); //ottenere il repository con dep.Injection  //.findAll serve a noi per prendere tutti i dati della tabella
        return "classes";  //nome della pag html che usiamo come template
    }

    @GetMapping("/newclass")
    public String getNewClass(){
        return "newclass";
    }

    @PostMapping("/newclass")
    public String postNewClass(SchoolClass schoolClass){
        schoolClassRepository.save(schoolClass);
        return "redirect:/classes";
    }
 

}
