package com.doc.doc.repository;

import com.doc.doc.model.Doctorant;
import com.doc.doc.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorantRepo extends JpaRepository<Doctorant, Long> {

}
