package org.sid.dao;

import java.util.List;

import org.sid.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
	public List<Etudiant> findByScore(int score);

}
