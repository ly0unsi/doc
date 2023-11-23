package com.doc.doc.repository;

import com.doc.doc.model.DoctorantPublication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorantPublicationRepo extends JpaRepository<DoctorantPublication, Long> {
}
