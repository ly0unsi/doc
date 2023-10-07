package com.doc.doc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doc.doc.model.EtatAvancement;
import com.doc.doc.model.SujetThese;
import com.doc.doc.repository.EtatAvancementRepo;
import com.doc.doc.repository.SujetTheseRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SujetTheseService {
    private final EtatAvancementRepo etatAvancementRepo;

    public List<EtatAvancement> getEtatsAvancementForSujetThese(SujetThese sujetThese) {
        return etatAvancementRepo.findBySujetThese(sujetThese);
    }
}
