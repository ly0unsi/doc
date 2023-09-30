package com.doc.doc.dto;

import com.doc.doc.enums.Année;
import lombok.Data;

@Data
public class AbsenceDTO {
    Année année;
    int nombreReunion;
    int nombreAbsence;
}
