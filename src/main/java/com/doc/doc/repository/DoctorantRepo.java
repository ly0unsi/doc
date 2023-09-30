package com.doc.doc.repository;

import com.doc.doc.model.Doctorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorantRepo extends JpaRepository<Doctorant, Long> {



}
