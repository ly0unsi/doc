package com.doc.doc.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.doc.model.Absence;
import com.doc.doc.model.Doctorant;
import com.doc.doc.model.Personne;
import com.doc.doc.model.Reunion;
import com.doc.doc.model.SujetThese;
import com.doc.doc.repository.AbsenceRepo;
import com.doc.doc.repository.DoctorantRepo;
import com.doc.doc.repository.PersonneRepo;
import com.doc.doc.repository.ReunionRepo;

@Service
public class DemoDataService {

    private final DoctorantRepo doctorantRepository;
    private final AbsenceRepo absenceRepository;
    private final ReunionRepo reunionRepository;
    private final PersonneRepo personneRepository;

    @Autowired
    public DemoDataService(DoctorantRepo doctorantRepository,
            AbsenceRepo absenceRepository,
            ReunionRepo reunionRepository,
            PersonneRepo personneRepository) {
        this.doctorantRepository = doctorantRepository;
        this.absenceRepository = absenceRepository;
        this.reunionRepository = reunionRepository;
        this.personneRepository = personneRepository;
    }

    @Transactional
    public void insertDemoData() {
        // Insert demo data for Personne
        // Personne personne1 = new Personne(1L, "John", "Doe", "12345",
        // "john.doe@example.com", "johndoe", "john",
        // "password", "123 Main St");
        // personneRepository.save(personne1);

        // Insert demo data for Reunion
        Reunion reunion1 = new Reunion(1L, Instant.now(), "Meeting 1", "Discussion 1", null, null);
        reunionRepository.save(reunion1);
        Reunion reunion2 = new Reunion(2L, Instant.now(), "Meeting 1", "Discussion 1", null, null);
        reunionRepository.save(reunion2);
        Reunion reunion3 = new Reunion(3L, Instant.now(), "Meeting 1", "Discussion 1", null, null);
        reunionRepository.save(reunion3);
        Reunion reunion4 = new Reunion(4L, Instant.parse("2024-01-01T00:00:00Z"), "Meeting 1", "Discussion 1", null,
                null);
        reunionRepository.save(reunion4);
        Reunion reunion5 = new Reunion(5L, Instant.parse("2024-01-01T00:00:00Z"), "Meeting 1", "Discussion 1", null,
                null);
        reunionRepository.save(reunion5);
        Reunion reunion6 = new Reunion(6L, Instant.parse("2024-01-01T00:00:00Z"), "Meeting 1", "Discussion 1", null,
                null);
        reunionRepository.save(reunion6);

        // Insert demo data for Absence
        List<Reunion> reunions = new ArrayList<Reunion>();

        Doctorant doctorant1 = new Doctorant(1L, "Apogee1", "CNE1", reunions, null);
        doctorant1.setFname("John");
        doctorant1.setLname("Doe");
        doctorant1.setCin("123456789");
        doctorant1.setEmail("john.doe@example.com");
        doctorant1.setPicture("john.doe@example.com");
        doctorant1.setLogin("login");
        doctorant1.setPassword("password");
        doctorant1.setAdresse("Masiira 1");

        doctorant1 = doctorantRepository.save(doctorant1);

        Absence absence1 = new Absence(1L, reunion1, doctorant1.getId(), "Not feeling well");
        Absence absence2 = new Absence(2L, reunion2, doctorant1.getId(), "Not feeling well");
        Absence absence3 = new Absence(3L, reunion4, doctorant1.getId(), "Not feeling well");

        absenceRepository.save(absence1);
        absenceRepository.save(absence2);
        absenceRepository.save(absence3);

        // Associate doctorant1 with reunion1
        doctorant1.getReunions().add(reunion1);
        doctorant1.getReunions().add(reunion2);
        doctorant1.getReunions().add(reunion3);
        doctorant1.getReunions().add(reunion4);
        doctorantRepository.save(doctorant1);
    }
}
