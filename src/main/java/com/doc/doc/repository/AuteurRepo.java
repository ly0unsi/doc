package com.doc.doc.repository;

import com.MGLC.activitesdoctorants.entities.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepo extends JpaRepository<Auteur, Long> {
}
