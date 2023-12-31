package com.doc.doc.repository;

import com.doc.doc.model.DossierDoctorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierDoctorantRepo extends JpaRepository<DossierDoctorant, Long> {
}
