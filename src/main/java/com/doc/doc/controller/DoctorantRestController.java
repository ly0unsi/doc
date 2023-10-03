package com.doc.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doc.doc.model.Doctorant;
import com.doc.doc.model.Publication;
import com.doc.doc.service.DoctorantServiceImp;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DoctorantRestController {

    private final DoctorantServiceImp doctorantService;

    @GetMapping("/api/v1/doctorants/{docId}")
    public ResponseEntity<List<Publication>> DoctorantPublication(@PathVariable Long docId) {
        List<Publication> pubs = doctorantService.loadPublications(docId);
        return ResponseEntity.ok(pubs);
    }
}
