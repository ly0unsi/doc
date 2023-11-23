package com.doc.doc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.doc.doc.model.Doctorant;
import com.doc.doc.repository.DoctorantRepo;
import com.doc.doc.service.DoctorantService;
import com.doc.doc.service.DoctorantServiceImp;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DoctorantController {

    private final DoctorantServiceImp doctorantService;
    private final DoctorantRepo doctorantRepo;

    @GetMapping("/doctorants")
    public String listStudents(Model model) {
        List<Doctorant> doctorants = doctorantService.loadDoctorants();
        // for (Doctorant doctorant : doctorants) {
        // System.out.println("oppoge" + doctorant.getApogee());
        // }
        model.addAttribute("doctorants", doctorants);
        return "doctorant/list";
    }

    @GetMapping("/doctorants/{id}")
    public String docDetail(Model model, @PathVariable Long id) {
        List<Doctorant> doctorants = doctorantService.loadDoctorants();
        Doctorant doctorant = doctorantRepo.findById(id).get();

        model.addAttribute("doctorant", doctorant);
        // System.out.println("DocID:" + doctorant.);
        return "doctorant/detail";
    }
}
