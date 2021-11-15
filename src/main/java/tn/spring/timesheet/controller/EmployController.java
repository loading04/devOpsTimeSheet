package tn.spring.timesheet.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.timesheet.Mapper;
import tn.spring.timesheet.entities.Employe;
import tn.spring.timesheet.entities.EmployeDTO;
import tn.spring.timesheet.services.IEmployeService;
import java.util.List;

@AllArgsConstructor
@RestController
public class EmployController {

	@Autowired
	IEmployeService iEmployeservice;
    private Mapper mapper;

    //ajouter employe
    @PostMapping("/addEmploye")
    @ResponseBody
    public Employe addEmploye(@RequestBody EmployeDTO employeDTO){
        Employe employe = mapper.toEmploye(employeDTO);
        return iEmployeservice.addEmploye(employe);
    }
    // http://localhost:8099/SpringMVC/servlet/getAllEmploye
    //get all employe
    @GetMapping(value="/getAllEmploye")
    @ResponseBody
    public List<Employe> getAllEmploye(){
        return iEmployeservice.getAllEmploye();
    }

    //get all namesemploye
    @GetMapping(value = "/getAllEmployeNames")
    @ResponseBody
    public List<String> getAllEmployeNames() {
        return  iEmployeservice.getNamesOfEmploye();
    }

    //get nombre des employe
    @GetMapping(value = "/getNombreEmploye")
    @ResponseBody
    public int getNombreEmploye() {
        return  iEmployeservice.countEmploye();
    }
    //get employe by email
    @GetMapping(value = "/getEmployebymail/{email}")
    @ResponseBody
    public Employe getAllEntrepriseByRaisonSocial(@PathVariable("email") String email) {
        return  iEmployeservice.getEmployeByEmail(email);
    }

    //edit employe email by id
    @PutMapping(value = "/editEmployeNameById/{id}")
    @ResponseBody
    public void mettreAjourEmailByEmployeId(@PathVariable("id") int id,@RequestBody String email) {
        iEmployeservice.mettreAjourEmailByEmployeId(email,id);
    }

    //delete all employe
    @DeleteMapping("/deleteAllEmploye")
    public void deleteAllEmploye() {
        iEmployeservice.deleteAll();
    }

}
