package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;


public interface IDepartementService {

	
	public int ajouterDepartement(Departement departement);
	public void mettreAjourNameDepartementId(String name, int departementId);
	public void deleteDepartementById(int departementId);
	public int getNombreDepartementJPQL();
	public List<String> getAllDepartementNamesJPQL();
	public List<Departement> getAllDepartements();
}
