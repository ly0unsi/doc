package com.doc.doc.repository;

import com.doc.doc.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {
}
