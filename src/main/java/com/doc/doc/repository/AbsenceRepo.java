package com.doc.doc.repository;

import com.doc.doc.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {

    List<Absence> findByDoctorant(Long doctorantId);

    @Query("SELECT YEAR(a.reunion.date) AS year, COUNT(*) AS absenceCount, " +
            "(SELECT COUNT(r) FROM Reunion r WHERE :doctorantId IN (SELECT d.id FROM r.listParticipants d) AND YEAR(r.date) = YEAR(a.reunion.date)) AS totalReunions "
            +
            "FROM Absence a " +
            "WHERE a.doctorant= :doctorantId " +
            "GROUP BY YEAR(a.reunion.date)")
    List<Object[]> countAbsencesByYear(@Param("doctorantId") Long doctorantId);

}
