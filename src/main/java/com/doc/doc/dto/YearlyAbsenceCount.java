package com.doc.doc.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class YearlyAbsenceCount {
    private int date;
    private long absences;
    private long total;
}
