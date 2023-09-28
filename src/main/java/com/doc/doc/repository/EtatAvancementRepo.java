package com.doc.doc.repository;

import com.doc.doc.model.EtatAvancement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatAvancementRepo extends JpaRepository<EtatAvancement, Long> {
}
