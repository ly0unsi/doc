package com.doc.doc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EtatAvancement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EtatAvancementId")
    private Long id;

    @Column(name = "Date")
    private Instant date;
    @Column(name = "Titre")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Evaluation")
    private String evaluation;
}
