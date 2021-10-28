package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Departement;

public interface DepartementRepository extends CrudRepository<Departement, Integer>{
	@Query("SELECT count(*) FROM Departement")
    public int countdept();
	
	   @Query("SELECT name FROM Departement")
	    public List<String> departementeNames();
}
