package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {
	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);
	//add an departement
	public int ajouterDepartement(Departement dep) {
		l.info("run add departement");
		
		
		deptRepoistory.save(dep);
		
		
		l.info("end the add");
		return dep.getId();
	}
	
	//add departement for an entreprise
		public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
			         try {
						
						l.debug("getting the id of departement");
						Optional<Departement> departementManaged=deptRepoistory.findById(depId);
							l.debug("geeting the id of entreprise");
							Optional<Entreprise> entrpriseManaged=entrepriseRepoistory.findById(entrepriseId);	
			        	 if(departementManaged.isPresent() && entrpriseManaged.isPresent()) {	
						
						l.debug("entreprise found with succes id  :"+entrpriseManaged.get().getId());
					
						Departement depManagedEntity = departementManaged.get();
						l.debug("add the department into entreprsie ");
						depManagedEntity.setEntreprise(entrpriseManaged.get());
					
						deptRepoistory.save(depManagedEntity);	
						l.debug("  entreprise added with succes id : "+depManagedEntity.getId());
					
							}
					}
					catch (Exception e) {
						l.error("error in affecterDepartement () :"+e);

					}      
		}
		//delete entrprise
		@Transactional
		public Departement desaffecterDepartementDuEntreprise (int depId , int entId){
			try {
				l.info("In desaffecterDepartementDuEntreprise :  ");
				Entreprise ent = entrepriseRepoistory.findById(entId).orElse(null);
				l.info("Entreprise found with succes");
				Departement depManagedEntity = deptRepoistory.findById(depId).orElse(null);
				l.info("depManagedEntity found with succes");
				if (depManagedEntity != null){
			  if (depManagedEntity.getEntreprise() == ent )
			    {
				
				depManagedEntity.setEntreprise(null);
				l.info("delete entreprise with succes ");
			    }
		
			    l.info("Out of desaffecterDepartementDuEntreprise  ");
			    return depManagedEntity ;
				}
				return null; 
		
			}catch (Exception e) {
				l.error("erreur in desaffecterDepartementDuEntreprise() " + e);
				return null ; 

			}

			}
		//get list of departement
		public List<Departement> getAllDepartements() {
			ArrayList<Departement> list=new ArrayList<>();

	    	try{
				l.info("In getAllDepartements()");
				l.debug("get the list of departement");
				list.add( (Departement) deptRepoistory.findAll());
				l.debug("list get it with succes");
				l.info("Out getAllDepartements()");		
				return list;
	    	} catch (Exception e) {
				l.error("error in getAllDepartements() :"+e);
				list.clear();
				return list;
			}		
		}
		@Transactional
		public void deleteDepartementById(int depId) {
			
			l.debug("deleting departement with id");
			Optional<Departement> value = deptRepoistory.findById(depId);
			if (value.isPresent()) {
				Departement dep=value.get();
			deptRepoistory.delete(dep);
			
			
			l.info("deleted with succes");
			}
			else {
				l.debug("departement not found ");
				l.info("end of ");
			}
		}
		
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.info(" get all department names by entreprise");
		l.debug("searching by od");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		if (value.isPresent()) 
		
		{Entreprise entrepriseManagedEntity= value.get();
			
		l.debug("entreprise found" +entrepriseManagedEntity);
		List<String> depNames = new ArrayList<>();
		
		
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		l.debug("inserting into the table");
		l.info("end of getAllDepartement");
		return depNames;
		}
		else
		{l.debug("entreprise not found");
		l.info("end of getAllDepartement");
		
		return new ArrayList<>();
		}
	}

	public Departement findById(int id) {
		Optional<Departement> departementOptinal = deptRepoistory.findById(id);
		if (departementOptinal.isPresent()) {
			return departementOptinal.get();
		}
		return new Departement();
	}

}
