package com.doc.doc.repository;

import com.doc.doc.model.EtatAvancement;
import com.doc.doc.model.SujetThese;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetTheseRepo extends JpaRepository<SujetThese, Long> {

}
