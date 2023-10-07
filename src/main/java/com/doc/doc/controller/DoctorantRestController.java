package com.doc.doc.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doc.doc.dto.EtatDto;
import com.doc.doc.dto.PublicationDto;
import com.doc.doc.dto.YearlyAbsenceCount;
import com.doc.doc.model.Doctorant;
import com.doc.doc.model.EtatAvancement;
import com.doc.doc.model.Publication;
import com.doc.doc.model.SujetThese;
import com.doc.doc.repository.AbsenceRepo;
import com.doc.doc.repository.DoctorantRepo;
import com.doc.doc.service.DoctorantServiceImp;
import com.doc.doc.service.SujetTheseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DoctorantRestController {

    private final DoctorantServiceImp doctorantService;
    private final AbsenceRepo absenceRepo;
    private final SujetTheseService sujetTheseService;
    private final DoctorantRepo doctorantRepo;

    @GetMapping("/api/v1/doctorants/{docId}")
    public ResponseEntity<List<Publication>> DoctorantPublication(@PathVariable Long docId) {
        List<Publication> pubs = doctorantService.loadPublications(docId);
        return ResponseEntity.ok(pubs);
    }

    @GetMapping("/api/v1/doctorants/absence/{docId}")
    public ResponseEntity<List<YearlyAbsenceCount>> doctorantAbsence(@PathVariable Long docId) {
        List<Object[]> result = absenceRepo.countAbsencesByYear(docId);

        List<YearlyAbsenceCount> absences = result.stream()
                .map(arr -> new YearlyAbsenceCount((Integer) arr[0], (Long) arr[1], (Long) arr[2]))
                .collect(Collectors.toList());
        return ResponseEntity.ok(absences);
    }

    @GetMapping("/api/v1/doctorants/avancement/{docId}")
    public ResponseEntity<List<EtatDto>> avancement(@PathVariable Long docId) {

        Doctorant doctorant = doctorantRepo.findById(1L).orElse(null); // Get the

        // Doctorant instance
        SujetThese sujetThese = doctorant.getSujetThese();
        List<EtatAvancement> etatsAvancementResult = sujetTheseService.getEtatsAvancementForSujetThese(sujetThese);
        List<EtatDto> etatsAvancement = etatsAvancementResult.stream()
                .map(arr -> {
                    LocalDate localDate = arr.getDate().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                    String monthName = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE);
                    return new EtatDto(arr.getTitle(), arr.getDescription(), monthName, arr.getEvaluation());
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(etatsAvancement);
    }

    @GetMapping("/api/v1/doctorants/publications/{docId}")
    public ResponseEntity<List<PublicationDto>> loadPublications(@PathVariable Long docId) {
        Doctorant doctorant = doctorantRepo.findById(docId).orElse(null); // Get the

        List<Publication> pubs = doctorant.getPublications();
        List<PublicationDto> pubsRes = mapPublicationsToDtos(pubs);
        return ResponseEntity.ok(pubsRes);
    }

    public List<PublicationDto> mapPublicationsToDtos(List<Publication> publications) {
        return publications.stream()
                .map(this::mapPublicationToDto)
                .collect(Collectors.toList());
    }

    public PublicationDto mapPublicationToDto(Publication publication) {
        PublicationDto publicationDto = new PublicationDto();
        publicationDto.setTitle(publication.getTitle());
        publicationDto.setResume(publication.getResume());
        publicationDto.setArticlePDF(publication.getArticlePDF());
        publicationDto.setCodeSourceZIP(publication.getCodeSourceZIP());
        publicationDto.setCertificatePDF(publication.getCertificatePDF());
        publicationDto.setPublicationType(publication.getPublicationType());

        return publicationDto;
    }
}
