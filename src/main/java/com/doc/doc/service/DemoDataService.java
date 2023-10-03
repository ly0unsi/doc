package com.doc.doc.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.doc.model.Absence;
import com.doc.doc.model.Auteur;
import com.doc.doc.model.AuteurPublication;
import com.doc.doc.model.Doctorant;
import com.doc.doc.model.EtatAvancement;
import com.doc.doc.model.Personne;
import com.doc.doc.model.Publication;
import com.doc.doc.model.Reunion;
import com.doc.doc.model.SujetThese;
import com.doc.doc.repository.AbsenceRepo;
import com.doc.doc.repository.AuteurPublicationRepo;
import com.doc.doc.repository.AuteurRepo;
import com.doc.doc.repository.DoctorantRepo;
import com.doc.doc.repository.EtatAvancementRepo;
import com.doc.doc.repository.PersonneRepo;
import com.doc.doc.repository.PublicationRepo;
import com.doc.doc.repository.ReunionRepo;
import com.doc.doc.repository.SujetTheseRepo;

@Service
public class DemoDataService {

    private final DoctorantRepo doctorantRepository;
    private final AbsenceRepo absenceRepository;
    private final ReunionRepo reunionRepository;
    private final SujetTheseRepo sujetTheseRepo;
    private final EtatAvancementRepo etatAvancementRepo;
    private final AuteurRepo auteurRepo;
    private final PublicationRepo publicationRepo;
    private final AuteurPublicationRepo auteurPublicationRepo;

    @Autowired
    public DemoDataService(DoctorantRepo doctorantRepository,
            AbsenceRepo absenceRepository,
            ReunionRepo reunionRepository,
            SujetTheseRepo sujetTheseRepo,
            EtatAvancementRepo etatAvancementRepo,
            PublicationRepo publicationRepo,
            AuteurRepo auteurRepo,
            AuteurPublicationRepo auteurPublicationRepo) {
        this.doctorantRepository = doctorantRepository;
        this.absenceRepository = absenceRepository;
        this.reunionRepository = reunionRepository;
        this.sujetTheseRepo = sujetTheseRepo;
        this.etatAvancementRepo = etatAvancementRepo;
        this.publicationRepo = publicationRepo;
        this.auteurRepo = auteurRepo;
        this.auteurPublicationRepo = auteurPublicationRepo;
    }

    @Transactional
    public void insertDemoData() {

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
        doctorant1.getReunions().add(reunion5);
        doctorantRepository.save(doctorant1);

        SujetThese sujetThese = new SujetThese();
        sujetThese.setTitle("Sujet  Title");
        sujetThese.setDescription("Sujet  Description");
        sujetThese.setMotsCles("Keyword 1, Keyword2 ");
        sujetThese.setDoctorant(doctorant1);
        sujetTheseRepo.save(sujetThese);

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        for (int i = 1; i <= 5; i++) {
            // Create and save one EtatAvancement instance for each SujetThese
            EtatAvancement etatAvancement = new EtatAvancement();
            etatAvancement.setDate(currentDate.toInstant());
            etatAvancement.setTitle("Etat " + i + " Title");
            etatAvancement.setDescription(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse blandit luctus mattis. Aenean faucibus pharetra tempor. Nam semper mauris eu dictum facilisis. Duis ac elit elit. Donec nec porta sem, ");
            etatAvancement.setEvaluation(i + 7);
            etatAvancement.setSujetThese(sujetThese);

            etatAvancementRepo.save(etatAvancement);

            calendar.add(Calendar.MONTH, 1);
            currentDate = calendar.getTime();
        }

        // Create three Auteur objects
        Auteur auteur1 = new Auteur();
        auteur1.setRole("Role 1");

        // Set other properties for auteur1

        Auteur auteur2 = new Auteur();
        auteur2.setRole("Role 2");
        // Set other properties for auteur2

        Auteur auteur3 = new Auteur();
        auteur3.setRole("Role 3");
        // Set other properties for auteur3

        List<Auteur> auteurs = new ArrayList<>(Arrays.asList(auteur1, auteur2, auteur3));

        auteurRepo.saveAll(auteurs);

        // Create and save three Publication objects
        Publication publication1 = new Publication();
        publication1.setTitle("Publication 1 Title");
        publication1.setResume("Publication 1 Resume");
        // Set other properties for publication1

        Publication publication2 = new Publication();
        publication2.setTitle("Publication 2 Title");
        publication2.setResume("Publication 2 Resume");
        // Set other properties for publication2

        Publication publication3 = new Publication();
        publication3.setTitle("Publication 3 Title");
        publication3.setResume("Publication 3 Resume");
        // Set other properties for publication3

        List<Publication> publications = new ArrayList<>(Arrays.asList(publication1, publication2, publication3));

        publicationRepo.saveAll(publications);

        // Create and save AuteurPublication records to associate authors with
        // publications
        AuteurPublication auteurPublication1 = new AuteurPublication();
        auteurPublication1.setAuteur(auteur1);
        auteurPublication1.setPublication(publication1);

        AuteurPublication auteurPublication2 = new AuteurPublication();
        auteurPublication2.setAuteur(auteur2);
        auteurPublication2.setPublication(publication2);

        AuteurPublication auteurPublication3 = new AuteurPublication();
        auteurPublication3.setAuteur(auteur3);
        auteurPublication3.setPublication(publication3);

        auteurPublicationRepo.saveAll(Arrays.asList(auteurPublication1, auteurPublication2, auteurPublication3));
    }
}
