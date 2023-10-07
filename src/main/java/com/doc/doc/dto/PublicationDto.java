package com.doc.doc.dto;

import javax.persistence.Column;

import com.doc.doc.enums.PublicationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDto {
    private String title;

    private String resume;

    private String articlePDF;
    private String codeSourceZIP;
    private String CertificatePDF;

    private PublicationType publicationType;
}
