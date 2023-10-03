package com.doc.doc.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.doc.doc.model.Auteur;
import com.doc.doc.model.AuteurPublication;

@Repository
public interface AuteurPublicationRepo extends JpaRepository<AuteurPublication, Long> {

}
