package com.doc.doc.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.doc.enums.PublicationType;
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

                Reunion reunion2 = new Reunion(2L, Instant.now(), "Meeting 1", "Discussion 1", null, null);

                Reunion reunion3 = new Reunion(3L, Instant.now(), "Meeting 1", "Discussion 1", null, null);

                Reunion reunion4 = new Reunion(4L, Instant.parse("2024-01-01T00:00:00Z"), "Meeting 1", "Discussion 1",
                                null,
                                null);

                Reunion reunion5 = new Reunion(5L, Instant.parse("2024-01-01T00:00:00Z"), "Meeting 1", "Discussion 1",
                                null,
                                null);

                Reunion reunion6 = new Reunion(6L, Instant.parse("2024-01-01T00:00:00Z"), "Meeting 1", "Discussion 1",
                                null,
                                null);

                List<Reunion> reunions = new ArrayList<>(
                                Arrays.asList(reunion1, reunion2, reunion3, reunion4, reunion5, reunion6));
                reunionRepository.saveAll(reunions);

                Doctorant doctorant1 = insertDoctorant("Abdellah", "LYOUNSI", "abdllahlyounsi@gmail.com",
                                "https://bootdey.com/img/Content/avatar/avatar7.png", reunions);

                Doctorant doctorant2 = insertDoctorant("Salma", "LAGHBISSI", "abdllahlyounsi@gmail.com",
                                "https://bootdey.com/img/Content/avatar/avatar3.png", reunions);

                Doctorant doctorant3 = insertDoctorant("Mohammed", "EDDARIF", "abdllahlyounsi@gmail.com",
                                "https://bootdey.com/img/Content/avatar/avatar6.png", reunions);

                Doctorant doctorant4 = insertDoctorant("Zakia", "ENNOUGOME", "abdllahlyounsi@gmail.com",
                                "https://bootdey.com/img/Content/avatar/avatar3.png", reunions);
                Doctorant doctorant5 = insertDoctorant("Yassine", "ZEGHMOUTI", "abdllahlyounsi@gmail.com",
                                "https://bootdey.com/img/Content/avatar/avatar1.png", reunions);

                Absence absence1 = new Absence(1L, reunion1, doctorant1.getId(), "Not feeling well");
                Absence absence2 = new Absence(2L, reunion2, doctorant2.getId(), "Not feeling well");
                Absence absence3 = new Absence(4L, reunion3, doctorant3.getId(), "Not feeling well");
                Absence absence4 = new Absence(5L, reunion5, doctorant4.getId(), "Not feeling well");
                Absence absence5 = new Absence(6L, reunion6, doctorant4.getId(), "Not feeling well");
                List<Absence> absences = new ArrayList<>(
                                Arrays.asList(absence1, absence2, absence3, absence4, absence5));
                absenceRepository.saveAll(absences);

                SujetThese sujetThese1 = createSujetThese("Sujet1", "Sujet  Description", "Keyword 1, Keyword2 ",
                                doctorant1);
                SujetThese sujetThese2 = createSujetThese("Sujet2  Title", "Sujet  Description", "Keyword 1, Keyword2 ",
                                doctorant2);
                SujetThese sujetThese3 = createSujetThese("Sujet3", "Sujet  Description", "Keyword 1, Keyword2 ",
                                doctorant3);
                SujetThese sujetThese4 = createSujetThese("Sujet4", "Sujet  Description", "Keyword 1, Keyword2 ",
                                doctorant4);
                SujetThese sujetThese5 = createSujetThese("Sujet5", "Sujet  Description", "Keyword 1, Keyword2 ",
                                doctorant5);
                List<SujetThese> sujets = new ArrayList<>(
                                Arrays.asList(sujetThese1, sujetThese2, sujetThese3, sujetThese4, sujetThese5));

                Calendar calendar = Calendar.getInstance();
                Date currentDate = calendar.getTime();
                for (SujetThese sujet : sujets) {
                        for (int i = 1; i <= 5; i++) {
                                Random random = new Random();

                                // Generate a random integer between 10 and 20 (inclusive)
                                int randomNumber = random.nextInt(11) + 10;
                                // Create and save one EtatAvancement instance for each SujetThese
                                EtatAvancement etatAvancement = new EtatAvancement();
                                etatAvancement.setDate(currentDate.toInstant());
                                etatAvancement.setTitle("Etat " + i + " Title");
                                etatAvancement.setDescription(
                                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse blandit luctus mattis. Aenean faucibus pharetra tempor. Nam semper mauris eu dictum facilisis. Duis ac elit elit. Donec nec porta sem, ");
                                etatAvancement.setEvaluation(randomNumber);
                                etatAvancement.setSujetThese(sujet);

                                etatAvancementRepo.save(etatAvancement);

                                calendar.add(Calendar.MONTH, 1);
                                currentDate = calendar.getTime();
                        }

                }

                // Create and save three Publication objects
                Publication publication1 = new Publication();
                publication1.setTitle("Publication 1 Title");
                publication1.setResume("Publication 1 Resume");
                publication1.setCertificatePDF("certificat1.pdf");
                publication1.setCodeSourceZIP("sourcecode.rar");
                publication1.setArticlePDF("article1.pdf");
                publication1.setPublicationType(PublicationType.REVUES);

                // Set other properties for publication1

                Publication publication2 = new Publication();
                publication2.setTitle("Publication 2 Title");
                publication2.setResume("Publication 2 Resume");
                publication2.setCertificatePDF("certificat1.pdf");
                publication2.setCodeSourceZIP("sourcecode.rar");
                publication2.setArticlePDF("article1.pdf");
                publication2.setPublicationType(PublicationType.CONFERENCES);
                // Set other properties for publication2

                Publication publication3 = new Publication();
                publication3.setTitle("Publication 3 Title");
                publication3.setResume("Publication 3 Resume");
                publication3.setCertificatePDF("certificat1.pdf");
                publication3.setCodeSourceZIP("sourcecode.rar");
                publication3.setArticlePDF("article1.pdf");
                publication3.setPublicationType(PublicationType.REVUES);
                // Set other properties for publication3

                List<Publication> publications = new ArrayList<>(
                                Arrays.asList(publication1, publication2, publication3));
                List<Publication> publications2 = new ArrayList<>(
                                Arrays.asList(publication1, publication3));
                List<Publication> publications3 = new ArrayList<>(
                                Arrays.asList(publication2));
                doctorant1.setPublications(publications);
                doctorant2.setPublications(publications2);
                doctorant3.setPublications(publications3);
                doctorant4.setPublications(publications2);
                doctorant5.setPublications(publications3);
                publicationRepo.saveAll(publications);
                List<Doctorant> doctorants = new ArrayList<>(
                                Arrays.asList(doctorant1, doctorant2, doctorant3, doctorant4, doctorant5));
                absenceRepository.saveAll(absences);
                doctorantRepository.saveAll(doctorants);

        }

        public Doctorant insertDoctorant(String fname, String lname, String email, String profile,
                        List<Reunion> reunions) {

                Doctorant doctorant1 = new Doctorant(null, "Apogee1", "CNE1", reunions, null);
                doctorant1.setFname(fname);
                doctorant1.setLname(lname);
                doctorant1.setCin("123456789");
                doctorant1.setEmail(email);
                doctorant1.setPicture(profile);
                doctorant1.setLogin("login");
                doctorant1.setPassword("password");
                doctorant1.setAdresse("Masiira 1");

                doctorant1 = doctorantRepository.save(doctorant1);
                return doctorant1;
        }

        public SujetThese createSujetThese(String title, String description, String motsCles, Doctorant doctorant) {
                SujetThese sujetThese = new SujetThese();
                sujetThese.setTitle(title);
                sujetThese.setDescription(description);
                sujetThese.setMotsCles(motsCles);
                sujetThese.setDoctorant(doctorant);
                return sujetTheseRepo.save(sujetThese);
        }
}
