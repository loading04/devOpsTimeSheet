package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@Controller
public class IControllerDepartementImpl {

	@Autowired
	IDepartementService idepartementservice;
	
	public int ajouterDepartement(Departement departement)
	{
		idepartementservice.ajouterDepartement(departement);
		return departement.getId();
	}
	
	public void mettreAjourNameDepartementId(String name, int departementId)
	{
		idepartementservice.mettreAjourNameDepartementId(name, departementId);
	}
	
	public void deleteDepartementById(int departementId)
	{
		idepartementservice.deleteDepartementById(departementId);
	}
	
	public int getNombreDepartementJPQL()
	{
		return idepartementservice.getNombreDepartementJPQL();
	}
	
	public List<String> getAllDepartementNamesJPQL()
	{
		return idepartementservice.getAllDepartementNamesJPQL();
	}
	
	public List<Departement> getAllDepartements()
	{
		return idepartementservice.getAllDepartements();
	}
	
}
