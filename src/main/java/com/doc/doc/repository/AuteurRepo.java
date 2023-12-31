package com.doc.doc.repository;

import com.doc.doc.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepo extends JpaRepository<Auteur, Long> {
}
