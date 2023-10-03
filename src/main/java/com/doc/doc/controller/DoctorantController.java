package com.doc.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.doc.doc.model.Doctorant;
import com.doc.doc.service.DoctorantService;
import com.doc.doc.service.DoctorantServiceImp;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DoctorantController {

    private final DoctorantServiceImp doctorantService;

    @GetMapping("/doctorants")
    public String listStudents(Model model) {
        List<Doctorant> doctorants = doctorantService.loadDoctorants();
        // for (Doctorant doctorant : doctorants) {
        // System.out.println("oppoge" + doctorant.getApogee());
        // }
        model.addAttribute("doctorants", doctorants);
        return "doctorant/list";
    }
}
