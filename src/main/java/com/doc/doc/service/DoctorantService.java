package com.doc.doc.service;

import com.doc.doc.dto.AbsenceDTO;
import com.doc.doc.model.Doctorant;
import com.doc.doc.model.Publication;

import java.util.List;

public interface DoctorantService {
    List<Doctorant> loadDoctorants();

    // Récupérez toutes les publications d'un doctorant identifié par son
    // identifiant
    List<Publication> loadPublications(Long id);

    // Une liste d'objets, où chaque objet contient le nombre de réunions tenues au
    // cours
    // d'une année ainsi que le nombre d'absences du doctorant
    List<AbsenceDTO> absence(int id);
}
