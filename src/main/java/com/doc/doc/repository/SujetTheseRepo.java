package com.doc.doc.repository;

import com.MGLC.activitesdoctorants.entities.SujetThese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetTheseRepo extends JpaRepository<SujetThese, Long> {
}
