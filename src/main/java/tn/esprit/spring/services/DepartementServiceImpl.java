package tn.esprit.spring.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.repository.DepartementRepository;
@Service
public class DepartementServiceImpl implements IDepartementService {
	
	@Autowired
	DepartementRepository deptRepoistory;
	
	
	
public int ajouterDepartement(Departement departement) {
		
	deptRepoistory.save(departement);
		return departement.getId();
	}

public void mettreAjourNameDepartementId(String name, int departementId) {
	try{
		Departement departement = deptRepoistory.findById(departementId).orElse(null);
		
		departement.setName(name);
		deptRepoistory.save(departement);
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	
	

}


@Override
public void deleteDepartementById(int departementId) {
	
	
	deptRepoistory.deleteById(departementId);
	
}

@Override
public int getNombreDepartementJPQL() {
	
	return deptRepoistory.countdept();
}

@Override
public List<String> getAllDepartementNamesJPQL() {
	
	return deptRepoistory.departementeNames();
}

@Override
public List<Departement> getAllDepartements() {

	return (List<Departement>) deptRepoistory.findAll();
}

}
