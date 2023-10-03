package com.doc.doc.repository;

import com.doc.doc.model.Doctorant;
import com.doc.doc.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepo extends JpaRepository<Publication, Long> {

    @Query("SELECT p FROM Publication p JOIN p.auteur ap WHERE ap.auteur.id = :doctorantId")
    List<Publication> findPublicationsByDoctorantId(@Param("doctorantId") Long doctorantId);

    List<Publication> findByAuteurIn(List<Doctorant> doctorants);

}
