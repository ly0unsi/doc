package com.doc.doc.repository;

import com.doc.doc.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {

    List<Absence> findByDoctorant(Long doctorantId);
}
