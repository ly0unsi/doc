package com.doc.doc.service;

import com.doc.doc.dto.AbsenceDTO;
import com.doc.doc.model.Doctorant;
import com.doc.doc.model.Publication;
import com.doc.doc.repository.DoctorantRepo;
import com.doc.doc.repository.PublicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DoctorantServiceImp implements DoctorantService {
    @Autowired
    private DoctorantRepo doctorantRepo;
    @Autowired
    private PublicationRepo publicationRepo;

    @Override
    public List<Doctorant> loadDoctorants() {
        return doctorantRepo.findAll();
    }

    @Override
    public List<Publication> loadPublications(Long docid) {
        Doctorant doctorant = doctorantRepo.findById(docid).orElse(null);
        List<Doctorant> doctorants = Arrays.asList(doctorant);
        return publicationRepo.findPublicationsByDoctorantId(docid);
    }

    @Override
    public List<AbsenceDTO> absence(int id) {
        int nombreAbsence;
        int nombreReunion;
        // getAllReunion by year
        // iterate over all reunions and check if Doctorant is absent if so incrment
        // nombreAbsence
        return null;
    }
}
