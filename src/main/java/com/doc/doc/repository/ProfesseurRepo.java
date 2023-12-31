package com.doc.doc.repository;

import com.doc.doc.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepo extends JpaRepository<Professeur, Long> {
}
