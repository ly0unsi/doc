package com.doc.doc.dto;

import java.time.Instant;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EtatDto {
    private String title;
    private String desc;
    private String date;
    private int evaluation;
}
