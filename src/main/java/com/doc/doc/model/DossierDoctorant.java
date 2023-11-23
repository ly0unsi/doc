package com.doc.doc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DossierDoctorant extends Doctorant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DossierID")
    private Long dossierID;
    @Column(name = "NumeroReference")
    private String numeroReference;
    private Date inscription;

}
