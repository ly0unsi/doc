package com.doc.doc.repository;

import com.MGLC.activitesdoctorants.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Personne, Long> {

}
