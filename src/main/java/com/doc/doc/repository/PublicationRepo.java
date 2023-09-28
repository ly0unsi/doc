package com.doc.doc.repository;

import com.doc.doc.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepo extends JpaRepository<Publication, Long> {

}
