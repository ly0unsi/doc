package com.doc.doc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorantController {

    @GetMapping("/doctorants")
    public String listStudents(Model model) {

        return "doctorant/list";
    }
}
